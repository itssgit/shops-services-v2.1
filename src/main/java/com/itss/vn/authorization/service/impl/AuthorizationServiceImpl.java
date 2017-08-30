package com.itss.vn.authorization.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.itss.vn.authorization.model.AuthorizationRequest;
import com.itss.vn.authorization.service.AuthorizationService;
import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.common.exception.ErrorResponse;
import com.itss.vn.common.exception.RestException;
import com.itss.vn.common.utils.HashUtils;
import com.itss.vn.common.utils.SSBeanUtils;
import com.itss.vn.shops.dto.AccountDTO;
import com.itss.vn.shops.entity.Account;
import com.itss.vn.shops.entity.RolePermission;
import com.itss.vn.shops.repository.AccountRepository;
import com.itss.vn.shops.repository.RolePermissionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorizationServiceImpl implements AuthorizationService{
	
	@Autowired
	private AuthorizationServerEndpointsConfiguration endpoint;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${oauth2.admin.id}")
	private String clientId;
	
	@Value("${oauth2.admin.header}")
	private String clientHeader;
	
	@Value("${oauth2.server.authorizationUri}")
	private String authorizationUri;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private DefaultTokenServices defaultTokenServices;
	
	@Autowired
	private RolePermissionRepository rolePermissionRepository;
	
	@Override
	public OAuth2AccessToken authorize(AuthorizationRequest authorizationRequest) {
		
		authorizationRequest.validate();
		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("Content_type", "application/json");
			httpHeaders.add(clientHeader, clientId);
			
			HttpEntity<Object> httpRequest = new HttpEntity<Object>(authorizationRequest, httpHeaders);
			UriComponents endpoint = UriComponentsBuilder.fromHttpUrl(authorizationUri).queryParams(params).build();
			
			ResponseEntity<OAuth2AccessToken> httpResponse = restTemplate.exchange(endpoint.toUri(), HttpMethod.POST, 
						httpRequest, new ParameterizedTypeReference<OAuth2AccessToken>() {});
			if(httpResponse.getStatusCode().is2xxSuccessful()) {
				return httpResponse.getBody();
			}
			throw new BadRequestException("Username/Password incorrect");
		} catch (HttpStatusCodeException e) {
			String message = "";
			try {
				message = new ObjectMapper().readValue(e.getResponseBodyAsString(), ErrorResponse.class).getMessage();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			throw new RestException(e.getRawStatusCode(), message);
		}
	}
	
	@Override
	public Account authorizeAccount(AuthorizationRequest authorizationRequest) {
		authorizationRequest.validate();
		
		Account account = accountRepository.findByUserName(authorizationRequest.getUserName());
		if(account == null) {
			throw new BadRequestException("User not found");
		}
		
		if(!HashUtils.compareToHash(authorizationRequest.getPassWord(), account.getPassWord())) {
			throw new BadRequestException("Password not match");
		}
		return account;
	}
	
	@Override
	@Transactional
	public OAuth2AccessToken generateAccessToken(Account account, String clientId) {
		ClientDetails clientDetails = null;
		try {
			clientDetails = endpoint.getEndpointsConfigurer().getClientDetailsService().loadClientByClientId(clientId);
		} catch (Exception ex) {
			log.debug("client [{{}}] not found", clientId);
			throw new BadRequestException("client not found");
		}
		
		if(clientDetails == null) {
			log.debug("client [{{}}] not found", clientId);
			throw new BadRequestException("client not found");
		}
		// limit the number of generated token
		Collection<OAuth2AccessToken> oauth2AccessTokens = tokenStore.findTokensByClientIdAndUserName(clientDetails.getClientId(), account.getUserName());
		if(oauth2AccessTokens != null && oauth2AccessTokens.size() >= 2) {
			log.info("[{}] session limit exceeded [2]", account.getUserName());
			throw new RestException(429, "Session limit exceeded [2]");
		}
		Map<String, String> requestParameters = new HashMap<>();
		Map<String, Serializable> extensionProperties = new HashMap<>();
		
		boolean approved = true;
		Set<String> responseTypes = new HashSet<String>();
		responseTypes.add("code");
		
		String role = account.getRole().getName();
//		List<String> scopes = new ArrayList<>();
		
		// Authorities
		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
		
		List<RolePermission> rolePermissions = rolePermissionRepository.findByRole(account.getRole());
		if(rolePermissions != null) {
			for(RolePermission rolePermission : rolePermissions) {
				SimpleGrantedAuthority authority =  new SimpleGrantedAuthority("ROLE_" + 
														rolePermission.getPermission().getName().toString());
				authorities.add(authority);
			}
		}
		
		OAuth2Request oauth2Request = new OAuth2Request(requestParameters, clientDetails.getClientId(), 
					authorities, approved, null, clientDetails.getResourceIds(), null, responseTypes, extensionProperties);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(account.getUserName(), "N/A", authorities);
		OAuth2Authentication auth = new OAuth2Authentication(oauth2Request, authenticationToken);
		OAuth2AccessToken token = defaultTokenServices.createAccessToken(auth);
		
		return token;
	}
	
	@Override
	public AccountDTO getAuthenticatedUser() {
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//		String userName = (String) request.getAttribute(RequestInfoInterceptor.X_SS_USERNAME);
		String userName;
		Object princial = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(princial instanceof UserDetails) {
			userName = ((UserDetails)princial).getUsername();
		} else {
			userName = princial.toString();
		}
		
		if(StringUtils.isNotEmpty(userName)) {
			Account account = accountRepository.findByUserName(userName);
			if(account == null) {
				throw new RestException(404, "Account could not be found");
			}
			AccountDTO accountResponse = new AccountDTO();
			SSBeanUtils.copyPropertiesIgnoreNull(account, accountResponse);
			
			return accountResponse;
		}
		throw new BadRequestException("Khong the xac thuc nguoi dung");
	}
	
	@Override
	public void revokeToken(String tokenValue) {
		// TODO Auto-generated method stub
		defaultTokenServices.revokeToken(tokenValue);
	}

}
