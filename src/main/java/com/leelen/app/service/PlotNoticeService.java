/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:08:39
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.Date;
import java.util.List;

import com.leelen.entitys.PlotNotice;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl 小区公告
 *
 */
public interface PlotNoticeService {

	// 创建小区公告
	void save(PlotNotice plotNotice);

	// 获取所有公告
	List<PlotNotice> getAllPlotNotice();

	// 获取可显示公告
	List<PlotNotice> getAllPlotNotice(int isshow);

	// 修改公告
	int updataPlotNotice(PlotNotice plotNotice);

	// 根据小区获取对应公告
	RespEntity getPlotAllNotice(String plotid, int isshow, Date validity);

	// ...
}
