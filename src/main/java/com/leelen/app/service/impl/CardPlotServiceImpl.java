/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:18:50
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.CardPlotRepository;
import com.leelen.app.service.CardPlotService;
import com.leelen.entitys.CardPlot;

/**
 * @author xiaoxl 卡、小区
 */
@Service
public class CardPlotServiceImpl implements CardPlotService {

	@Autowired
	CardPlotRepository cardPlotRepository;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.CardPlotService#getCardData(java.lang.String)
	 */
	@Override
	public List<CardPlot> getCardData(String cardno) {
		// TODO Auto-generated method stub
		return cardPlotRepository.findByCardno(cardno);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.CardPlotService#getPlotData(java.lang.String)
	 */
	@Override
	public List<CardPlot> getPlotData(String plotid) {
		// TODO Auto-generated method stub
		return cardPlotRepository.findByPlotid(plotid);
	}

}
