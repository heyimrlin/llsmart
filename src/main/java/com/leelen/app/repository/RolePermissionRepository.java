/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:25:01
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.RolePermission;

/**
 * @author xiaoxl
 *
 */
public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {

	List<RolePermission> findByRoleid(String roleid);
}
