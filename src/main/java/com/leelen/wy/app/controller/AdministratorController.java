/**
 * @包名:com.leelen.wy.app.controller
 * @描述:TODO
 */
package com.leelen.wy.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.AdministratorService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月19日上午9:59:52
 * @class AdministratorController.java
 */
@LeelenRestController(msg = "物业端APP")
@RequestMapping("/wy/app")
public class AdministratorController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	AdministratorService administratorService;

	@Log("物业端登录")
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity login(HttpServletRequest request, @RequestParam(value = "accounttell") String accounttell,
			@RequestParam(value = "password") String password) {
		String sign = request.getParameter("sign");
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		logger.info(accounttell + password + sign);
		logger.info("物业端app登录");
		return administratorService.adminLogin(accounttell, password, timestamp, sign);
	}

	// 修改密码
	@Log("修改密码")
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity modifyPwd(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestParam(value = "oldpwd") String oldpwd, @RequestParam(value = "newpwd") String newpwd,
			@RequestHeader(value = "sign") String sign) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		logger.info("修改密码");
		return administratorService.modifyAdminPassword(token, oldpwd, newpwd, timestamp, sign);
	}

	// 重置密码
	@Log("重置密码")
	@RequestMapping(value = "/resetPwd", produces = { "application/json;charset=UTF-8" }, consumes = {
			"application/json" })
	public RespEntity resetPwd(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		logger.info("重置密码A123456");
		return administratorService.resetAdminPassword(token, timestamp, sign);
	}

	// 修改手机号
	@Log("更改手机号")
	@RequestMapping(value = "/modifyphone", produces = { "application/json;charset=UTF-8" }, consumes = {
			"application/json" })
	public RespEntity modifyPhone(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestParam(value = "tell") String tell) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		logger.info("更改手机号" + tell);
		return administratorService.updateAdminTell(token, tell, timestamp, sign);
	}

}
