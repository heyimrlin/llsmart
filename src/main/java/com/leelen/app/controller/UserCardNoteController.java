/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
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
@Api(value = "UserCardNote-API", description = "用户进出记录接口")
public class UserCardNoteController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	UserCardNoteService userCardNoteService;

	// @Log("用户卡记录")
	// @RequestMapping(value = "/uploadCardNote", method = RequestMethod.GET,
	// produces = {
	// "application/json;charset=UTF-8" })
	// public RespEntity uploadCardNote(UserCardNote userCardNote) {
	// logger.info("数据:" + userCardNote.getUid() + "单元:" +
	// userCardNote.getUnlockunit());
	// return userCardNoteService.save(userCardNote);
	// }

	// 若指定consumes为application/json,那么服务器仅处理request
	// Content-Type为"application/json"类型的请求
	// 参考:https://blog.csdn.net/Liam1994/article/details/79035198
	// produces指定响应类型为application/json的数据

	// 接收json数组对象
	// 参考资料:https://blog.csdn.net/u012129558/article/details/51768985

	// https://bbs.csdn.net/topics/391881006?page=1
	@Log("用户卡记录")
	@RequestMapping(value = "/uploadCardNote", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	@ApiOperation(value = "上传用户卡记录")
	@ApiResponse(code = 200, message = "上传成功")
	public RespEntity uploadCardNote(@RequestBody UserCardNote[] userCardNote) {
		logger.info("json数组数据:" + userCardNote);
		return userCardNoteService.save(userCardNote);
	}
}
