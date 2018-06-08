/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leelen.app.service.UserCardNoteService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.UserCardNote;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日下午2:42:22
 * @class UserCardNoteController.java
 */
@LeelenRestController(msg = "用户进出记录")
@RequestMapping("/app/ucn")
public class UserCardNoteController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	UserCardNoteService userCardNoteService;

	@Log("用户卡记录")
	@RequestMapping(value = "/uploadCardNote", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity uploadCardNote(UserCardNote userCardNote) {
		logger.info("数据:" + userCardNote.getUid() + "单元:" + userCardNote.getUnlockunit());
		return userCardNoteService.save(userCardNote);
	}
}
