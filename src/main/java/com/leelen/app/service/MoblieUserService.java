/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:55:04
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.leelen.entitys.MoblieUser;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl 移动端用户信息
 *
 */
public interface MoblieUserService {

	// 用户注册
	RespEntity save(MoblieUser moblieUser);

	// 登录
	RespEntity login(String tell, String password, String sign, long timestamp, int isplatform);

	// 重置密码
	public RespEntity resetUserPassword(String token, long timestamp, String sign) throws ParseException;

	// 修改密码
	public RespEntity modifyUserPassword(String oldpwd, String token, String password, long timestamp, String sign)
			throws ParseException;

	// 退出登录
	public Map<String, Object> userLogout(String token, long timestamp, String sign);

	// 业主获取成员
	RespEntity getMember(String token, long timestamp, String sign);

	// 业主修改成员
	RespEntity updateUser(String username, String tell, String uid);// uid是业主id,要判断小区是否可以

	// 业主删除成员
	RespEntity deleteUser(String uid);

	void updateToken(String token, String tokentime, String tell);

	// -----------------------------------------------------------
	List<MoblieUser> getMoblieUser();

	MoblieUser findByUid(String uid);

	MoblieUser findByToken(String token);

}
