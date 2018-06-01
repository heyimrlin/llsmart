/**
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.OperationLogService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.OperationLog;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl by male
 * @time 2018年5月31日下午4:57:07
 * @class SysOperationLogController.java
 */
@LeelenController(msg = "操作日志记录")
@RequestMapping("/sys/log")
public class SysOperationLogController {

	@Resource
	OperationLogService operationLogService;

	@Log("日志list")
	@RequestMapping("/list")
	public @ResponseBody List<OperationLog> getOperationLog() {
		return operationLogService.getOperationLog();
	}

}
