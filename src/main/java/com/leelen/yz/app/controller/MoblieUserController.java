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

	// 用户注册
	@Log("用户注册")
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity register(HttpServletRequest request, @RequestHeader(value = "timestamp") long timestamp,
			@RequestHeader(value = "sign") String sign, @RequestParam(value = "tell") String tell,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "verification") String verification) {
		// 先判断平台是否有配置

		return moblieUserService.save(tell, password, verification);
	}

	@Log("用户登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity login(HttpServletRequest request, @RequestHeader(value = "timestamp") long timestamp,
			@RequestHeader(value = "sign") String sign, @RequestParam(value = "tell") String tell,
			@RequestParam(value = "password") String password) {
		// String sign = request.getParameter("sign");
		// long timestamp = Long.parseLong(request.getParameter("timestamp"));
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

	// 添加成员
	@Log("添加成员")
	@RequestMapping(value = "/addMember", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity addMember(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "nickname") String nickname, @RequestParam(value = "tell") String tell,
			@RequestParam(value = "plotid") String plotid, @RequestParam(value = "buildingname") String buildingname,
			@RequestParam(value = "room") String room) {
		// long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return moblieUserService.addMember(token, timestamp, sign, nickname, tell, plotid, buildingname, room);
	}

	// 修改成员信息
	@Log("修改成员信息")
	@RequestMapping(value = "/modifyMember", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity modifyMember(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "nickname") String nickname, @RequestParam(value = "tell") String tell) {
		// long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return moblieUserService.updateUser(token, timestamp, sign, nickname, tell);
	}

	// 删除成员信息
	@Log("删除成员信息")
	@RequestMapping(value = "/deleteMember", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity deleteMember(HttpServletRequest request, @RequestHeader(value = "token") String token,
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
