/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.AppvService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.Appv;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl by male
 * @time 2018年5月31日下午3:49:14
 * @class SysAppvController.java
 */
@LeelenController(msg = "APP版本")
@RequestMapping("/sys/appv")
public class SysAppvController {

	@Resource
	AppvService appvService;

	@Log("平台获取APP版本信息")
	@RequestMapping("/list")
	public @ResponseBody List<Appv> getAppVinfo() {
		return appvService.getAppVinfo();
	}
}
