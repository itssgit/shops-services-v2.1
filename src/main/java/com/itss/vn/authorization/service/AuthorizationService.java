package com.itss.vn.authorization.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.itss.vn.authorization.model.AuthorizationRequest;
import com.itss.vn.shops.dto.AccountDTO;
import com.itss.vn.shops.entity.Account;

public interface AuthorizationService {
	
	OAuth2AccessToken authorize(AuthorizationRequest authorizationRequest);
	
	Account authorizeAccount(AuthorizationRequest authorizationRequest);
	
	OAuth2AccessToken generateAccessToken(Account account, String cliendId);
	
	AccountDTO getAuthenticatedUser();
	
	void revokeToken(String tokenValue);

}
