/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:21:47
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.PlotInfo;

/**
 * @author xiaoxl
 *
 */
public interface PlotInfoRepository extends JpaRepository<PlotInfo, Integer> {

	// 获取小区状态正常
	List<PlotInfo> findByPlotstatus(int plotstatus);

	// 根据管理员获取对应小区

	// @Transactional(timeout = 10)
	// @Query("select p from plotinfo p where p.plotid = ?1")
	List<PlotInfo> findByPlotstatusAndPlotidIn(int plotstatus, Object[] objects);

	// ...

}
