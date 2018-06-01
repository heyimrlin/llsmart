/**
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.ShareaRepository;
import com.leelen.app.service.ShareaService;
import com.leelen.entitys.Sharea;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日下午8:43:13
 * @class ShareaServiceImpl.java
 */
@Service
public class ShareaServiceImpl implements ShareaService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	ShareaRepository shareaRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.ShareaService#getAreaCodeByShortname(java.lang.String)
	 */
	@Override
	public Sharea getAreaCodeByShortname(String shortname) {
		// TODO Auto-generated method stub
		return shareaRepository.findByShortname(shortname);
	}

}
