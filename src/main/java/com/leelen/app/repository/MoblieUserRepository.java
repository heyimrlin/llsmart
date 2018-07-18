/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:19:34
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.leelen.entitys.MoblieUser;

/**
 * @author xiaoxl
 *
 */
public interface MoblieUserRepository extends JpaRepository<MoblieUser, Integer> {

	// 判断用户是否在平台已配置
	MoblieUser findByTell(String tell);

	// 根据token获取用户id
	MoblieUser findByToken(String token);

	// 根据用户id获取token
	MoblieUser findByUid(String uid);

	// 更新token
	@Query(value = "update moblieuser u set u.token=?,u.tokentime=? where u.tell=?", nativeQuery = true)
	@Modifying
	@Transactional
	int updateToken(@Param("token") String token, @Param("tokentime") String tokentime, @Param("tell") String tell);// 修改用户的状态

	// 修改密码
	@Query(value = "update moblieuser u set u.password=? where u.token=?", nativeQuery = true)
	@Modifying
	@Transactional
	int modifyPwd(@Param("password") String password, @Param("token") String token);

	// 重置密码
	@Query(value = "update moblieuser u set u.password=? where u.token=?", nativeQuery = true)
	@Modifying
	@Transactional
	int resetPwd(@Param("password") String password, @Param("token") String token);

	// 获取成员

	// 退出登录
	@Query(value = "update moblieuser u set u.isonline=? where u.token=?", nativeQuery = true)
	@Modifying
	@Transactional
	int loginout(@Param("isonline") int isonline, @Param("token") String token);

}
