/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:20:57
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Permission;

/**
 * @author xiaoxl
 *
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
