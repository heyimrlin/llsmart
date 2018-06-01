/**
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import com.leelen.entitys.RespEntity;
import com.leelen.entitys.WyToken;

/**
 * @author xiaoxl by male
 * @time 2018年5月19日下午4:58:03
 * @class WyTokenService.java
 */
public interface WyTokenService {

	// 根据管理员ID获取token
	RespEntity getTokenByAid(String aid);

	// 更新Token
	RespEntity modifyToken(String aid, String token, String tokentime);

	int updateToken(String aid, String token, String tokentime);

	// 根据token获取管理员id
	WyToken getAidByToken(String token);

	// ...
}
