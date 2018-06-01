/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:56:29
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.OperationLog;

/**
 * @author xiaoxl 平台操作日志
 *
 */
public interface OperationLogService {

	// 保存操作日志
	void save(OperationLog operationLog);

	// 获取日志
	List<OperationLog> getOperationLog();

	// ...
}
