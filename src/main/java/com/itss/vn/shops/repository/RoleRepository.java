package com.itss.vn.shops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itss.vn.shops.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findById(Integer id);

}
