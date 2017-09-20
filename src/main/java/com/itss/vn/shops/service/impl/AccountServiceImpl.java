package com.itss.vn.shops.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itss.vn.common.model.ListResponse;
import com.itss.vn.shops.dto.AccountDTO;
import com.itss.vn.shops.entity.Account;
import com.itss.vn.shops.repository.AccountRepository;
import com.itss.vn.shops.repository.RoleRepository;
import com.itss.vn.shops.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	/*@Override
	public Optional<Account> getAccountByLoginId(String loginId) {
		return accountRepository.findByLoginId(loginId);
	}*/
	
	@Override
	public AccountDTO getOneUser(int id) {

		Account account = accountRepository.findOne(id);
		AccountDTO response = new AccountDTO(account);

		return response;
	}

	@Override
	public ListResponse<AccountDTO> getUsers(String searchText) {
		// TODO Auto-generated method stub
		List<Account> accountList = accountRepository.findAllAccount();
		List<AccountDTO> results = new ArrayList<>();
		if(accountList.size() > 0) {
			for(Account account : accountList) {
				AccountDTO accountDTO = new AccountDTO(account);
				results.add(accountDTO);
			}
		}
		ListResponse<AccountDTO> responses = new ListResponse<>();
		responses.setList(results);
		responses.setTotalCount((long)results.size());
		return responses;
	}
	
	/*@Override
	public Integer addAccount(AccountDTO accountRequest) {
		Account newAccount = new Account();
		Account accountCheck;
		if (accountRequest.getRoleId() != null && accountRequest.getRoleId() > 0) {
			Role role = roleRepository.findById((Integer) accountRequest.getRoleId());

			if (role == null)
				throw new BadRequestException("Role is invalid");

			newAccount.setRole(role);
		}
		accountCheck = accountRepository.findByUserName(accountRequest.getUserName().trim());
		if(accountCheck != null) {
			throw new BadRequestException("Account existed");
		}
		MPBeanUtils.copyProperties(accountRequest, newAccount, "id");
		if(accountRequest.getPassWord() == null) {
			accountRequest.setPassWord("abc13579");
		}
		newAccount.setPassword(new BCryptPasswordEncoder().encode(accountRequest.getPassWord()));
		try {
			accountRepository.save(newAccount);
		} catch(Exception ex) {
			throw new BadRequestException("Can not save account");
		}
		return newAccount.getId();
	}*/
	
	/*@Override
	public Account checkUser(String userName, String passWord) {
		try {
			Account user = accountRepository.findByUserName(userName.trim());
			if(user == null || !new BCryptPasswordEncoder().matches(passWord, user.getPassword())) {
				return null;
			} else {
				return user;
			}
		} catch (Exception ex) {
			
		}
		return null;
	}*/

}
