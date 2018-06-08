/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
public class AdvertisingController {

	@Resource
	AdvertisingService advertisingService;

	@Log("平台广告")
	@RequestMapping(value = "/platform", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity getPtAdv(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestParam(value = "ptid") String ptid) {// ptid平台标识

		return advertisingService.getAllAdvertisingByAdvtypeAndAuditstatusAndIsshow("0", 0, 0, "", token, sign);
	}

	@Log("小区广告")
	@RequestMapping(value = "/plot", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity getPlotAdv(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestParam(value = "plotid") String plotid) {
		return advertisingService.getAllAdvertisingByAdvtypeAndAuditstatusAndIsshow("1", 0, 0, plotid, token, sign);
	}
}
