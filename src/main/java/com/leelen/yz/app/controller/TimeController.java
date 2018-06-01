/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月27日上午11:12:09
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.yz.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leelen.entity.AppMsg;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl 时间校验
 *
 */

@LeelenRestController
@RequestMapping("/app")
public class TimeController {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	// 获取时间
	@RequestMapping(value = "/getTime", method = RequestMethod.GET)
	public AppMsg getTime() {
		return new AppMsg(0, "平台时间", System.currentTimeMillis());
	}

}
