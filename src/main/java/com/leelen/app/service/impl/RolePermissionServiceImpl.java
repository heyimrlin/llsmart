/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:15:00
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.RolePermissionRepository;
import com.leelen.app.service.RolePermissionService;
import com.leelen.entitys.RolePermission;

/**
 * @author xiaoxl
 *
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	Logger logger = LoggerFactory.getLogger(getClass());

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	RolePermissionRepository rolePermissionRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.RolePermissionService#getPermissionByRole()
	 */
	@Override
	public String[] getPermissionByRole(String roleid) {
		// TODO Auto-generated method stub
		List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleid(roleid);
		String[] sArrays = new String[rolePermissions.size()];
		for (int i = 0; i < rolePermissions.size(); i++) {
			sArrays[i] = rolePermissions.get(i).getOpid();
		}
		logger.info("该管理员拥有" + sArrays + "权限");
		/*
		 * String[] sArrays = new String[devices.size()];
		 * 
		 * for (int i = 0; i < devices.size(); i++) { sArrays[i] =
		 * devices.get(i).getDeviceid(); } System.out.println(">>>" + sArrays.length +
		 * sArrays[0]); logger.info("该管理员有" + sArrays.length + "小区"); List<MachineInfo>
		 * machineInfos = machineInfoRepository.findByDevicestatusAndDeviceidIn(0,
		 * sArrays);
		 */
		return sArrays;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.RolePermissionService#getRoleByPermission()
	 */
	@Override
	public boolean getRoleByPermission(String opid) {
		// TODO Auto-generated method stub
		return false;
	}

}
