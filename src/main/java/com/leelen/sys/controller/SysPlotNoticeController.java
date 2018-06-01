/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.PlotNoticeService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.PlotNotice;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl by male
 * @time 2018年5月31日下午5:20:30
 * @class SysPlotNoticeController.java
 */
@LeelenController(msg = "小区公告")
@RequestMapping("/sys/poltNotice")
public class SysPlotNoticeController {

	@Resource
	PlotNoticeService plotNoticeService;

	@Log("小区公告列表")
	@RequestMapping("/list")
	public @ResponseBody List<PlotNotice> getPlotNoticeList() {
		return plotNoticeService.getAllPlotNotice();
	}
}
