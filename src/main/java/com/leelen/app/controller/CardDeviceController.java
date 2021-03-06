/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import java.util.List;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.CardDeviceService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.CardDevice;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月29日上午10:25:12
 * @class CardDeviceController.java
 */
@LeelenRestController(msg = "卡、设备")
@RequestMapping("/app/cardDevice")
@Api(value = "CardDevice-API", description = "门禁卡关联设备的接口")
public class CardDeviceController {

	@Resource
	CardDeviceService cardDeviceService;

	@Log("门禁卡、设备")
	@RequestMapping(value = "/getDevice", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	@ApiOperation(value = "获取设备", notes = "通过门禁卡卡号获取关联设备")
	@ApiImplicitParam(name = "cardno", value = "卡号", paramType = "form", dataType = "String", required = true)
	@ApiResponse(code = 200, message = "获取设备成功", response = CardDevice.class)
	public List<CardDevice> getDevice(@RequestParam(name = "cardno") String cardno) {
		return cardDeviceService.getDeviceDataByCard(cardno);
	}

}
