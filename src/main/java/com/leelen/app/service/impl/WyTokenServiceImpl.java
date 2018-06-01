/**
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.WyTokenRepository;
import com.leelen.app.service.WyTokenService;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.WyToken;

/**
 * @author xiaoxl by male
 * @time 2018年5月19日下午4:59:50
 * @class WyTokenServiceImpl.java
 */
@Service
public class WyTokenServiceImpl implements WyTokenService {

	@Autowired
	WyTokenRepository wyTokenRepository;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.WyTokenService#getTokenByAid(java.lang.String)
	 */
	@Override
	public RespEntity getTokenByAid(String aid) {
		// TODO Auto-generated method stub
		WyToken wyToken = wyTokenRepository.findByAid(aid);
		return new RespEntity(RespCode.SUCCESS, wyToken);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.WyTokenService#updateToken(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */

	@Override
	public int updateToken(String aid, String token, String tokentime) {
		// TODO Auto-generated method stub
		return wyTokenRepository.updateToken(aid, token, tokentime);
	}

	@Override
	public RespEntity modifyToken(String aid, String token, String tokentime) {
		// TODO Auto-generated method stub
		if (wyTokenRepository.updateToken(aid, token, tokentime) == 1) {
			return new RespEntity(RespCode.SUCCESS, null);
		} else {
			return new RespEntity(RespCode.MODIFY_ERROR, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.WyTokenService#getAidByToken(java.lang.String)
	 */
	@Override
	public WyToken getAidByToken(String token) {
		// TODO Auto-generated method stub
		return wyTokenRepository.findByToken(token);
	}

}
