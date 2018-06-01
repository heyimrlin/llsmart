/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:16:39
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leelen.entitys.CommandNote;

/**
 * @author xiaoxl
 *
 */
public interface CommandNoteRepository extends JpaRepository<CommandNote, Integer> {

	// 生成口令save

	// 根据用户id获取记录
	CommandNote findByCreateid(String createid);// 用户ID

	// 判断口令，仿重复生成口令、根据用户获取有效的口令
	@Query("")
	CommandNote getCommandfindByCreateidAndValidtime(String createid, String validtime);

	List<CommandNote> findByUid(String uid);

	// 根据用户获取有效的口令
	// CommandNote findByCreateidAndValidtime(String createid,String validtime);//

	// ...
}
