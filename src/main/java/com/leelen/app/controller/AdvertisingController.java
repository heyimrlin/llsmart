/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.AdvertisingService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日上午8:41:43
 * @class AdvertisingController.java
 */
@LeelenRestController(msg = "平台、小区广告")
@RequestMapping("/app/adv")
@Api(value = "Advertising-API", description = "平台和小区的广告管理接口")
public class AdvertisingController {

	@Resource
	AdvertisingService advertisingService;

	@Log("平台广告")
	@RequestMapping(value = "/platform", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "获取平台广告", notes = "根据平台标识获取所属平台的有效(审核通过)以及可显示的广告")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "ptid", value = "平台标识", paramType = "form", dataType = "String")})
	@ApiResponse(code = 200, message = "获取平台广告成功")
	public RespEntity getPtAdv(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestParam(value = "ptid") String ptid) {// ptid平台标识

		return advertisingService.getAllAdvertisingByAdvtypeAndAuditstatusAndIsshow("0", 0, 0, "", token, sign);
	}

	@Log("小区广告")
	@RequestMapping(value = "/plot", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "获取小区广告", notes = "根据小区标识获取所属平台的有效(审核通过)以及可显示的广告")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "form", dataType = "String"),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "form", dataType = "String"),
		@ApiImplicitParam(name = "plotid", value = "小区标识", paramType = "form", dataType = "String")})
	@ApiResponse(code = 200, message = "获取小区广告成功")
	public RespEntity getPlotAdv(HttpServletRequest request, @RequestParam(value = "token") String token,
			@RequestParam(value = "sign") String sign, @RequestParam(value = "plotid") String plotid) {
		return advertisingService.getAllAdvertisingByAdvtypeAndAuditstatusAndIsshow("0", 0, 0, plotid, token, sign);
	}

	@Log("下载广告图") //
	@RequestMapping(value = "/getImg", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "获取下载广告图", notes = "根据广告类型获取有效(审核通过)以及可显示的广告图")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "Long"),
		@ApiImplicitParam(name = "plotid", value = "广告类型", paramType = "form", dataType = "String")})
	@ApiResponse(code = 200, message = "获取可下载的广告图成功")
	public RespEntity getImg(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "plotid") String plotid) {
		return advertisingService.getAllAdvertisingByAdvtypeAndAuditstatusAndIsshowImg("0", 0, 0, plotid, token, sign,
				timestamp);
	}

}
