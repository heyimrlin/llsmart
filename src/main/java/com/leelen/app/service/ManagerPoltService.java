/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:54:38
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.ManagerPolt;

/**
 * @author xiaoxl
 *
 */
public interface ManagerPoltService {

	// 查找管理员下的小区id
	List<ManagerPolt> getPoltByManagerId(String aid);

	// 查找小区有哪些管理员
	List<ManagerPolt> getManagerIdByPlotId(String plotid);

	List<ManagerPolt> getPlotByAid(String aid);
	// RespEntity getPlotByPlotid(Collection<PlotInfo> poltid);
	// ...
}
