package com.itss.vn.authorization.configuration;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.StringUtils;

@Configuration
@EnableAuthorizationServer
@Order(-1)
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Value("${oauth2.admin.id}") 
	private String adminClientId;
	
	@Value("${oauth2.admin.secret}")  
	private String adminClientSecret;
	
	@Value("${oauth2.admin.resourceId}") 
	private String adminResourceId;
	
	@Value("${oauth2.admin.tokenValiditySeconds}") 
	private String adminTokenValiditySeconds;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Bean
	public ClientDetails adminApi() {
		Collection<String> scope = new HashSet<>();
		scope.add("read");
		
		Collection<String> authorizeGrantTypes = new HashSet<>();
		authorizeGrantTypes.add("authorization_code");
		
		BaseClientDetails clientDetails = new BaseClientDetails();
		clientDetails.setClientId(adminClientId);
		clientDetails.setClientSecret(adminClientSecret);
		clientDetails.setScope(scope);
		clientDetails.setResourceIds(StringUtils.commaDelimitedListToSet(adminResourceId));
		clientDetails.setAccessTokenValiditySeconds(Integer.parseInt("3600"));
		clientDetails.setAuthorizedGrantTypes(authorizeGrantTypes);
		return clientDetails;
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			.tokenKeyAccess("isAuthenticated()")
			.checkTokenAccess("permitAll()");
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetailsService());
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		.tokenStore(tokenStore)
		.authenticationManager(authenticationManager);
	}
	
	@Bean
	public ClientDetailsService clientDetailsService() {
		Map<String, ClientDetails> clientDetailsStore = new HashMap<String, ClientDetails>();
		
        clientDetailsStore.put(adminClientId, adminApi());

        InMemoryClientDetailsService clientDetailsService = new InMemoryClientDetailsService();
        clientDetailsService.setClientDetailsStore(clientDetailsStore);

        return clientDetailsService;
	}
	
	@Bean
	@Primary
	@Qualifier
	public DefaultTokenServices defaultTokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore);
		defaultTokenServices.setClientDetailsService(clientDetailsService());
		defaultTokenServices.setAuthenticationManager(authenticationManager);
	    return defaultTokenServices;
	}
}
