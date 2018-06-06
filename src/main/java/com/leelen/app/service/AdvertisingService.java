/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:52:02
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.Advertising;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl
 *
 */
public interface AdvertisingService {

	// 添加广告
	void save(Advertising advertising);

	// 根据广告类型获取有效(审核通过)以及可显示的广告
	RespEntity getAllAdvertisingByAdvtypeAndAuditstatusAndIsshow(String advtype, int auditstatus, int isshow,
			String plotid, String token, String sign);

	// 根据审核状态获取广告
	RespEntity getAllAdvertisingByAuditstatus(String advtype, int auditstatus);

	// 获取所可显示的广告
	RespEntity getAllAdvertisingByIsshow(int isshow);

	List<Advertising> getAllAdv();

}
