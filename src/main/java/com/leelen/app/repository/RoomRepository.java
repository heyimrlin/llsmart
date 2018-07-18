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

}
