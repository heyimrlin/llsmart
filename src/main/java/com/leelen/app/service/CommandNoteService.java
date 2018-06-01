/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:53:42
 * @包名:com.leelen.app.service
 * @描述:TODO
 */
package com.leelen.app.service;

import java.util.List;

import com.leelen.entitys.CommandNote;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl 口令产生
 *
 */
public interface CommandNoteService {

	// 生成口令
	RespEntity save(String token, String unit, String app, long timestamp, String sign);

	// 根据用户id获取记录
	List<CommandNote> getCommandNoteByUid(String uid);

	// 判断口令，仿重复生成口令
	CommandNote getCommandNoteByCreateidAndValidtime(String createid, String validtime);

	List<CommandNote> getCommandNote();

	// ...
}
