/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:52:44
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.Appv;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl
 *
 */
public interface AppvService {

	// 获取APP版本信息
	RespEntity getAppV(String appid);

	// 修改APP版本信息
	RespEntity updateAppv(Appv appv);

	List<Appv> getAppVinfo();

	// ...
}
