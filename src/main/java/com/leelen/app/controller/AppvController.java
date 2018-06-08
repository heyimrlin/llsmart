/**
 * @包名:com.leelen.yz.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;

import com.leelen.app.service.AppvService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日上午11:16:53
 * @class AppvController.java
 */
@LeelenRestController(msg = "app版本")
@RequestMapping("/app")
public class AppvController {

	@Resource
	AppvService appvService;

	@Log("业主APP")
	@RequestMapping(value = "/yz/appv", produces = { "application/json;charset=UTF-8" }, consumes = {
			"application/json" })
	public RespEntity getyzAppvData() {
		return appvService.getAppV(1);
	}

	@Log("物业APP")
	@RequestMapping(value = "/wy/appv", produces = { "application/json;charset=UTF-8" }, consumes = {
			"application/json" })
	public RespEntity getwyAppvData() {
		return appvService.getAppV(2);
	}
}
