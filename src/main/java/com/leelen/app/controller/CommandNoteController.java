/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.CommandNoteService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月19日下午7:27:21
 * @class CommandNoteController.java
 */
@LeelenRestController(msg = "口令生成接口API")
@RequestMapping("/app/command")
public class CommandNoteController {

	@Resource
	CommandNoteService commandNoteService;

	@Log("生成口令")
	@RequestMapping(value = "/productCommand", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity productCommand(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestParam String unit,
			@RequestParam(value = "app") String app) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return commandNoteService.save(token, unit, app, timestamp, sign);
	}
}
