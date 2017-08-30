package com.itss.vn.authorization.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itss.vn.common.exception.BadRequestException;
import com.itss.vn.shops.entity.Account;
import com.itss.vn.shops.entity.RolePermission;
import com.itss.vn.shops.repository.AccountRepository;
import com.itss.vn.shops.repository.RolePermissionRepository;


@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RolePermissionRepository rolePermissionRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Account account = accountRepository.findByUserName(username);
		if(account == null) {
			throw new BadRequestException("Can't find username");
		}
//		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		SimpleGrantedAuthority authority =  new SimpleGrantedAuthority("ROLE_" + account.getRole().toString());
//		authorities.add(authority);
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		List<RolePermission> rolePermissions = rolePermissionRepository.findByRole(account.getRole());
		if(rolePermissions != null) {
			for(RolePermission rolePermission : rolePermissions) {
				SimpleGrantedAuthority authority =  new SimpleGrantedAuthority("ROLE_" + 
														rolePermission.getPermission().getName().toString());
				authorities.add(authority);
			}
		}
		
		return new org.springframework.security.core.userdetails.User(account.getUserName(), account.getPassWord(), authorities);
	}
	
	public UserServiceImpl() {
		
	}

}
