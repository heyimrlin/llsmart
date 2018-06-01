/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.CardDeviceService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.CardDevice;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月29日上午10:25:12
 * @class CardDeviceController.java
 */
@LeelenRestController(msg = "卡、设备")
@RequestMapping("/app/cardDevice")
public class CardDeviceController {

	@Resource
	CardDeviceService cardDeviceService;

	@Log("门禁卡、设备")
	@RequestMapping(value = "/getDevice", method = RequestMethod.GET)
	public List<CardDevice> getDevice(@RequestParam(name = "cardno") String cardno) {
		return cardDeviceService.getDeviceDataByCard(cardno);
	}

}
