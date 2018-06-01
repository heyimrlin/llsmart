/**
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.leelen.entitys.WyToken;

/**
 * @author xiaoxl by male
 * @time 2018年5月19日下午5:00:48
 * @class WyTokenRepository.java
 */
public interface WyTokenRepository extends JpaRepository<WyToken, Integer> {

	// 根据管理员ID获取token
	WyToken findByAid(String aid);

	// 更新token
	@Query(value = "update wytoken u set u.token=?, u.tokentime=? where u.aid=?", nativeQuery = true)
	@Modifying
	@Transactional
	int updateToken(@Param("aid") String aid, @Param("token") String token, @Param("tokentime") String tokentime);

	// 根据token获取aid
	WyToken findByToken(String token);
}
