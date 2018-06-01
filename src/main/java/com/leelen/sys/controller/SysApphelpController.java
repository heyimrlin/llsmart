/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.ApphelpService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.Apphelp;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl by male
 * @time 2018年5月31日下午3:45:37
 * @class SysApphelpController.java
 */
@LeelenController(msg = "APP帮助")
@RequestMapping("/sys/apphelp")
public class SysApphelpController {

	@Resource
	ApphelpService apphelpService;

	@Log("平台获取APP帮助")
	@RequestMapping("/list")
	public @ResponseBody List<Apphelp> getAllApphelp() {
		return apphelpService.getAllApphelp();
	}
}
