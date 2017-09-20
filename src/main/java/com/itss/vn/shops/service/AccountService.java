package com.itss.vn.shops.service;

import com.itss.vn.common.model.ListResponse;
import com.itss.vn.shops.dto.AccountDTO;

public interface AccountService {
	
//	Optional<Account> getAccountByLoginId(String loginId);
	
	AccountDTO getOneUser(int id);
	
	ListResponse<AccountDTO> getUsers(String searchText);
	
//	Integer addAccount(AccountDTO accountRequest);
	
//	Account checkUser(String userName, String passWord);

}
