/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.PlotNoticeService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;
import com.leelen.publicmethod.MyMethod;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日下午3:48:12
 * @class PlotNoticeController.java
 */
@LeelenRestController(msg = "小区公告")
@RequestMapping("/app/plotnotice")
public class PlotNoticeController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	PlotNoticeService plotNoticeService;

	// @Log("获取小区对应的有效公告")
	// @RequestMapping("/")
	// public RespEntity getPlotNoticeData(@RequestParam(value = "plotid") String
	// plotid,
	// @RequestParam(value = "validity") String validity, @RequestParam(value =
	// "isshow") int isshow) {
	// return plotNoticeService.getPlotAllNotice(plotid, isshow,
	// MyMethod.formatDate(validity));
	// }

	@Log("获取小区对应的有效公告")
	@RequestMapping(value = "/get", produces = { "application/json;charset=UTF-8" }, consumes = { "application/json" })
	public RespEntity getPlotNoticeData(HttpServletRequest request, @RequestParam(value = "plotid") String plotid) {
		MyMethod method = new MyMethod();
		logger.info("请求IP:" + method.getIpAddr(request));
		return plotNoticeService.getPlotAllNotice(plotid, 0, null);
	}
}
