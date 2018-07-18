/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:09:40
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

/**
 * @author xiaoxl 角色权限表
 *
 */
public interface RolePermissionService {

	// 根据角色id获取对应权限
	String[] getPermissionByRole(String roleid);

	// 根据权限判断对应角色id
	boolean getRoleByPermission(String opid);

	// ...
}
