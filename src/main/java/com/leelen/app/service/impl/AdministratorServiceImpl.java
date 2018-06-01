/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:20:52
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.leelen.app.repository.AdministratorRepository;
import com.leelen.app.repository.WyTokenRepository;
import com.leelen.app.service.AdministratorService;
import com.leelen.app.service.ManagerPoltService;
import com.leelen.entitys.Administrator;
import com.leelen.entitys.R;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.WyToken;
import com.leelen.publicmethod.MyMethod;
import com.leelen.utils.MD5Tools;

/**
 * @author xiaoxl
 *
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	AdministratorRepository administratorRepository;

	@Resource
	ManagerPoltService managerPoltService;

	@Autowired
	WyTokenRepository wyTokenRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AdministratorService#getAllAdministrator()
	 */
	@Override
	public List<Administrator> getAllAdministrator() {
		// TODO Auto-generated method stub
		return administratorRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AdministratorService#getAllAdministrator(int)
	 */
	@Override
	public List<Administrator> getAllAdministrator(int isuse) {
		// TODO Auto-generated method stub
		return administratorRepository.findByIsuse(isuse);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.AdministratorService#UpDateAdministratorOfIsuse(java.
	 * lang.String)
	 */
	@Override
	public RespEntity UpDateAdministratorOfIsuse(int isuse, String tell) {
		// TODO Auto-generated method stub
		if (administratorRepository.updateuseable(isuse, tell) == 1) {
			return new RespEntity(RespCode.SUCCESS, null);
		} else {
			return new RespEntity(RespCode.MODIFY_ERROR, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AdministratorService#save(com.leelen.entitys.
	 * Administrator)
	 */
	@Override
	public RespEntity save(Administrator administrator) {
		// TODO Auto-generated method stub
		administratorRepository.save(administrator);
		return new RespEntity(RespCode.SUCCESS, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AdministratorService#adminLogin(java.lang.String,
	 * java.lang.String, long, java.lang.String)
	 */
	@Override
	public RespEntity adminLogin(String tellaccount, String password, long timestamp, String sign) {
		// TODO Auto-generated method stub

		Administrator administrator = administratorRepository.findByTellOrAccountAndPasswordAndIsuse(tellaccount,
				tellaccount, password, 0);
		if (administrator != null) {
			JSONObject json = new JSONObject();
			json.put("nickname", administrator.getNickname());
			json.put("account", administrator.getAccount());
			json.put("tell", administrator.getTell());
			json.put("token", MyMethod.GetGUID());
			json.put("plot", managerPoltService.getPoltByManagerId(administrator.getAid()));
			return new RespEntity(RespCode.SUCCESS, json);
		} else {
			return new RespEntity(RespCode.TELL_NotRegister, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.AdministratorService#modifyAdminPassword(java.lang.
	 * String, java.lang.String, java.lang.String, long, java.lang.String)
	 */
	@Override
	public RespEntity modifyAdminPassword(String token, String oldpwd, String newpwd, long timestamp, String sign) {
		// TODO Auto-generated method stub
		String StrSign = "/wy/app/modifyPwd?token=" + token + "&oldpwd=" + oldpwd + "&newpwd=" + newpwd + "&timestamp="
				+ timestamp;
		if (MyMethod.verdictSign(StrSign, sign)) {
			WyToken wyToken = wyTokenRepository.findByToken(token);
			if (wyToken != null) {
				if (MyMethod.formatDate(wyToken.getTokentime()).getTime() > new Date().getTime()) {
					if (administratorRepository.findByAid(wyToken.getAid()).getPassword().equals(oldpwd)) {
						administratorRepository.modifyAdminPassword(newpwd, wyToken.getAid());
						return new RespEntity(RespCode.TELL_NotRegister, null);
					} else {
						return new RespEntity(RespCode.OLD_PASWORD_ERROR, null);
					}
				} else {
					return new RespEntity(RespCode.TOKEN_Invalid, null);
				}
			} else {
				return new RespEntity(RespCode.TOKEN_ERROR, null);
			}
		} else {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.AdministratorService#resetAdminPassword(java.lang.
	 * String, long, java.lang.String)
	 */
	@Override
	public RespEntity resetAdminPassword(String token, long timestamp, String sign) {
		// TODO Auto-generated method stub
		if (administratorRepository.resetAdminPassword(MD5Tools.MD5("A123456"), token) == 1) {
			return new RespEntity(RespCode.SUCCESS, null);
		} else {
			return new RespEntity(RespCode.MODIFY_ERROR, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.AdministratorService#updateAdminTell(java.lang.String,
	 * long, java.lang.String)
	 */
	@Override
	public RespEntity updateAdminTell(String token, String tell, long timestamp, String sign) {
		// TODO Auto-generated method stub
		if (administratorRepository.updateAdminTell(tell, token) == 1) {
			return new RespEntity(RespCode.SUCCESS, null);
		} else {
			return new RespEntity(RespCode.MODIFY_ERROR, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.AdministratorService#updateAdmin(com.leelen.entitys.
	 * Administrator)
	 */
	@Override
	public R updateAdmin(Administrator administrator) {
		// TODO Auto-generated method stub
		return null;
	}

}
