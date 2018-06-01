/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:18:11
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.MachineInfo;

/**
 * @author xiaoxl
 *
 */
public interface MachineInfoRepository extends JpaRepository<MachineInfo, Integer> {

	// 根据小区id获取所有有效设备
	List<MachineInfo> findByPlotidAndDevicestatusAndIsactivate(String plotid, int devicestatus, int isactivate);

	// 根据卡id-->获取设备id集合-->获取设备信息数据集
	List<MachineInfo> findByDevicestatusAndDeviceidIn(int devicestatus, Object[] deviceids);
}
