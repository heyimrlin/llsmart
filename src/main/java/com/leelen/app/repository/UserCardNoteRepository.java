/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:28:28
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.UserCardNote;

/**
 * @author xiaoxl
 *
 */
public interface UserCardNoteRepository extends JpaRepository<UserCardNote, Integer> {

	// 根据进出获取
	List<UserCardNote> findByInouttype(int inouttype);
}
