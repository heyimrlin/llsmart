/**
 * @包名:com.leelen.app.controller
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

import com.leelen.app.service.ApphelpService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日上午11:02:48
 * @class ApphelpController.java
 */
@LeelenRestController(msg = "APP帮助")
@RequestMapping("/app/ah")
@Api(value = "Apphelp-API", description = "APP帮助信息相关接口")
public class ApphelpController {

	@Resource
	ApphelpService apphelpService;

	@Log("获取帮助")
	@RequestMapping(value = "/getApphelp", produces = { "application/json;charset=UTF-8" }, consumes = {
			"application/json" },method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "获取帮助信息", notes = "根据状态获取APP帮助信息")
	@ApiImplicitParam(name = "status", value = "状态", paramType = "form", dataType = "int", required = true)
	@ApiResponse(code = 200, message = "获取帮助信息成功")
	public RespEntity getApphelp(@RequestParam("status") int status) {
		return apphelpService.getAllApphelpByStatus(status);
	}

}
