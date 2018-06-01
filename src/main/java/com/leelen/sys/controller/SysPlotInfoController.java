/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.PlotInfoService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.PlotInfo;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl by male
 * @time 2018年5月31日下午5:14:27
 * @class SysPlotInfoController.java
 */
@LeelenController(msg = "小区信息")
@RequestMapping("/sys/poltinfo")
public class SysPlotInfoController {

	@Resource
	PlotInfoService plotInfoService;

	@Log("小区list")
	@RequestMapping("/list")
	public @ResponseBody List<PlotInfo> getPlotList() {
		return plotInfoService.getPlotList();
	}
}
