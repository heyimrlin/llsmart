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

import com.leelen.app.service.MachineInfoService;
import com.leelen.common.annotation.Log;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日下午2:01:51
 * @class MachineInfoController.java 设备新增(设备号、设备子码、创建时间)
 */
@LeelenRestController(msg = "设备")
@RequestMapping("/app/plotMachine")
@Api(value = "MachineInfo-API", description = "设备信息相关接口")
public class MachineInfoController {

	@Resource
	MachineInfoService machineInfoService;

	@Log("获取指定小区下的有效设备")
	@RequestMapping(value = "/getPm", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "获取设备", notes = "获取指定小区下的有效设备")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long", required = true),
		@ApiImplicitParam(name = "plotid", value = "小区标识", paramType = "form", dataType = "String", required = true)})
	@ApiResponse(code = 200, message = "获取设备成功")
	public RespEntity getPlotOfMachine(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "plotid") String plotid) {
		return machineInfoService.getMachineByPlotid(token, timestamp, sign, plotid, 0, 0);
	}

	// 根据卡id-->获取设备id集合-->获取设备信息数据集
	@Log("根据卡id-->获取设备id集合-->获取设备信息数据集")
	@RequestMapping(value = "/getCm", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ApiOperation(value = "根据卡ID获取设备信息数据集", notes = "先根据卡ID获取设备ID集合，再获取设备信息数据集")
	@ApiImplicitParams({@ApiImplicitParam(name = "cardno", value = "卡ID", paramType = "form", dataType = "String", required = true)})
	@ApiResponse(code = 200, message = "获取信息成功")
	public RespEntity getMachineByCardno(HttpServletRequest request, @RequestParam(value = "cardno") String cardno) {
		return machineInfoService.getMachineByCardno(cardno);
	}

	// 激活设备(重新激活)
	// id:设备号
	// name:设备激活后备注名字，如:单元机为单元(楼幢)名 1#;围墙机为大门 东门，南门等
	// bluetooth:设备蓝牙地址名
	// wall:激活类型是否为围墙机(false=单元机，true=围墙机)
	// building:单元(楼幢)标识，激活成单元机须设置
	@Log("激活设备(重新激活)")
	@RequestMapping(value = "/activateDevice", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	@ApiOperation(value = "激活设备", notes = "激活设备或重新激活设备")
	@ApiImplicitParams({@ApiImplicitParam(name = "token", value = "用户凭证", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "sign", value = "URL签名", paramType = "header", dataType = "String", required = true),
		@ApiImplicitParam(name = "timestamp", value = "时间戳", paramType = "header", dataType = "long", required = true),
		@ApiImplicitParam(name = "deviceid", value = "设备标识", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "devicename", value = "设备名称", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "bluetooth", value = "蓝牙标识", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "devicetype", value = "设备类型", paramType = "form", dataType = "String", required = true),
		@ApiImplicitParam(name = "building", value = "楼栋标识", paramType = "form", dataType = "String", required = true)})
	@ApiResponse(code = 200, message = "激活设备成功")
	public RespEntity activateDevice(HttpServletRequest request, @RequestHeader(value = "token") String token,
			@RequestHeader(value = "sign") String sign, @RequestHeader(value = "timestamp") long timestamp,
			@RequestParam(value = "deviceid") String deviceid, @RequestParam(value = "devicename") String devicename,
			@RequestParam(value = "bluetooth") String bluetooth, @RequestParam(value = "devicetype") int devicetype,
			@RequestParam(value = "building") String building) {
		return machineInfoService.activateDevice(deviceid, devicename, bluetooth, devicetype, building);
	}

	// ...
}
