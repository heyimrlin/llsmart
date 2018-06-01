package com.leelen.yz.app.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.MoblieUserService;
import com.leelen.app.service.SysUserService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.SysUser;
import com.leelen.my.mycontroller.LeelenRestController;

@LeelenRestController(msg = "平台配置用户")
@RequestMapping("/yz/app")
public class SysUserController {

	@Resource
	SysUserService sysUserService;

	@Resource
	MoblieUserService moblieUserService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	// 修改用户信息
	public RespEntity updateSysUserInfo(@RequestBody SysUser sysUser) {
		return sysUserService.updateUserInfo(sysUser);
	}

	@Log("更改用户状态")
	@RequestMapping(value = "/updateuseable", method = RequestMethod.GET)
	public RespEntity updateuseable(@RequestParam(value = "useable") int useable,
			@RequestParam(value = "tell") String tell) {
		if (sysUserService.modifyUserStatus(useable, tell) == 1) {
			logger.info("更改成功");
			return new RespEntity(RespCode.SUCCESS, null);
		} else {
			logger.info("更改失败");
			return new RespEntity(RespCode.MODIFY_ERROR, null);
		}
	}
}
