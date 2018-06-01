/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:54:00
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.EgCard;

/**
 * @author xiaoxl 门禁卡管理
 *
 */
public interface EgCardService {

	// 添加门禁卡
	void save(EgCard egCard);

	List<EgCard> getEgCardList();

	// ...
}
