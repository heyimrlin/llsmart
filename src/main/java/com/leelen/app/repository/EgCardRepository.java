/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:17:34
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelen.entitys.EgCard;

/**
 * @author xiaoxl
 *
 */
public interface EgCardRepository extends JpaRepository<EgCard, Integer> {

}
