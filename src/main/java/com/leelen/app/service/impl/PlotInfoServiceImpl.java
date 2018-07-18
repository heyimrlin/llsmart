/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:16:11
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.PlotInfoRepository;
import com.leelen.app.service.ManagerPoltService;
import com.leelen.app.service.PlotInfoService;
import com.leelen.app.service.WyTokenService;
import com.leelen.entitys.ManagerPolt;
import com.leelen.entitys.PlotInfo;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl
 *
 */
@Service
public class PlotInfoServiceImpl implements PlotInfoService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	PlotInfoRepository plotInfoRepository;

	@Resource
	ManagerPoltService managerPoltService;

	@Resource
	WyTokenService wyTokenService;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.PlotInfoService#save(com.leelen.entitys.PlotInfo)
	 */
	@Override
	public void save(PlotInfo plotInfo) {
		// TODO Auto-generated method stub
		plotInfoRepository.save(plotInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.PlotInfoService#getAllPlot()
	 */
	@Override
	public RespEntity getAllPlot() {
		// TODO Auto-generated method stub
		return new RespEntity(RespCode.SUCCESS, plotInfoRepository.findAll());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.PlotInfoService#getPoltBy(java.lang.String)
	 */
	@Override
	public RespEntity getPoltBy(String tell) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.PlotInfoService#getPlotByPlotid(java.util.Collection)
	 */
	@Override
	public RespEntity getPlotByPlotid(String token, long timestamp, String app, String sign) {
		// TODO Auto-generated method stub
		// managerPoltService.getPlotByAid(wyTokenService.getAidByToken(token).getAid())
		List<ManagerPolt> managerPolts = managerPoltService.getPlotByAid(wyTokenService.getAidByToken(token).getAid());

		String[] sArrays = new String[managerPolts.size()];

		for (int i = 0; i < managerPolts.size(); i++) {
			sArrays[i] = managerPolts.get(i).getPlotid();
		}
		logger.info("该管理员有" + sArrays.length + "小区");
		List<PlotInfo> lInfos = plotInfoRepository.findByPlotstatusAndPlotidIn(0, sArrays);
		if (lInfos.size() > 0) {
			return new RespEntity(RespCode.SUCCESS, lInfos);
		} else {
			return new RespEntity(RespCode.SUCCESS, "暂无数据");
		}
		// Cookie cookie2 = cookies[i];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.PlotInfoService#getPlotList()
	 */
	@Override
	public List<PlotInfo> getPlotList() {
		// TODO Auto-generated method stub
		return plotInfoRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.PlotInfoService#getPlotinfo(int)
	 */
	@Override
	public PlotInfo getPlotinfo(String plotid) {
		// TODO Auto-generated method stub
		return plotInfoRepository.findByPlotid(plotid);
	}

}
