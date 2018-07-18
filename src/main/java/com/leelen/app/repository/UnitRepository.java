/**
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Unit;

/**
 * @author xiaoxl by male
 * @time 2018年6月20日上午11:28:38
 * @class UnitRepository.java
 */
public interface UnitRepository extends JpaRepository<Unit, Integer> {

}
