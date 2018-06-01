/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:52:20
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.Apphelp;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl
 *
 */
public interface ApphelpService {

	// 添加帮助
	void save(Apphelp apphelp);

	// 获取所有
	List<Apphelp> getAllApphelp();

	// 根据状态获取
	RespEntity getAllApphelpByStatus(int status);

	// 修改
	RespEntity updateApphelpById(int status, int id);

	// ...
}
