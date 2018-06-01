/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.MoblieUserService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.MoblieUser;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl by male
 * @time 2018年5月31日下午4:20:17
 * @class SysMoblieUserController.java
 */
@LeelenController(msg = "用户")
@RequestMapping("/sys/user")
public class SysMoblieUserController {

	@Resource
	MoblieUserService moblieUserService;

	@Log("平台获取用户list")
	@RequestMapping("/list")
	public @ResponseBody List<MoblieUser> getAllUser() {
		return moblieUserService.getMoblieUser();
	}
}
