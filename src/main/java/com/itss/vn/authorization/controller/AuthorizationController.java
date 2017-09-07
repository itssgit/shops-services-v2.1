package com.itss.vn.authorization.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itss.vn.common.exception.BadRequestException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itss.vn.authorization.model.AuthorizationRequest;
import com.itss.vn.authorization.service.AuthorizationService;
import com.itss.vn.common.model.CommonResponse;
import com.itss.vn.shops.dto.AccountDTO;
import com.itss.vn.shops.entity.Account;

@RestController
@RequestMapping(value = "/authorization")
@Api(tags = {"Authorization"})
public class AuthorizationController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Value("${oauth2.admin.header}")
	private String clientHeader;
	
	@Value("${oauth2.admin.id}")
	private String clientId;
	
	@Value("${oauth2.cookie.token.name}")
	private String cookieName;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CommonResponse<OAuth2AccessToken> authorizeToken(
				HttpServletResponse response,
				@RequestBody AuthorizationRequest authorizationRequest) {
	    CommonResponse<OAuth2AccessToken> res = new CommonResponse<>();
	    try {
            Account account = authorizationService.authorizeAccount(authorizationRequest);
            OAuth2AccessToken token = authorizationService.generateAccessToken(account, clientId);
            Cookie cookie = new Cookie(cookieName, token.getValue());
            cookie.setHttpOnly(true);
            cookie.setMaxAge(3600);
            cookie.setPath("/");
            response.addCookie(cookie);
            res.successfulRespone(token);
        } catch (BadRequestException e) {
            res.failedRespone(null, e.getMessage());
        }
        return res;

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public CommonResponse<String> revokeToken(
				HttpServletRequest request) {
		CommonResponse<String> response = new CommonResponse<>();
		String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("bearer")){
            String tokenValue = authorization.substring("bearer".length()+1).trim();

            authorizationService.revokeToken(tokenValue);
            response.successfulRespone(tokenValue);
        }
        else {
        	response.failedRespone(null);
        }
        return response;
	}
	
	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public AccountDTO getAuthenticatedUser(HttpServletRequest request) {
		AccountDTO accountResponse = authorizationService.getAuthenticatedUser();
		
		return accountResponse;
	}
	
}
