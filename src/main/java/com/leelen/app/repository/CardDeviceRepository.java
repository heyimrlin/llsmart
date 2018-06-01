/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:14:58
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.CardDevice;

/**
 * @author xiaoxl
 *
 */
public interface CardDeviceRepository extends JpaRepository<CardDevice, Integer> {

	// 根据卡号获取设备号 多对多的关系
	List<CardDevice> findByCardno(String cardno);

	// 根据设备号获取卡号 多对多的关系
	List<CardDevice> findByDeviceid(String deviceid);

}
