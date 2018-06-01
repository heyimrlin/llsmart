/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.ManagerPoltService;
import com.leelen.app.service.PlotInfoService;
import com.leelen.app.service.WyTokenService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月30日上午9:22:56
 * @class PoltInfoController.java
 */
@LeelenRestController(msg = "小区信息")
@RequestMapping("/app/polt")
public class PoltInfoController {

	@Resource
	PlotInfoService plotInfoService;

	@Resource
	ManagerPoltService managerPoltService;

	@Resource
	WyTokenService wyTokenService;

	// 根据管理员id获取小区
	@Log("根据管理员id获取小区")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public RespEntity getPlotInfoByAid(HttpServletRequest request, @RequestParam(value = "token") String token,
			@RequestParam(value = "sign") String sign, @RequestParam(value = "app") String app) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return plotInfoService.getPlotByPlotid(token, timestamp, app, sign);

	}
}
