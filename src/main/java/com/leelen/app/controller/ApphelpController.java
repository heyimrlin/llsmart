/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.ApphelpService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日上午11:02:48
 * @class ApphelpController.java
 */
@LeelenRestController(msg = "APP帮助")
@RequestMapping("/app/ah")
public class ApphelpController {

	@Resource
	ApphelpService apphelpService;

	@Log("获取帮助")
	@RequestMapping("/getApphelp")
	public RespEntity getApphelp(@RequestParam("status") int status) {
		return apphelpService.getAllApphelpByStatus(status);
	}

}
