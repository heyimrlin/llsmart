/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:53:01
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.CardDevice;

/**
 * @author xiaoxl
 *
 */
public interface CardDeviceService {

	// 根据卡号
	List<CardDevice> getDeviceDataByCard(String cardno);

	// 根据设备编号标识
	List<CardDevice> getCardDataByDevice(String deviceid);

	// ...
}
