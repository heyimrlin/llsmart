/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:29:11
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.UserPlot;

/**
 * @author xiaoxl
 *
 */
public interface UserPlotRepository extends JpaRepository<UserPlot, Integer> {

	//// 根据用户id获取对应小区
	List<UserPlot> findByUid(String uid);

	List<UserPlot> findByPlotid(String plotid);
}
