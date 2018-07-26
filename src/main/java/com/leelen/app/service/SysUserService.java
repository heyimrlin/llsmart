/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:10:22
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import com.leelen.entitys.RespEntity;
import com.leelen.entitys.SysUser;

/**
 * @author xiaoxl 平台配置用户
 *
 */
public interface SysUserService {

	// 配置用户
	void save(String uid, int i, int j);

	// 检查是否移动端已注册
	SysUser checkUserInMoblie(String tell);

	// 修改用户状态
	RespEntity updataUserStatus(int useable, String tell);

	int modifyUserStatus(int useable, String tell);

	// 获取用户状态
	SysUser getUserStatus(String tell);// 移动端接口要此判断

	// 修改用户信息
	RespEntity updateUserInfo(SysUser sysUser);

	// 查询用户状态
	// SysUser getUserStatus(String tell);

	// ...
}
