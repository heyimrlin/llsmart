/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月10日上午10:29:02
 * @包名:com.leelen.manage.app.controller
 * @描述:TODO
 */
package com.leelen.manage.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leelen.common.annotation.Log;
import com.leelen.entity.ApiMsg;


/**
 * @author xiaoxl
 *
 */
@RestController
@RequestMapping("/manage")
public class PlotAdvController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	// 获取有效广告
	@Log("获取有效广告")
	@RequestMapping(value = "/getValidAdv", method = RequestMethod.GET)
	public ApiMsg getValidAdv(HttpServletRequest request, @RequestParam(value = "account") String account,
			@RequestParam(value = "password") String password) {
		logger.info("");
		return null;
	}

	// 获取有效公告
	@Log("获取有效公告")
	@RequestMapping(value = "/getValidNotice", method = RequestMethod.GET)
	public ApiMsg getValidNotice(HttpServletRequest request, @RequestParam(value = "account") String account,
			@RequestParam(value = "password") String password) {
		logger.info("");
		return null;
	}
}
