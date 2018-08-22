/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.ShareaService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.Sharea;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月22日下午2:03:19
 * @class ShareaController.java
 */
@LeelenRestController(msg = "地区号查询")
@RequestMapping("/app/area")
@Api(value = "Sharea-API", description = "查询地区号")
public class ShareaController {

	Logger logger = LoggerFactory.getLogger(Sharea.class);

	@Resource
	ShareaService shareaService;

	@Log("获取地区号")
	@RequestMapping(value = "/getCode", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" }, consumes = { "application/json" })
	@ApiOperation(value = "获取地区号")
	@ApiImplicitParam(name = "shortname", value = "地区简称", paramType = "form", dataType = "String", required = true)
	@ApiResponse(code = 200, message = "获取地区号成功", response = Sharea.class)
	public Sharea getCode(@RequestParam(value = "shortname") String shortname) {
		Sharea sharea = shareaService.getAreaCodeByShortname(shortname);
		logger.info(sharea.getMergername() + ":" + sharea.getZip_code());
		return sharea;
	}
}
