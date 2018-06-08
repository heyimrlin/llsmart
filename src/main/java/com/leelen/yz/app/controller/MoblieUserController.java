/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月18日下午3:46:40
 * @包名:com.leelen.yz.app.controller
 * @描述:TODO
 */
package com.leelen.yz.app.controller;

import java.text.ParseException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.MoblieUserService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl
 *
 */
@LeelenRestController(msg = "业主移动端API")
@RequestMapping("/yz/app")
public class MoblieUserController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	MoblieUserService moblieUserService;

	@Log("用户登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity login(HttpServletRequest request, @RequestParam(value = "tell") String tell,
			@RequestParam(value = "password") String password) {
		String sign = request.getParameter("sign");
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		logger.info(tell + password + sign);
		logger.info("业主端app登录");
		return moblieUserService.login(tell, password, sign, timestamp, 0);
	}

	@Log("获取有效成员")
	@RequestMapping(value = "/getMember", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity getMember(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return moblieUserService.getMember(token, timestamp, sign);
	}

	@Log("修改密码")
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity modifyPwd(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestParam(value = "oldpwd") String oldpwd,
			@RequestParam(value = "password") String password) throws ParseException {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		System.out.println("token:" + token + ">>sign:" + sign);
		return moblieUserService.modifyUserPassword(oldpwd, token, password, timestamp, sign);
	}

	@Log("重置密码")
	@RequestMapping(value = "/resetPwd", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity resetPwd(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign) throws ParseException {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return moblieUserService.resetUserPassword(token, timestamp, sign);
	}

	// 退出登录
	@Log("退出登录")
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public Map<String, Object> loginOut(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign) {
		System.out.println("token:" + token + ">>sign:" + sign);
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return moblieUserService.userLogout(token, timestamp, sign);
	}

}
