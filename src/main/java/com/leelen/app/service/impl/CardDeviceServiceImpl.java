/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:19:11
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.CardDeviceRepository;
import com.leelen.app.service.CardDeviceService;
import com.leelen.entitys.CardDevice;

/**
 * @author xiaoxl
 *
 */
@Service
public class CardDeviceServiceImpl implements CardDeviceService {

	@Autowired
	CardDeviceRepository cardDeviceRepository;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.CardDeviceService#getDeviceDataByCard(java.lang.
	 * String)
	 */
	@Override
	public List<CardDevice> getDeviceDataByCard(String cardno) {
		// TODO Auto-generated method stub
		List<CardDevice> lists = cardDeviceRepository.findByCardno(cardno);
		System.out.println(lists);
		return lists;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.CardDeviceService#getCardDataByDevice(java.lang.
	 * String)
	 */
	@Override
	public List<CardDevice> getCardDataByDevice(String deviceid) {
		// TODO Auto-generated method stub
		List<CardDevice> lists = cardDeviceRepository.findByDeviceid(deviceid);
		return lists;
	}

}
