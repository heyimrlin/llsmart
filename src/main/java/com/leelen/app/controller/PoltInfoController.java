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

import com.leelen.app.service.MachineInfoService;
import com.leelen.app.service.ManagerPoltService;
import com.leelen.app.service.PlotInfoService;
import com.leelen.app.service.UnitService;
import com.leelen.app.service.UserPlotService;
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

	@Resource
	UserPlotService userPlotService;

	@Resource
	UnitService unitService;

	@Resource
	MachineInfoService machineInfoService;

	// 根据管理员id获取小区
	@Log("根据管理员id获取小区")
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public RespEntity getPlotInfoByAid(HttpServletRequest request, @RequestParam(value = "token") String token,
			@RequestParam(value = "sign") String sign, @RequestParam(value = "app") String app) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return plotInfoService.getPlotByPlotid(token, timestamp, app, sign);

	}

	// 获取我的小区
	@Log("根据用户id获取小区")
	@RequestMapping(value = "/mypolt", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public RespEntity getPlotInfoByUid(HttpServletRequest request, @RequestParam(value = "token") String token,
			@RequestParam(value = "sign") String sign, @RequestParam(value = "app") String app) {
		long timestamp = Long.parseLong(request.getParameter("timestamp"));
		return userPlotService.getPlotsByUid(token);

	}

	// 指定项目(小区)下有效的单元(楼幢)
	@Log("指定项目(小区)下有效的单元(楼幢)")
	@RequestMapping(value = "/myunit", produces = { "application/json;charset=UTF-8" })
	public RespEntity getUnitByPlotid(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "plotid") String plotid) {
		return unitService.findByPlotid(token, sign, timestamp, plotid);

	}

	// 项目(小区)下有效的设备号(激活和未激活的)
	@Log("项目(小区)下有效的设备号(激活和未激活的)")
	@RequestMapping(value = "/plotofdevice", produces = { "application/json;charset=UTF-8" })
	public RespEntity getPlotOfDevice(HttpServletRequest request, @RequestParam(value = "token") String token,
			@RequestParam(value = "sign") String sign, @RequestParam(value = "timestamp") long timestamp,
			@RequestParam(value = "plotid") String plotid) {
		return machineInfoService.getMachineByPlotid(token, timestamp, sign, plotid, 0, 0);

	}

}
