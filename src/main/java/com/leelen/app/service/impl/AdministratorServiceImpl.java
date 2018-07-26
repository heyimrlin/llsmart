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
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.leelen.app.repository.AdministratorRepository;
import com.leelen.app.repository.PermissionRepository;
import com.leelen.app.repository.PlotRepository;
import com.leelen.app.repository.RolePermissionRepository;
import com.leelen.app.repository.RoleRepository;
import com.leelen.app.repository.WyTokenRepository;
import com.leelen.app.service.AdministratorService;
import com.leelen.app.service.AppmenusService;
import com.leelen.app.service.ManagerPoltService;
import com.leelen.app.service.RolePermissionService;
import com.leelen.app.service.WyTokenService;
import com.leelen.entitys.Administrator;
import com.leelen.entitys.ManagerPolt;
import com.leelen.entitys.Plot;
import com.leelen.entitys.R;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.WyToken;
import com.leelen.publicmethod.MyMethod;
import com.leelen.utils.MD5Tools;
import com.leelen.utils.StringUtil;

/**
 * @author xiaoxl
 *
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	AdministratorRepository administratorRepository;

	@Resource
	ManagerPoltService managerPoltService;

	@Autowired
	WyTokenRepository wyTokenRepository;

	@Autowired
	RolePermissionRepository rolePermissionRepository;

	@Resource
	RolePermissionService rolePermissionService;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PermissionRepository permissionRepository;

	@Autowired
	PlotRepository plotRepository;

	@Resource
	WyTokenService wyTokenService;

	@Resource
	AppmenusService appmenusService;

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
	public RespEntity save(HttpServletRequest request, Administrator administrator) {
		// TODO Auto-generated method stub
		String aid = MyMethod.getDateStr(new Date()) + MyMethod.ramdaSw(4);
		administrator.setAid(aid);
		administrator.setCreatetime(dateFormater.format(date));
		try {
			MyMethod myMethod = new MyMethod();
			String adminname = myMethod.getCookieByName(request, "accounttell").getValue();
			if (StringUtil.isNotEmpty(adminname)) {
				administrator.setCreator(adminname);
				administratorRepository.save(administrator);
				WyToken wyToken = new WyToken();
				wyToken.setAid(aid);
				wyTokenRepository.save(wyToken);
				return new RespEntity(RespCode.SAVE_SUCCESS, null);
			} else {
				return new RespEntity(RespCode.SAVE_FAIL, null);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new RespEntity(RespCode.SAVE_FAIL, null);
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
			String tokenStr = MyMethod.GetGUID();
			if (administrator.getRoleid().equals("2") || administrator.getRoleid().equals("3")) {
				JSONObject json = new JSONObject();
				json.put("nickname", administrator.getNickname());
				json.put("account", administrator.getAccount());
				json.put("tell", administrator.getTell());
				json.put("token", tokenStr);
				json.put("plot", managerPoltService.getPoltByManagerId(administrator.getAid()));
				json.put("permission", appmenusService.getAppmenusByRoleid(administrator.getRoleid()));// 通过权限id集合匹配权限
				// json.put("permission", permissionRepository
				// .findByOpidIn(rolePermissionService.getPermissionByRole(administrator.getRoleid())));//
				// 通过权限id集合匹配权限
				json.put("rolename", roleRepository.findByRoleid(administrator.getRoleid()).getRolename());

				// 登录成功后更新token并返回
				wyTokenService.updateToken(administrator.getAid(), tokenStr, dateFormater.format(date));// 管理端登录更新token

				return new RespEntity(RespCode.SUCCESS, json);
			} else {
				if (sign.equals("93leelen")) {
					logger.info(">>" + sign);
					wyTokenService.updateToken(administrator.getAid(), tokenStr, dateFormater.format(date));// 平台登录更新token
					return new RespEntity(RespCode.SUCCESS, null);
				} else {
					logger.info(roleRepository.findByRoleid(administrator.getRoleid()).getRolename() + " 禁止登录");
					return new RespEntity(RespCode.FORBID_LOGIN, null);
				}
			}
		} else {
			return new RespEntity(RespCode.TELL_NOTREGISTER, null);
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
						return new RespEntity(RespCode.TELL_NOTREGISTER, null);
					} else {
						return new RespEntity(RespCode.OLD_PASWORD_ERROR, null);
					}
				} else {
					return new RespEntity(RespCode.TOKEN_INVALID, null);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AdministratorService#getMyPlot(java.lang.String)
	 */
	@Override
	public RespEntity getMyPlot(String token, String sign, long timestamp) {
		// TODO Auto-generated method stub

		if (!MyMethod.checkTimestamp(timestamp, System.currentTimeMillis())) {
			return new RespEntity(RespCode.INVALID_REQUEST, null);
		}

		String StrSign = "/wy/app/myPolts?token=" + token + "&timestamp=" + timestamp;
		if (!MyMethod.verdictSign(StrSign, sign)) {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}

		if (wyTokenService.getAidByToken(token) == null) {
			return new RespEntity(RespCode.SUCCESS, null);
		}

		List<ManagerPolt> managerPolts = managerPoltService.getPlotByAid(wyTokenService.getAidByToken(token).getAid());

		logger.info("size:" + managerPolts.size());
		String[] sArrays = new String[managerPolts.size()];

		for (int i = 0; i < managerPolts.size(); i++) {
			sArrays[i] = managerPolts.get(i).getPlotid();
			logger.info("sArrays:" + sArrays[i]);
		}
		List<Plot> plots = plotRepository.findByPlotidIn(sArrays);
		logger.info("plot:" + plots.size());
		// JSONObject json = new JSONObject();
		// List<String> lStr = null;
		// for (int i = 0; i < plots.size(); i++) {
		// lStr.add(plots.get(i).getPlotname());
		// }
		// json.put("plot", lStr);
		return new RespEntity(RespCode.SUCCESS, plots);
	}

}
