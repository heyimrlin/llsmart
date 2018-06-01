/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:26:22
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.leelen.entitys.SystemInfo;

/**
 * @author xiaoxl
 *
 */
public interface SystemInfoRepository extends JpaRepository<SystemInfo, Integer> {

	@Query(value = "update systeminfo u where u.id=?", nativeQuery = true)
	@Modifying
	@Transactional
	int updateSystemInfoById(int id);
}
