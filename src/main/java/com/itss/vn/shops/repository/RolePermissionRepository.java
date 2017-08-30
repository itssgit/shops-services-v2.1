package com.itss.vn.shops.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itss.vn.shops.entity.Role;
import com.itss.vn.shops.entity.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer>{
	
	@Query("select rp from RolePermission rp where rp.rolePermission=:role")
	List<RolePermission> findByRole(@Param("role") Role role);

}
