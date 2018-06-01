/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:14:28
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.leelen.app.service.RoleService;
import com.leelen.entitys.Role;

/**
 * @author xiaoxl
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.RoleService#save(com.leelen.entitys.Role)
	 */
	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub

	}

}
