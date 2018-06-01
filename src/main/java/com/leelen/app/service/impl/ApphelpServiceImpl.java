/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:19:57
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.ApphelpRepository;
import com.leelen.app.service.ApphelpService;
import com.leelen.entitys.Apphelp;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl
 *
 */
@Service
public class ApphelpServiceImpl implements ApphelpService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	ApphelpRepository apphelpRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.ApphelpService#save(com.leelen.entitys.Apphelp)
	 */
	@Override
	public void save(Apphelp apphelp) {
		// TODO Auto-generated method stub
		apphelpRepository.save(apphelp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.ApphelpService#getAllApphelp()
	 */
	@Override
	public List<Apphelp> getAllApphelp() {
		// TODO Auto-generated method stub
		return apphelpRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.ApphelpService#getAllApphelpByStatus(int)
	 */
	@Override
	public RespEntity getAllApphelpByStatus(int status) {
		// TODO Auto-generated method stub
		List<Apphelp> apphelps = apphelpRepository.findByStatus(status);
		return new RespEntity(RespCode.SUCCESS, apphelps);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.ApphelpService#updateApphelpById(int)
	 */
	@Override
	public RespEntity updateApphelpById(int status, int id) {
		// TODO Auto-generated method stub
		if (apphelpRepository.updateStatusById(status, id) == 1) {
			return new RespEntity(RespCode.SUCCESS, null);
		} else {
			return new RespEntity(RespCode.MODIFY_ERROR, null);
		}
	}

}
