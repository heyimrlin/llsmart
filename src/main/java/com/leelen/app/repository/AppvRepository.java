/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:14:18
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.Appv;

/**
 * @author xiaoxl app版本
 *
 */
public interface AppvRepository extends JpaRepository<Appv, Integer> {

	//
	Appv findById(int id);
}
