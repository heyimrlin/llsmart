/**
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Plot;

/**
 * @author xiaoxl by male
 * @time 2018年6月20日上午11:26:25
 * @class PlotRepository.java
 */
public interface PlotRepository extends JpaRepository<Plot, Integer> {

	List<Plot> findByPlotidIn(String[] plotids);
}
