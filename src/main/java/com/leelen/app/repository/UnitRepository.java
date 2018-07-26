/**
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Unit;

/**
 * @author xiaoxl by male
 * @time 2018年6月20日上午11:28:38
 * @class UnitRepository.java
 */
public interface UnitRepository extends JpaRepository<Unit, Integer> {

	// 根据单元id获取单元
	Unit findByUnitid(String unitid);

	// 根据小区id获取单元
	List<Unit> findByPlotid(String plotid);

	// 根据创建人获取单元
	List<Unit> findByCreater(String creater);
}
