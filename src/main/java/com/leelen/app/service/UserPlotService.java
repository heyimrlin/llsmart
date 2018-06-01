/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:11:30
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.UserPlot;

/**
 * @author xiaoxl 住户、小区
 *
 */
public interface UserPlotService {

	// 根据用户id获取对应小区
	List<UserPlot> getPlotByUid(String uid);

	// 根据小区id获取对应住户
	List<UserPlot> getUidByPlotId(String plotid);

	// ...
}
