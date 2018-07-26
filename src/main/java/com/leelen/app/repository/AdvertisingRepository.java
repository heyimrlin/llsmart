/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:12:39
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Advertising;

/**
 * @author xiaoxl
 *
 */
public interface AdvertisingRepository extends JpaRepository<Advertising, Integer> {

	List<Advertising> findByAdvtypeAndAuditstatusAndIsshowAndPlotid(String advtype, int auditstatus, int isshow,String plotid);

	List<Advertising> findByAdvtypeAndAuditstatusAndIsshow(String advtype, int auditstatus, int isshow);
	
	// 根据广告ID获取
	Advertising findByAdvid(String advid);

	//
	List<Advertising> findByIsshow(int isshow);

	// ...
}
