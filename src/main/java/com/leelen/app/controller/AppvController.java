/**
 * @包名:com.leelen.yz.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@Api(value = "Appv-API", description = "APP版本信息相关接口")
public class AppvController {

	@Resource
	AppvService appvService;

	@Log("业主APP")
	@RequestMapping(value = "/yz/appv", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "业主APP版本", notes = "根据APP标识获取业主APP的版本信息")
	@ApiImplicitParam(name = "type", value = "APP标识", paramType = "form", dataType = "String")
	@ApiResponse(code = 200, message = "获取版本信息成功")
	public RespEntity getyzAppvData(@RequestParam(value = "type") String type) {
		return appvService.getAppV(type);
	}

	@Log("物业APP")
	@RequestMapping(value = "/wy/appv", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "物业APP版本", notes = "根据APP标识获取物业APP的版本信息")
	@ApiImplicitParam(name = "type", value = "APP标识", paramType = "form", dataType = "String")
	@ApiResponse(code = 200, message = "获取版本信息成功")
	public RespEntity getwyAppvData(@RequestParam(value = "type") String type) {
		return appvService.getAppV(type);
	}
}
