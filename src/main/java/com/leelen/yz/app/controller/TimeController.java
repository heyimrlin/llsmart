/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月27日上午11:12:09
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.yz.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leelen.entity.AppMsg;
import com.leelen.my.mycontroller.LeelenRestController;
import com.leelen.utils.ClientOsInfo;

/**
 * @author xiaoxl 时间校验
 *
 */

@LeelenRestController
@RequestMapping("/app")
@Api(value = "Time-API", description = "时间校验接口")
public class TimeController {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	// 获取时间
	@RequestMapping(value = "/getTime", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "获取时间")
	@ApiResponse(code = 200, message = "平台时间", response = AppMsg.class)
	public AppMsg getTime(HttpServletRequest request) {
		 if (!ClientOsInfo.JudgeIsMoblie(request)) {
		 return new AppMsg(4212, "非法请求", null);
		 }
		return new AppMsg(0, "平台时间", System.currentTimeMillis());
	}

}
