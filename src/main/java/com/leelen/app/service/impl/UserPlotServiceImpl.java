/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:12:40
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.UserPlotRepository;
import com.leelen.app.service.UserPlotService;
import com.leelen.entitys.UserPlot;

/**
 * @author xiaoxl
 *
 */
@Service
public class UserPlotServiceImpl implements UserPlotService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	UserPlotRepository userPlotRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.UserPlotService#getPlotByUid(java.lang.String)
	 */
	@Override
	public List<UserPlot> getPlotByUid(String uid) {
		// TODO Auto-generated method stub
		return userPlotRepository.findByUid(uid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.UserPlotService#getUidByPlotId(java.lang.String)
	 */
	@Override
	public List<UserPlot> getUidByPlotId(String plotid) {
		// TODO Auto-generated method stub
		return userPlotRepository.findByPlotid(plotid);
	}

}
