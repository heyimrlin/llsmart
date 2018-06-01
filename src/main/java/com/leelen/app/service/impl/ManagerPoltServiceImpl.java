/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:17:36
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.ManagerPoltRepository;
import com.leelen.app.service.ManagerPoltService;
import com.leelen.entitys.ManagerPolt;

/**
 * @author xiaoxl
 *
 */
@Service
public class ManagerPoltServiceImpl implements ManagerPoltService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	ManagerPoltRepository managerPoltRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.ManagerPoltService#getPoltIdByManagerId(java.lang.
	 * String)
	 */
	@Override
	public List<ManagerPolt> getPoltByManagerId(String aid) {
		// TODO Auto-generated method stub
		return managerPoltRepository.findByAid(aid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.ManagerPoltService#getManagerIdByPlotId(java.lang.
	 * String)
	 */
	@Override
	public List<ManagerPolt> getManagerIdByPlotId(String plotid) {
		// TODO Auto-generated method stub
		return managerPoltRepository.findByPlotid(plotid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.ManagerPoltService#getPlotByAid(java.lang.String)
	 */
	@Override
	public List<ManagerPolt> getPlotByAid(String aid) {
		// TODO Auto-generated method stub
		return managerPoltRepository.findByAidIn(aid);
	}

}
