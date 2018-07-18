/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:11:05
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import com.leelen.entitys.RespEntity;
import com.leelen.entitys.UserCardNote;

/**
 * @author xiaoxl 用户门禁卡进出记录
 *
 */
public interface UserCardNoteService {

	// 保存进出记录
	RespEntity save(UserCardNote userCardNote);

	RespEntity save(UserCardNote[] userCardNote);

	// ...
}
