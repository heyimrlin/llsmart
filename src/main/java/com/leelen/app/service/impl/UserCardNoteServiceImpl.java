/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:12:59
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(getClass());

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

	@Override
	public RespEntity save(UserCardNote[] userCardNote) {
		// TODO Auto-generated method stub
		// UserCardNote[] userCardNote = null;//待做优化处理
		if (userCardNote.length != 0) {
			for (UserCardNote uCardNote : userCardNote) {
				logger.info("数据:设备id:" + uCardNote.getEgid() + "进出类型:" + uCardNote.getInouttype() + "用户id:"
						+ uCardNote.getUid());
				userCardNoteRepository.save(uCardNote);// 数据库操作频繁
			}
		}
		return new RespEntity(RespCode.SUCCESS, null);
	}

}
