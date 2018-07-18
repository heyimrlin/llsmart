/**
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Appmenus;

/**
 * @author xiaoxl by male
 * @time 2018年6月26日下午2:11:30
 * @class AppmenusRepository.java
 */
public interface AppmenusRepository extends JpaRepository<Appmenus, Integer> {

	List<Appmenus> findByOpidIn(String[] opids);
}
