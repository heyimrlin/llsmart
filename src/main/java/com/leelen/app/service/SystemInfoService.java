/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:10:00
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import com.leelen.entitys.RespEntity;
import com.leelen.entitys.SystemInfo;

/**
 * @author xiaoxl
 *
 */
public interface SystemInfoService {

	// 配置平台信息
	void save(SystemInfo systemInfo);

	// 修改平台信息
	RespEntity updateSystemInfo(int id);

	// ...
}
