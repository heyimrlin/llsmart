/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:17:15
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.leelen.app.dao.MoblieUserDao;
import com.leelen.app.repository.MoblieUserRepository;
import com.leelen.app.repository.SysUserRepository;
import com.leelen.app.service.MoblieUserService;
import com.leelen.app.service.SysUserService;
import com.leelen.app.service.UserPlotService;
import com.leelen.entitys.MoblieUser;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.SysUser;
import com.leelen.publicmethod.MyMethod;
import com.leelen.utils.MD5Tools;

/**
 * @author xiaoxl
 *
 */
@Service
public class MoblieUserServiceImpl implements MoblieUserService {

	Logger logger = LoggerFactory.getLogger(getClass());

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	MoblieUserDao moblieUserDao;

	@Autowired
	SysUserRepository sysUserRepository;

	@Resource
	SysUserService sysUserService;

	@Resource
	UserPlotService userPlotService;

	@Autowired
	MoblieUserRepository moblieUserRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.MoblieUserService#save(com.leelen.entitys.MoblieUser)
	 */
	@Override
	public RespEntity save(MoblieUser moblieUser) {
		// TODO Auto-generated method stub
		// 判断是否已注册、平台是否配置了...
		if (moblieUserDao.findUserByTell(moblieUser.getTell()) == null) {

			return new RespEntity(RespCode.SUCCESS, null);
		} else {
			return new RespEntity(RespCode.TELL_REGISTER, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#login(java.lang.String,
	 * java.lang.String, java.lang.String, long, int)
	 */
	@Override
	public RespEntity login(String tell, String password, String sign, long timestamp, int isplatform) {
		// TODO Auto-generated method stub
		// 判断是否已注册、平台是否配置了...
		String StrSign = "/yz/app/login?tell=" + tell + "&password=" + password + "&timestamp=" + timestamp;
		if (MyMethod.verdictSign(StrSign, sign)) {
			long tl = new Date().getTime();
			logger.info("系统时间:" + tl + "\t参数:" + timestamp);
			if (tl - 3000 < timestamp && timestamp < tl + 10000) {
				MoblieUser moblieUser = moblieUserDao.findUserByTell(tell);
				if (moblieUser != null) {
					SysUser sysUser = sysUserService.getUserStatus(tell);
					String token = MyMethod.GetGUID();
					if (sysUser.getUseable() == 0) {
						updateToken(token, MyMethod.getDate(), tell);
						JSONObject json = new JSONObject();
						json.put("nickname", sysUser.getNickname());
						json.put("token", token);
						json.put("plot", userPlotService.getPlotByUid(moblieUser.getUid()));
						return new RespEntity(RespCode.SUCCESS, json);
					} else {
						JSONObject json = new JSONObject();
						json.put("token", MyMethod.GetGUID());
						return new RespEntity(RespCode.PLATFORM_NO_USER, json);
					}
				} else {
					return new RespEntity(RespCode.TELL_NOTREGISTER, null);
				}
			} else {
				return new RespEntity(RespCode.INVALID_REQUEST, null);
			}
		} else {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.MoblieUserService#resetUserPassword(java.lang.String,
	 * long, java.lang.String)
	 */
	@Override
	public RespEntity resetUserPassword(String token, long timestamp, String sign) throws ParseException {
		// TODO Auto-generated method stub
		MoblieUser moblieUser = moblieUserRepository.findByToken(token);
		if (moblieUser != null && MyMethod.formatDate(moblieUser.getTokentime()).getTime() >= new Date().getTime()
				- 7 * 24 * 60 * 60 * 1000) {
			if (moblieUserRepository.resetPwd(MD5Tools.MD5("12345678"), token) == 1) {
				String newToken = MyMethod.GetGUID();
				moblieUserRepository.updateToken(newToken, MyMethod.getDate(), moblieUser.getTell());
				JSONObject json = new JSONObject();
				json.put("token", newToken);
				return new RespEntity(RespCode.SUCCESS, json);
			} else {
				return new RespEntity(RespCode.MODIFY_ERROR, null);
			}
		} else {
			return new RespEntity(RespCode.TOKEN_INVALID, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.MoblieUserService#modifyUserPassword(java.lang.String,
	 * java.lang.String, java.lang.String, long, java.lang.String)
	 */
	@Override
	public RespEntity modifyUserPassword(String oldpwd, String token, String password, long timestamp, String sign)
			throws ParseException {
		// TODO Auto-generated method stub
		// 先判断token是否有效
		MoblieUser moblieUser = moblieUserRepository.findByToken(token);
		if (moblieUser != null && MyMethod.formatDate(moblieUser.getTokentime()).getTime() >= new Date().getTime()) {
			if (moblieUser.getPassword().equals(oldpwd)) {
				if (moblieUserRepository.modifyPwd(password, token) == 1) {
					// token会更新
					String newToken = MyMethod.GetGUID();
					moblieUserRepository.updateToken(newToken, MyMethod.getDate(), moblieUser.getTell());
					JSONObject json = new JSONObject();
					json.put("token", newToken);

					return new RespEntity(RespCode.SUCCESS, json);
				} else {
					return new RespEntity(RespCode.MODIFY_ERROR, null);
				}
			} else {
				return new RespEntity(RespCode.OLD_PASWORD_ERROR, null);
			}
		} else {
			return new RespEntity(RespCode.TOKEN_INVALID, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#userLogout(java.lang.String,
	 * long, java.lang.String)
	 */
	@Override
	public Map<String, Object> userLogout(String token, long timestamp, String sign) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		if (moblieUserRepository.loginout(1, token) == 1) {
			map.put("code", 0);
			map.put("msg", "退出成功");
			return map;
		} else {
			map.put("code", 4208);
			map.put("msg", "退出失败");
			return map;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#updateUser(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public RespEntity updateUser(String username, String tell, String uid) {
		// TODO Auto-generated method stub
		// 业主修改成员信息
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#deleteUser(java.lang.String)
	 */
	@Override
	public RespEntity deleteUser(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#updateToken(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void updateToken(String token, String tokentime, String tell) {
		// TODO Auto-generated method stub
		moblieUserRepository.updateToken(token, tokentime, tell);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#getMember(java.lang.String)
	 */
	@Override
	public RespEntity getMember(String token, long timestamp, String sign) {
		// TODO Auto-generated method stub
		MoblieUser moblieUser = moblieUserRepository.findByToken(token);
		List<SysUser> sysUsers = sysUserRepository.findByFamilyhost(moblieUser.getUid());
		return new RespEntity(RespCode.SUCCESS, sysUsers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#getMoblieUser()
	 */
	@Override
	public List<MoblieUser> getMoblieUser() {
		// TODO Auto-generated method stub
		return moblieUserRepository.findAll();
	}

}
