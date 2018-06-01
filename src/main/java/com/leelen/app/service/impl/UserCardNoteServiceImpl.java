/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:12:59
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.UserCardNoteRepository;
import com.leelen.app.service.UserCardNoteService;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.UserCardNote;

/**
 * @author xiaoxl
 *
 */
@Service
public class UserCardNoteServiceImpl implements UserCardNoteService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	UserCardNoteRepository userCardNoteRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.UserCardNoteService#save(com.leelen.entitys.
	 * UserCardNote)
	 */
	@Override
	public RespEntity save(UserCardNote userCardNote) {
		// TODO Auto-generated method stub
		userCardNoteRepository.save(userCardNote);
		return new RespEntity(RespCode.SUCCESS, null);
	}

}
