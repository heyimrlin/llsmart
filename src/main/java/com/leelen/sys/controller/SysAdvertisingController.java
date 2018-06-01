/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.AdvertisingService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.Advertising;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl by male
 * @time 2018年5月31日下午3:37:58
 * @class SysAdvertisingController.java
 */
@LeelenController(msg = "")
@RequestMapping("/sys/adv")
public class SysAdvertisingController {

	@Resource
	AdvertisingService advertisingService;

	@Log("平台获取广告")
	@RequestMapping("/list")
	public @ResponseBody List<Advertising> getAdvList() {
		return advertisingService.getAllAdv();
	}
}
