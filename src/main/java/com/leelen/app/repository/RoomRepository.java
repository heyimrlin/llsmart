/**
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Room;

/**
 * @author xiaoxl by male
 * @time 2018年6月20日上午11:29:22
 * @class RoomRepository.java
 */
public interface RoomRepository extends JpaRepository<Room, Integer> {

	// 根据创建人获取房间
	Room findByCreater(String creater);

	// 根据小区id获取房间
	Room findByPlotid(String plotid);

	// 根据单元id获取房间
	Room findByUnitid(String unitid);

	// 根据房间id获取房间
	Room findByRoomid(String roomid);

	// 根据小区id和单元id获取房间
	Room findByPlotidAndUnitid(String plotid, String unitid);

}
