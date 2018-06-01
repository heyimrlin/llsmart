/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.EgCardService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.EgCard;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl by male
 * @time 2018年5月31日下午4:04:05
 * @class SysEgCardController.java
 */
@LeelenController(msg = "门禁卡")
@RequestMapping("/sys/egcard")
public class SysEgCardController {

	@Resource
	EgCardService egCardService;

	@Log("平台获取门禁卡list")
	@RequestMapping("/list")
	public @ResponseBody List<EgCard> getEgCard() {
		return egCardService.getEgCardList();
	}
}
