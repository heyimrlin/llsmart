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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.leelen.app.dao.MoblieUserDao;
import com.leelen.app.repository.MoblieUserRepository;
import com.leelen.app.repository.RoomRepository;
import com.leelen.app.repository.SysUserRepository;
import com.leelen.app.repository.UnitRepository;
import com.leelen.app.repository.UserPlotRepository;
import com.leelen.app.service.MoblieUserService;
import com.leelen.app.service.PlotInfoService;
import com.leelen.app.service.SysUserService;
import com.leelen.app.service.UserPlotService;
import com.leelen.entitys.MoblieUser;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.SysUser;
import com.leelen.entitys.Unit;
import com.leelen.entitys.UserPlot;
import com.leelen.publicmethod.MyMethod;
import com.leelen.utils.MD5Tools;
import com.leelen.utils.Ramdata;

/**
 * @author xiaoxl
 *
 */
@Service
public class MoblieUserServiceImpl implements MoblieUserService {

	Logger logger = LoggerFactory.getLogger(getClass());

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat dateFormatert = new SimpleDateFormat("yyyyMMddHHmmss");
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

	@Autowired
	UnitRepository unitRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	UserPlotRepository userPlotRepository;

	@Resource
	PlotInfoService plotInfoService;

	/*
	 * (non-Javadoc) 移动端注册时，平台用户表同时保存数据
	 * 
	 * @see
	 * com.leelen.app.service.MoblieUserService#save(com.leelen.entitys.MoblieUser)
	 */
	@Override
	public RespEntity save(HttpServletResponse response, HttpServletRequest request, String sign, long timestamp,
			String tell, String password, String smsCode) {
		// TODO Auto-generated method stub
		// 判断是否已注册、平台是否配置了...
		MoblieUser moblieUser = new MoblieUser();
		moblieUser.setTell(tell);
		moblieUser.setPassword(password);
		MoblieUser moblieUserv = moblieUserDao.findUserByTell(moblieUser.getTell());
		String dateStr = dateFormatert.format(date);

		String StrSign = "/yz/app/register?timestamp" + timestamp;
		if (!MyMethod.verdictSign(StrSign, sign)) {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}

		if (!MD5Tools.MD5(getCode(response, request)).equals(smsCode)) {
			return new RespEntity(RespCode.CODE_ERROR, null);
		}

		if (moblieUserv == null) {
			// 生成uid,保存用户数据
			SysUser sysUser = sysUserService.checkUserInMoblie(moblieUser.getTell());
			if (sysUser == null) {
				String uid = dateStr + Ramdata.ramdaSw(4);
				moblieUser.setUid(uid);
				moblieUser.setRegistertime(dateStr);
				moblieUser.setIsplatform(1);
				moblieUserRepository.save(moblieUser);
				sysUserService.save(uid, 0, 0);
				return new RespEntity(RespCode.REGISTER_SUCCESS, uid);
			} else {
				moblieUser.setUid(sysUser.getUid());
				moblieUser.setRegistertime(dateStr);
				moblieUser.setIsplatform(0);
				moblieUserRepository.save(moblieUser);
				return new RespEntity(RespCode.REGISTER_SUCCESS, sysUser.getUid());
			}
		} else {
			return new RespEntity(RespCode.TELL_REGISTER, null);
			// 不为空，平台已配置
			// String uid = moblieUserv.getUid();
			// // 判断是否已注册
			// SysUser sysUser = sysUserService.checkUserInMoblie(moblieUser.getTell());
			// if (sysUser != null && sysUser.getMobilerg() == 0) {
			// return new RespEntity(RespCode.TELL_REGISTER, null);
			// } else {
			// // 根据uid更新用户数据
			// if (moblieUserDao.updateMoblieuser(password, dateFormater.format(date), uid)
			// == 1) {
			// return new RespEntity(RespCode.REGISTER_SUCCESS, null);
			// } else {
			// return new RespEntity(RespCode.REGISTER_FAIL, null);
			// }
			// }
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
		String tokentime = dateFormater.format(date.getTime() + 1000 * 3600 * 24 * 2);
		if (!MyMethod.verdictSign(StrSign, sign)) {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}
		long tl = new Date().getTime();
		logger.info("系统时间:" + tl + "\t参数:" + timestamp);
		// if (!(tl - 3000 < timestamp && timestamp < tl + 10000)) {
		// return new RespEntity(RespCode.INVALID_REQUEST, null);
		// }
		MoblieUser moblieUser = moblieUserDao.findUserByTell(tell);
		if (moblieUser == null) {
			return new RespEntity(RespCode.TELL_NOTREGISTER, null);
		}
		String token = MyMethod.GetGUID();
		if (moblieUser.getIsplatform() != 0) {
			updateToken(token, tokentime, tell);
			JSONObject json = new JSONObject();
			json.put("nickname", tell);
			json.put("token", MyMethod.GetGUID());
			json.put("tokenValidity", tokentime);
			json.put("plot", "无小区");
			return new RespEntity(RespCode.SUCCESS, json);
		}
		SysUser sysUsert = sysUserService.getUserStatus(tell);
		if (sysUsert.getUseable() != 0) {
			// updateToken(token, MyMethod.getDate(), tell);
			// JSONObject json = new JSONObject();
			// json.put("token", MyMethod.GetGUID());
			return new RespEntity(RespCode.FORBID_LOGIN, null);
		} else {
			updateToken(token, tokentime, tell);
			JSONObject json = new JSONObject();
			json.put("nickname", sysUsert.getNickname());
			json.put("token", token);
			json.put("tokenValidity", tokentime);
			json.put("plot", userPlotService.getPlotByUid(moblieUser.getUid()));
			return new RespEntity(RespCode.SUCCESS, json);
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

		String StrSign = "/yz/app/resetPwd?token=" + token + "&timestamp=" + timestamp;
		if (!MyMethod.verdictSign(StrSign, sign)) {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}

		long dt = new Date().getTime();
		logger.info("timestamp:" + timestamp + "\t" + "systemtime:" + dt);// 123
		if (dt - 1000 * 6 > timestamp) {
			return new RespEntity(RespCode.INVALID_REQUEST, null);
		}
		if ((dt + 1000 * 6) < timestamp) {
			return new RespEntity(RespCode.INVALID_REQUEST, null);
		}

		if (moblieUser != null
				&& MyMethod.formatDate(moblieUser.getTokentime()).getTime() >= dt - 2 * 24 * 60 * 60 * 1000) {
			if (moblieUserRepository.resetPwd(MD5Tools.MD5("12345678"), token) == 1) {
				// String newToken = MyMethod.GetGUID();
				// moblieUserRepository.updateToken(newToken, MyMethod.getDate(),
				// moblieUser.getTell());
				// JSONObject json = new JSONObject();
				// json.put("token", newToken);
				return new RespEntity(RespCode.RESET_SUCCESS, null);
			} else {
				return new RespEntity(RespCode.MODIFY_ERROR, null);
			}
		} else {
			return new RespEntity(RespCode.TOKEN_INVALID, null);
		}
	}

	/*
	 * (non-Javadoc) 修改密码
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
					// String newToken = MyMethod.GetGUID();
					// moblieUserRepository.updateToken(newToken, MyMethod.getDate(),
					// moblieUser.getTell());//更新token
					// JSONObject json = new JSONObject();
					// json.put("token", newToken);

					return new RespEntity(RespCode.MODIFY_SUCCESS, null);
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
	 * (non-Javadoc)修改成员信息
	 * 
	 * @see com.leelen.app.service.MoblieUserService#updateUser(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public RespEntity updateUser(String token, long timestamp, String sign, String uid, String nickname, String tell) {
		// TODO Auto-generated method stub
		// 业主修改成员信息

		// 签名匹配
		String StrSign = "/yz/app/resetPwd?token=" + token + "&timestamp=" + timestamp;
		if (!MyMethod.verdictSign(StrSign, sign)) {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}

		if (moblieUserRepository.updateUserInfo(nickname, tell, uid) == 0) {
			return new RespEntity(RespCode.MODIFY_ERROR, null);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#deleteUser(java.lang.String)
	 */
	@Override
	public RespEntity deleteUser(String token, long timestamp, String sign, String uid) {
		// TODO Auto-generated method stub
		String StrSign = "/yz/app/deleteMember?token=" + token + "&timestamp=" + timestamp;
		if (MyMethod.verdictSign(StrSign, sign)) {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}
		// 进行伪删除
		sysUserService.updataUserStatus(1, sysUserRepository.findByUid(uid).getTell());
		return new RespEntity(RespCode.DELETE_USER, null);
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
	 * (non-Javadoc)获取我的指定小区下的有效成员 获取指定项目下有效成员
	 * 
	 * @see com.leelen.app.service.MoblieUserService#getMember(java.lang.String)
	 */
	@Override
	public RespEntity getMember(String token, long timestamp, String sign, String plotid) {
		// TODO Auto-generated method stub
		MoblieUser moblieUser = moblieUserRepository.findByToken(token);
		List<SysUser> sysUsers = sysUserRepository.findByFamilyhost(moblieUser.getUid());// 通过uid获取成员
		String[] uids = new String[sysUsers.size()];// 获取成员uid
		for (int i = 0; i < sysUsers.size(); i++) {
			uids[i] = sysUsers.get(i).getUid();
		}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#findByUid(java.lang.String)
	 */
	@Override
	public MoblieUser findByUid(String uid) {
		// TODO Auto-generated method stub
		return moblieUserRepository.findByUid(uid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#findByToken(java.lang.String)
	 */
	@Override
	public MoblieUser findByToken(String token) {
		// TODO Auto-generated method stub
		return moblieUserRepository.findByToken(token);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#addMember(java.lang.String,
	 * long, java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public RespEntity addMember(String token, long timestamp, String sign, String nickname, String tell, String plotid,
			String buildingid, String roomid) {
		// TODO Auto-generated method stub
		//
		// 签名匹配
		String StrSign = "/yz/app/addMember?token=" + token + "&timestamp=" + timestamp;
		if (!MyMethod.verdictSign(StrSign, sign)) {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}
		// 判断该小区是否支持添加成员
		if (plotInfoService.getPlotinfo(plotid).getIssupportadduser() != 0) {
			return new RespEntity(RespCode.NOT_SUPPORTADDUSER, null);
		}
		// 判断该成员是否添加过
		if (moblieUserRepository.findByTell(tell) != null) {
			return new RespEntity(RespCode.USER_ADDED, null);
		}
		MoblieUser moblieUser = moblieUserRepository.findByToken(token);

		// 判断是否为业主
		if (sysUserRepository.findByUid(moblieUser.getUid()).getHouserole() != 0) {
			return new RespEntity(RespCode.NOT_YZ, null);
		}

		String dateStr = dateFormatert.format(date);

		String uid = dateStr + Ramdata.ramdaSw(4);

		Unit unit = unitRepository.findByUnitid(buildingid);
		UserPlot userPlot = new UserPlot();
		userPlot.setUid(uid);
		userPlot.setPlotid(plotid);
		userPlot.setPlotname(plotInfoService.getPlotinfo(plotid).getPlotname());
		userPlot.setBuildingname(unit.getUnitname());
		userPlot.setRoom(roomRepository.findByRoomid(roomid).getRoomname());
		// 保存成员所在小区、单元、房间
		userPlotRepository.save(userPlot);

		// 用户表
		MoblieUser newMoblieUser = new MoblieUser();
		newMoblieUser.setTell(tell);
		newMoblieUser.setUid(uid);
		newMoblieUser.setPassword(MD5Tools.MD5("12345678"));
		newMoblieUser.setRegistertime(dateStr);
		moblieUserRepository.save(newMoblieUser);

		SysUser sysUser = new SysUser();
		sysUser.setUid(uid);
		sysUser.setNickname(nickname);
		sysUser.setTell(tell);
		sysUser.setCreator(sysUserRepository.findByUid(moblieUser.getUid()).getNickname());
		sysUser.setHouserole(1);
		sysUser.setAddtime(dateStr);
		sysUser.setMobilerg(0);
		sysUser.setUseable(0);
		sysUser.setFamilyhost(moblieUser.getUid());
		sysUserRepository.save(sysUser);

		// MoblieUser moblieUser = moblieUserDao.findUserByToken(token);
		// if() {
		//
		// }

		return new RespEntity(RespCode.ADD_SAVE, uid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#modifyTell()
	 */
	@Override
	public RespEntity modifyTell(String token, String tell, String code) {
		// TODO Auto-generated method stub

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MoblieUserService#modifyUsername()
	 */
	@Override
	public RespEntity modifyUsername(String token, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.MoblieUserService#platformishave(java.lang.String)
	 */
	@Override
	public MoblieUser platformishave(String tell) {
		// TODO Auto-generated method stub
		return moblieUserRepository.findByTell(tell);
	}

	/**
	 * <p>
	 * Title: getMyPlots
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param uid
	 * @return
	 * @see com.leelen.app.service.MoblieUserService#getMyPlots(java.lang.String)
	 */

	@Override
	public RespEntity getMyPlots(String token, long timestamp, String sign) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		MoblieUser moblieUser = moblieUserRepository.findByToken(token);
		json.put("plot", userPlotService.getPlotByUid(moblieUser.getUid()));
		return new RespEntity(RespCode.SUCCESS, json);
	}

	public String getCode(HttpServletResponse response, HttpServletRequest request) {
		System.out.println("验证码");
		try {
			String code = getCookieByName(request, "code").getValue();
			if ("".equals(code)) {
				logger.info("请重新获取验证码");
				return "请重新获取验证码";
			} else {
				Cookie cookie = new Cookie("code", code);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				System.out.println("被删除的cookie名字为:" + cookie.getName());
				response.addCookie(cookie);
				logger.info("验证码:" + code);
				return code;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		logger.info("请重新获取验证码");
		return "请重新获取验证码";
	}

	/**
	 * 根据名字获取cookie
	 * 
	 * @param request
	 * @param name
	 *            cookie名字
	 * @return
	 */
	public Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	/**
	 * 将cookie封装到Map里面
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

}
