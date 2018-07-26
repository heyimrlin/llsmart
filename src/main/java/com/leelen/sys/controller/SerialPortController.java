/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.leelen.common.annotation.Log;
import com.leelen.my.mycontroller.LeelenRestController;
import com.leelen.serialPort.SerialTool;

/**
 * @author xiaoxl by male
 * @time 2018年5月24日下午2:10:11
 * @class SerialPortController.java
 */
@LeelenRestController(msg = "获取串口")
@RequestMapping("/system/comport")
public class SerialPortController {

	@Log("获取COM口")
	@RequestMapping("/getComPort")
	public List<String> getComPort() {

		//return SerialTool.findPort();
		return null;
	}
}
