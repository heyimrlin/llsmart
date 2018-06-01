/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:15:16
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.leelen.app.service.PlotOtherHostService;
import com.leelen.entitys.PlotOtherHost;

/**
 * @author xiaoxl
 *
 */
@Service
public class PlotOtherHostServiceImpl implements PlotOtherHostService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.PlotOtherHostService#save(com.leelen.entitys.
	 * PlotOtherHost)
	 */
	@Override
	public void save(PlotOtherHost plotOtherHost) {
		// TODO Auto-generated method stub

	}

}
