/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:19:30
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.AppvRepository;
import com.leelen.app.service.AppvService;
import com.leelen.entitys.Appv;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl
 *
 */
@Service
public class AppvServiceImpl implements AppvService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	AppvRepository appvRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AppvService#getAppV()
	 */
	@Override
	public RespEntity getAppV(String appid) {
		// TODO Auto-generated method stub
		Appv appv = appvRepository.findByAppid(appid);
		return new RespEntity(RespCode.SUCCESS, appv);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AppvService#updateAppv()
	 */
	@Override
	public RespEntity updateAppv(Appv appv) {
		// TODO Auto-generated method stub
		appvRepository.save(appv);
		return new RespEntity(RespCode.SUCCESS, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AppvService#getAppVinfo()
	 */
	@Override
	public List<Appv> getAppVinfo() {
		// TODO Auto-generated method stub
		return appvRepository.findAll();
	}

}
