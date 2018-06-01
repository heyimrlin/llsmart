/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:53:25
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.CardPlot;

/**
 * @author xiaoxl
 *
 */
public interface CardPlotService {

	// 根据卡号获取小区相关信息
	List<CardPlot> getCardData(String cardno);

	// 根据小区id获取门禁卡相关信息
	List<CardPlot> getPlotData(String plotid);

	// ...
}
