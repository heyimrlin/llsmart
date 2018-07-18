/**
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.PlotRepository;
import com.leelen.app.service.PlotService;
import com.leelen.entitys.Plot;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl by male
 * @time 2018年6月20日下午2:34:04
 * @class PlotServiceImpl.java
 */
@Service
public class PlotServiceImpl implements PlotService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	PlotRepository plotRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.PlotService#savePlot(com.leelen.entitys.Plot)
	 */
	@Override
	public RespEntity savePlot(Plot plot) {
		// TODO Auto-generated method stub
		plotRepository.save(plot);
		return new RespEntity(RespCode.SUCCESS, null);
	}

}
