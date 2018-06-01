/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:18:16
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.EgCardRepository;
import com.leelen.app.service.EgCardService;
import com.leelen.entitys.EgCard;

/**
 * @author xiaoxl
 *
 */
@Service
public class EgCardServiceImpl implements EgCardService {

	@Autowired
	EgCardRepository egCardRepository;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.EgCardService#save(com.leelen.entitys.EgCard)
	 */
	@Override
	public void save(EgCard egCard) {
		// TODO Auto-generated method stub
		egCardRepository.save(egCard);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.EgCardService#getEgCardList()
	 */
	@Override
	public List<EgCard> getEgCardList() {
		// TODO Auto-generated method stub
		return egCardRepository.findAll();
	}

}
