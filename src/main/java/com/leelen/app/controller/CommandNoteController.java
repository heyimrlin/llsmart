/**
 * @包名:com.leelen.app.controller
 * @描述:TODO
 */
package com.leelen.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.leelen.app.service.CommandNoteService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月19日下午7:27:21
 * @class CommandNoteController.java
 */
@LeelenRestController(msg = "口令生成接口API")
@RequestMapping("/app/command")
@Api(value = "CommandNote-API", description = "口令生成接口")
public class CommandNoteController {

	@Resource
	CommandNoteService commandNoteService;

	@Log("生成口令") // id:设备号 visit:预约开门时间
	@RequestMapping(value = "/productCommand", produces = { "application/json;charset=UTF-8" }, method = {RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "生成口令", notes = "根据用户请求的数据生成口令")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long", required = true),
		@ApiImplicitParam(name = "unitid", value = "单元标识", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "app", value = "用户类型", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "deviceid", value = "设备标识", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "visittime", value = "预约时间", paramType = "form", dataType = "long", required = true)})
	@ApiResponse(code = 200, message = "生成口令成功")
	public RespEntity productCommand(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "unitid") String unitid, @RequestParam(value = "app") String app,
			@RequestParam(value = "deviceid") String deviceid, @RequestParam(value = "visittime") long visittime) {
		return commandNoteService.save(token, unitid, app, timestamp, sign, deviceid, visittime);
	}
}
