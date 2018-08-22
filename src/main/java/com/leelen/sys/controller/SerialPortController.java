/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import com.leelen.common.annotation.Log;
import com.leelen.my.mycontroller.LeelenRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xiaoxl by male
 * @time 2018年5月24日下午2:10:11
 * @class SerialPortController.java
 */
@LeelenRestController(msg = "获取串口")
@RequestMapping("/system/comport")
@Api(value = "SerialPort-API", description = "获取串口")
public class SerialPortController {

	@Log("获取COM口")
	@RequestMapping("/getComPort")
	@ApiOperation(value = "获取COM口")
	@ApiResponse(code = 200, message = "null")
	public List<String> getComPort() {

		//return SerialTool.findPort();
		return null;
	}
}
