package com.itss.vn.shops.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itss.vn.shops.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query("select u from Account u where u.userName=:loginId")
	public Optional<Account> findByLoginId(@Param("loginId") String loginId);
	
	@Query("select u from Account u where u.userName=:userName")
	public Account findByUserName(@Param("userName") String userName);
}
