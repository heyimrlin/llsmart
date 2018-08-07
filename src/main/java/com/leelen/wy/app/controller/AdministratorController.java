/**
 * @包名:com.leelen.wy.app.controller
 * @描述:TODO
 */
package com.leelen.wy.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.AdministratorService;
import com.leelen.app.service.AppmenusService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;
import com.leelen.publicmethod.MyMethod;
import com.leelen.utils.ClientOsInfo;
import com.leelen.utils.MD5Tools;

/**
 * @author xiaoxl by male
 * @time 2018年5月19日上午9:59:52
 * @class AdministratorController.java
 */
@Api(value = "Administrator-API", description = "物业端APP管理接口")
@LeelenRestController(msg = "物业端APP")
@RequestMapping("/wy/app")
public class AdministratorController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	AdministratorService administratorService;

	@Resource
	AppmenusService appmenusService;

	// 权限控制
	@Log("物业端登录")
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "物业端登录", notes = "物业端APP用户登录")
	@ApiImplicitParams({@ApiImplicitParam(name = "accounttell", value = "用户手机号", paramType = "form", dataType = "String"),
		@ApiImplicitParam(name = "password", value = "用户密码", paramType = "form", dataType = "String"),
		@ApiImplicitParam(name = "sign",value = "URL签名", paramType = "form", dataType = "String"),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "form", dataType = "Long")})
	@ApiResponse(code = 200, message = "用户登录成功")
	public RespEntity login(HttpServletRequest request, @RequestParam(value = "accounttell") String accounttell,
			@RequestParam(value = "password") String password, @RequestParam(value = "sign") String sign,
			@RequestParam(value = "timestamp") long timestamp) {
		logger.info(accounttell + password + sign);
		logger.info("物业端app登录");
		return administratorService.adminLogin(accounttell, password, timestamp, sign);// 返回内容:nickname,account,tell,token,plot,permission,rolename
	}

	// 修改密码
	@Log("修改密码")
	@RequestMapping(value = "/modifyPwd", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "修改密码", notes = "登录用户修改自身的登录密码")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "oldpwd", value = "原始密码", paramType = "form", dataType = "String"),
		@ApiImplicitParam(name = "newpwd", value = "新密码", paramType = "form", dataType = "String"),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "Long"),
		@ApiImplicitParam(name = "smsCode", value = "短信验证码", paramType = "form", dataType = "String")})
	@ApiResponse(code = 200, message = "修改密码成功")
	public RespEntity modifyPwd(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestParam(value = "oldpwd") String oldpwd, @RequestParam(value = "newpwd") String newpwd,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "smsCode") String smsCode) {
		logger.info("修改密码");
		MyMethod myMethod = new MyMethod();
		String smsStrCode = myMethod.getCookieByName(request, "code").getValue();
		if (smsCode.equals(MD5Tools.MD5(smsStrCode))) {
			return administratorService.modifyAdminPassword(token, oldpwd, newpwd, timestamp, sign);
		} else {
			return new RespEntity(RespCode.VERIFICATION_CODE, null);
		}
	}

	// 重置密码
	@Log("重置密码")
	@RequestMapping(value = "/resetPwd", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "重置密码", notes = "登录用户根据token等信息重置密码")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String")})
	@ApiResponse(code = 200, message = "重置密码成功")
	public RespEntity resetPwd(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		logger.info("重置密码A123456");
		return administratorService.resetAdminPassword(token, timestamp, sign);
	}

	// 修改手机号
	@Log("更改手机号")
	@RequestMapping(value = "/modifyphone", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value="修改手机号", notes = "登录用户修改绑定手机号")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "tell", value = "需要绑定的手机号", paramType = "form", dataType = "String")})
	@ApiResponse(code = 200, message = "更改手机号成功")
	public RespEntity modifyPhone(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestParam(value = "tell") String tell) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		logger.info("更改手机号:" + tell);// tell为更改的手机号
		return administratorService.updateAdminTell(token, tell, timestamp, sign);
	}

	// 我管理的小区
	@Log("我管理的小区")
	@RequestMapping(value = "/myPolts", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "获取管理的小区", notes = "根据登录用户的token等信息获取用户管理的小区")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "Long")})
	@ApiResponse(code = 200, message = "获取管理的小区列表成功")
	public RespEntity myPolts(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp) {
		if (!ClientOsInfo.JudgeIsMoblie(request)) {
			return new RespEntity(RespCode.ILLEGALITY_REQUEST, null);
		}
		return administratorService.getMyPlot(token, sign, timestamp);
	}

	// 获取权限数组
	@Log("权限数组")
	@RequestMapping(value = "/getAppmenus", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "权限数组", notes = "根据用户角色标识获取用户权限数组")
	@ApiImplicitParam(name = "roleid", value = "角色标识", paramType = "form", dataType = "String")
	@ApiResponse(code = 200, message = "获取用户权限成功")
	public RespEntity getAppmenus(@RequestParam(value = "roleid") String roleid) {
		return new RespEntity(RespCode.SUCCESS, appmenusService.getAppmenusByRoleid(roleid));
	}

	//

}
