/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:07:56
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.PlotInfo;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl 小区信息
 *
 */
public interface PlotInfoService {

	// 创建小区
	void save(PlotInfo plotInfo);

	// 获取所有小区
	RespEntity getAllPlot();

	// 根据业主获取小区信息
	RespEntity getPoltBy(String tell);

	// 根据小区ID数据集获取小区
	RespEntity getPlotByPlotid(String token, long timestamp, String app, String sign);

	List<PlotInfo> getPlotList();

	PlotInfo getPlotinfo(String plotid);

	// ...
}
