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
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.MoblieUserService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;
import com.leelen.utils.ClientOsInfo;
import com.leelen.utils.MD5Tools;

/**
 * @author xiaoxl
 *
 */
@Api(value = "MobileUser-API", description = "用户端APP接口")
@LeelenRestController(msg = "业主移动端API")
@RequestMapping("/yz/app")
public class MoblieUserController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	MoblieUserService moblieUserService;

	// 用户注册
	@Log("用户注册")
	@RequestMapping(value = "/register", method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			"application/json;charset=UTF-8" })
	@ApiOperation(value = "用户注册", notes = "新增注册")
	@ApiImplicitParams({@ApiImplicitParam(name = "sign", value = "URL签名", required = true, paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "timestamp", value = "时间戳", required = true, paramType = "header", dataType = "long"),
			@ApiImplicitParam(name = "tell", value = "手机号", required = true, paramType = "form", dataType = "String"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form", dataType = "String"),
			@ApiImplicitParam(name = "smsCode", value = "短信校验码", required = true, paramType = "form", dataType = "String")})
	@ApiResponse(code = 200, message = "注册成功")
	public RespEntity register(HttpServletResponse response, HttpServletRequest request,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "tell") String tell, @RequestParam(value = "password") String password,
			@RequestParam(value = "smsCode") String smsCode) {
		// 先判断平台是否有配置

		// 判定请求是否是移动端
		// if (!ClientOsInfo.JudgeIsMoblie(request)) {
		// return new RespEntity(RespCode.ILLEGALITY_REQUEST, null);
		// }

		return moblieUserService.save(response, request, sign, timestamp, tell, password, smsCode);
	}

	// @RequestHeader(value = "timestamp") long timestamp,
	// @RequestHeader(value = "sign") String sign,
	@Log("用户登录")
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "用户登录")
	@ApiImplicitParams({@ApiImplicitParam(name = "tell", value = "手机号", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "password", value = "密码", paramType = "form", dataType = "String", required = true)})
	@ApiResponse(code = 200, message = "登录成功")
	public RespEntity login(HttpServletRequest request, @RequestParam(value = "tell") String tell,
			@RequestParam(value = "password") String password) {

		if (!ClientOsInfo.JudgeIsMoblie(request)) {
			return new RespEntity(RespCode.ILLEGALITY_REQUEST, null);
		}
		// String sign = request.getParameter("sign");
		// long timestamp = Long.parseLong(request.getParameter("timestamp"));
		String sign = MD5Tools
				.MD5("/yz/app/login?tell=\" + tell + \"&password=\" + password + \"&timestamp=\" + timestamp");
		long timestamp = 1532102412356L;
		logger.info(tell + password + sign);
		logger.info("业主端app登录");
		return moblieUserService.login(tell, password, sign, timestamp, 0);
	}

	@Log("获取我的指定小区下的有效成员")
	@RequestMapping(value = "/getMember", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	@ApiOperation(value = "获取成员", notes = "获取我的指定小区下的有效成员")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "plotid", value = "小区标识", paramType = "form", dataType = "String", required = true)})
	@ApiResponse(code = 200, message = "获取成功")
	public RespEntity getMember(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestParam(value = "plotid") String plotid) {

		if (!ClientOsInfo.JudgeIsMoblie(request)) {
			return new RespEntity(RespCode.ILLEGALITY_REQUEST, null);
		}

		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return moblieUserService.getMember(token, timestamp, sign, plotid);
	}

	// 业主添加成员
	@Log("业主添加成员")
	@RequestMapping(value = "/addMember", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "添加成员", notes = "小区业主添加成员")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long",required = true),
		@ApiImplicitParam(name = "nickname", value = "用户昵称", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "tell", value = "手机号", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "plotid", value = "小区标识", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "buildingid", value = "楼栋标识", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "roomid", value = "房屋标识", paramType = "form", dataType = "String", required = true)})
	@ApiResponse(code = 200, message = "添加成功")
	public RespEntity addMember(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "nickname") String nickname, @RequestParam(value = "tell") String tell,
			@RequestParam(value = "plotid") String plotid, @RequestParam(value = "buildingid") String buildingid,
			@RequestParam(value = "roomid") String roomid) {
		if (!ClientOsInfo.JudgeIsMoblie(request)) {
			return new RespEntity(RespCode.ILLEGALITY_REQUEST, null);
		}
		// long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return moblieUserService.addMember(token, timestamp, sign, nickname, tell, plotid, buildingid, roomid);
	}

	// 修改成员信息
	@Log("修改成员信息")
	@RequestMapping(value = "/modifyMember", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@ApiOperation(value = "修改成员", notes = "修改成员信息")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long", required = true),
		@ApiImplicitParam(name = "uid", value = "用户ID", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "nickname", value = "用户昵称", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "tell", value = "手机号", paramType = "form", dataType = "String", required = true)})
	@ApiResponse(code = 200, message = "修改成功")
	public RespEntity modifyMember(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "uid") String uid, @RequestParam(value = "nickname") String nickname,
			@RequestParam(value = "tell") String tell) {

		if (!ClientOsInfo.JudgeIsMoblie(request)) {
			return new RespEntity(RespCode.ILLEGALITY_REQUEST, null);
		}

		// long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return moblieUserService.updateUser(token, timestamp, sign, uid, nickname, tell);
	}

	// 删除成员信息 注:接收数据格式 consumes = { "application/json" }
	@Log("删除成员信息")
	@RequestMapping(value = "/deleteMember", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@ApiOperation(value = "删除成员", notes = "删除成员信息")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "form", dataType = "long", required = true),
		@ApiImplicitParam(name = "uid", value = "用户ID", paramType = "form", dataType = "String", required = true)})
	@ApiResponse(code = 200, message = "删除成功")
	public RespEntity deleteMember(HttpServletRequest request, @RequestParam(value = "token") String token,
			@RequestParam(value = "sign") String sign, @RequestParam(value = "timestamp") long timestamp,
			@RequestParam(value = "uid") String uid) {

		if (!ClientOsInfo.JudgeIsMoblie(request)) {
			return new RespEntity(RespCode.ILLEGALITY_REQUEST, null);
		}

		return moblieUserService.deleteUser(token, timestamp, sign, uid);
	}

	@Log("修改密码")
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "修改密码", notes = "修改用户密码")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long", required = true),
		@ApiImplicitParam(name = "oldpwd", value = "旧密码", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "password", value = "新密码", paramType = "form", dataType = "String", required = true)})
	@ApiResponse(code = 200, message = "修改密码成功")
	public RespEntity modifyPwd(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "oldpwd") String oldpwd, @RequestParam(value = "password") String password)
			throws ParseException {

		if (!ClientOsInfo.JudgeIsMoblie(request)) {
			return new RespEntity(RespCode.ILLEGALITY_REQUEST, null);
		}

		System.out.println("token:" + token + ">>sign:" + sign);
		return moblieUserService.modifyUserPassword(oldpwd, token, password, timestamp, sign);
	}

	@Log("重置密码")
	@RequestMapping(value = "/resetPwd", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "重置密码", notes = "重置用户密码")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long", required = true)})
	@ApiResponse(code = 200, message = "重置密码成功")
	public RespEntity resetPwd(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp)
			throws ParseException {

		if (!ClientOsInfo.JudgeIsMoblie(request)) {
			return new RespEntity(RespCode.ILLEGALITY_REQUEST, null);
		}

		return moblieUserService.resetUserPassword(token, timestamp, sign);
	}

	// 退出登录
	@Log("退出登录")
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "退出登录", notes = "用户退出登录")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long", required = true)})
	@ApiResponse(code = 200, message = "退出登录成功")
	public Map<String, Object> loginOut(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp) {
		System.out.println("token:" + token + ">>sign:" + sign);
		return moblieUserService.userLogout(token, timestamp, sign);
	}

	// 我的小区
	@Log("我的小区")
	@RequestMapping(value = "/myPlots", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "我的小区", notes = "获取我所属的小区列表")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
			@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
			@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long", required = true)})
	@ApiResponse(code = 200, message = "获取信息成功")
	public RespEntity myPlots(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp) {
		System.out.println("token:" + token + ">>sign:" + sign);
		return moblieUserService.getMyPlots(token, timestamp, sign);
	}

}
