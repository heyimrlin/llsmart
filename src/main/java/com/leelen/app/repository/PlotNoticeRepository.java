/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:22:41
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leelen.entitys.PlotNotice;

/**
 * @author xiaoxl
 *
 */
public interface PlotNoticeRepository extends JpaRepository<PlotNotice, Integer> {

	// 根据小区获取有效公告
	@Query(value = "select * from plotnotice where plotid=? and validity>? and isshow=?", nativeQuery = true)
	List<PlotNotice> findByPlotidAndValidityAndIsshow(String plotid, Date validity, int isshow);
}
