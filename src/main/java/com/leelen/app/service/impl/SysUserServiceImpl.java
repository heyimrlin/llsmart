/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:13:49
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.SysUserRepository;
import com.leelen.app.service.SysUserService;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.SysUser;

/**
 * @author xiaoxl
 *
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	SysUserRepository sysUserRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.SysUserService#save(com.leelen.entitys.SysUser)
	 */
	@Override
	public void save(String uid, int i, int j) {
		// TODO Auto-generated method stub
		SysUser sysUser = new SysUser();
		sysUser.setUid(uid);
		sysUser.setMobilerg(i);
		sysUser.setUseable(i);
		sysUserRepository.save(sysUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.SysUserService#checkUserInMoblie(java.lang.String)
	 */
	@Override
	public SysUser checkUserInMoblie(String tell) {
		// TODO Auto-generated method stub
		SysUser sysUser = sysUserRepository.findByTell(tell);
		return sysUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.SysUserService#updataUserStatus(java.lang.String)
	 */
	@Override
	public RespEntity updataUserStatus(int useable, String tell) {
		// TODO Auto-generated method stub
		if (sysUserRepository.updateuseable(useable, tell) == 1) {
			return new RespEntity(RespCode.SUCCESS, null);
		} else {
			return new RespEntity(RespCode.MODIFY_ERROR, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.SysUserService#getUserStatus(java.lang.String)
	 */
	@Override
	public SysUser getUserStatus(String tell) {
		// TODO Auto-generated method stub
		return sysUserRepository.findByTell(tell);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.SysUserService#updateUserInfo(com.leelen.entitys.
	 * SysUser)
	 */
	@Override
	public RespEntity updateUserInfo(SysUser sysUser) {
		// TODO Auto-generated method stub
		return sysUserRepository.updateUserInfo(sysUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.SysUserService#modifyUserStatus(int,
	 * java.lang.String)
	 */
	@Override
	public int modifyUserStatus(int useable, String tell) {
		// TODO Auto-generated method stub
		return sysUserRepository.updateuseable(useable, tell);
	}

}
