/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:15:38
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.CardPlot;

/**
 * @author xiaoxl
 *
 */
public interface CardPlotRepository extends JpaRepository<CardPlot, Integer> {

	List<CardPlot> findByCardno(String cardno);

	List<CardPlot> findByPlotid(String plotid);
}
