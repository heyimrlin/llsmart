/**
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl by male
 * @time 2018年6月20日上午11:34:44
 * @class UnitService.java
 */
public interface UnitService {

	// 根据单元id获取单元
	RespEntity findByUnitid(String unitid);

	// 根据小区id获取单元
	RespEntity findByPlotid(String token, String sign, long timestamp, String plotid);

	// 根据创建人获取单元
	RespEntity findByCreater(String creater);
}
