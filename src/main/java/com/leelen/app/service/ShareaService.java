/**
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import com.leelen.entitys.Sharea;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日下午8:42:42
 * @class ShareaService.java
 */
public interface ShareaService {

	// 获取地区号
	Sharea getAreaCodeByShortname(String shortname);
}
