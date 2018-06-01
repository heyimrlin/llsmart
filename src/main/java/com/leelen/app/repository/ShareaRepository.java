/**
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Sharea;

/**
 * @author xiaoxl by male
 * @time 2018年5月21日下午8:44:23
 * @class ShareaRepository.java
 */
public interface ShareaRepository extends JpaRepository<Sharea, Integer> {

	// 获取地区号
	Sharea findByShortname(String shortname);
}
