/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:15:00
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.leelen.app.service.RolePermissionService;
import com.mysql.fabric.xmlrpc.base.Array;

/**
 * @author xiaoxl
 *
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.RolePermissionService#getPermissionByRole()
	 */
	@Override
	public Array[] getPermissionByRole() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.RolePermissionService#getRoleByPermission()
	 */
	@Override
	public boolean getRoleByPermission() {
		// TODO Auto-generated method stub
		return false;
	}

}
