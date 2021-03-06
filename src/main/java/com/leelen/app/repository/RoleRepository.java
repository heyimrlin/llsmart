/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:24:18
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Role;

/**
 * @author xiaoxl
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

	// 根据角色id
	Role findByRoleid(String roleid);
}
