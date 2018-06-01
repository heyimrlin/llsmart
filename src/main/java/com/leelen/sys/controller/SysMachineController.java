/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月8日下午4:51:58
 * @包名:com.leelen.sys.controller
 * @描述:TODO
 */
package com.leelen.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.app.service.MachineInfoService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.MachineInfo;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @author xiaoxl
 *
 */
@LeelenController(msg = "设备")
@RequestMapping("/sys/machine")
public class SysMachineController {

	// 注:设备ID=地区号+社区号+楼幢单元号+设备序列号

	@Resource
	MachineInfoService machineInfoService;

	@Log("平台获取设备list")
	@RequestMapping("/list")
	public @ResponseBody List<MachineInfo> getMachineList() {
		return machineInfoService.getMachineList();
	}

}
