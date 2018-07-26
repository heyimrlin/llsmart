/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:54:17
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.MachineInfo;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl 设备
 *
 */
public interface MachineInfoService {

	// 添加设备
	void save(MachineInfo machineInfo);

	// 改变设备状态
	int updataMachineInfoStatus(String deviceid);

	// 根据小区id获取所有有效设备
	RespEntity getMachineByPlotid(String token, long timestamp, String sign, String plotid, int devicestatus,
			int isactivate);

	// ...

	// 根据卡id-->获取设备id集合-->获取设备信息数据集
	RespEntity getMachineByCardno(String cardno);

	// List
	List<MachineInfo> getMachineList();
}
