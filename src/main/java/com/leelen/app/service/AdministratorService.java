/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:51:38
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.leelen.entitys.Administrator;
import com.leelen.entitys.R;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl
 *
 */
public interface AdministratorService {

	// 添加管理员
	RespEntity save(HttpServletRequest request, Administrator administrator);

	// 获取所有管理员
	List<Administrator> getAllAdministrator();

	// 获取所有有效管理员 isuse=0有效
	List<Administrator> getAllAdministrator(int isuse);

	// 改变管理员的状态
	RespEntity UpDateAdministratorOfIsuse(int isuse, String tell);

	// 管理员登录
	RespEntity adminLogin(String accounttell, String password, long timestamp, String sign);// account、tell都可以登录

	// 修改密码
	RespEntity modifyAdminPassword(String token, String oldpwd, String newpwd, long timestamp, String sign);

	// 重置密码
	RespEntity resetAdminPassword(String token, long timestamp, String sign);

	// 手机号更改
	RespEntity updateAdminTell(String token, String tell, long timestamp, String sign);

	// 修改信息
	R updateAdmin(Administrator administrator);

	// 获取我管理的小区
	RespEntity getMyPlot(String aid);

	// ...

}
