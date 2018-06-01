/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:13:22
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.UserBuletoothRepository;
import com.leelen.app.service.UserBuletoothService;
import com.leelen.entitys.UserBuletooth;

/**
 * @author xiaoxl
 *
 */
@Service
public class UserBuletoothServiceImpl implements UserBuletoothService {

	@Autowired
	UserBuletoothRepository userBuletoothRepository;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.UserBuletoothService#save(com.leelen.entitys.
	 * UserBuletooth)
	 */
	@Override
	public void save(UserBuletooth userBuletooth) {
		// TODO Auto-generated method stub
		userBuletoothRepository.save(userBuletooth);
	}

}
