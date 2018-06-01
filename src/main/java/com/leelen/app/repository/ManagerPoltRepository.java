/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:18:49
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.ManagerPolt;

/**
 * @author xiaoxl 管理员、小区
 *
 */
public interface ManagerPoltRepository extends JpaRepository<ManagerPolt, Integer> {

	// List<ManagerPolt>
	List<ManagerPolt> findByAid(String aid);

	List<ManagerPolt> findByPlotid(String plotid);

	List<ManagerPolt> findByAidIn(String aid);
}
