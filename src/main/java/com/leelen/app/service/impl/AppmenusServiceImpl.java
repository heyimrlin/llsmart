/**
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.AppmenusRepository;
import com.leelen.app.repository.RolePermissionRepository;
import com.leelen.app.service.AppmenusService;
import com.leelen.entitys.Appmenus;
import com.leelen.entitys.RolePermission;

/**
 * @author xiaoxl by male
 * @time 2018年6月26日下午2:08:12
 * @class AppmenusServiceImpl.java
 */
@Service
public class AppmenusServiceImpl implements AppmenusService {

	@Autowired
	RolePermissionRepository rolePermissionRepository;

	@Autowired
	AppmenusRepository appmenusRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.AppmenusService#getAppmenusByRole(java.lang.String)
	 */
	@Override
	public List<Appmenus> getAppmenusByRoleid(String roleid) {
		// TODO Auto-generated method stub
		List<RolePermission> rolePermissions = rolePermissionRepository.findByRoleid(roleid);
		String[] sArrays = new String[rolePermissions.size()];

		for (int i = 0; i < rolePermissions.size(); i++) {
			sArrays[i] = rolePermissions.get(i).getOpid();
		}
		System.out.println(">>>" + sArrays.length + sArrays[0]);
		List<Appmenus> appmenus = appmenusRepository.findByOpidIn(sArrays);

		return appmenus;
	}

}
