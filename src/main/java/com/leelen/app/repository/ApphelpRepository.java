/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:13:27
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.leelen.entitys.Apphelp;

/**
 * @author xiaoxl
 *
 */
public interface ApphelpRepository extends JpaRepository<Apphelp, Integer> {

	// 获取APP帮助
	List<Apphelp> findByStatus(int status);

	@Query(value = "update apphelp u set u.status=? where u.id=?", nativeQuery = true)
	@Modifying
	@Transactional
	int updateStatusById(@Param("status") int status, @Param("id") int id);
}
