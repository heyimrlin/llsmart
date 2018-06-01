/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:16:24
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.PermissionRepository;
import com.leelen.app.service.PermissionService;
import com.leelen.entitys.Permission;

/**
 * @author xiaoxl 权限配置
 *
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionRepository permissionRepository;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.PermissionService#save(com.leelen.entitys.Permission)
	 */
	@Override
	public void save(Permission permission) {
		// TODO Auto-generated method stub
		permissionRepository.save(permission);
	}

}
