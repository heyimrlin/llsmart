/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:11:16
 * @包名:com.leelen.app.repository
 * @描述:TODO
 */
package com.leelen.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.leelen.entitys.Administrator;

/**
 * @author xiaoxl
 *
 */
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	// 获取所有有效管理员 isuse=0有效
	List<Administrator> findByIsuse(int isuse);

	// 改变管理员的状态
	@Query(value = "update administrator u set u.isuse=? where u.tell=?", nativeQuery = true)
	@Modifying
	@Transactional
	int updateuseable(@Param("isuse") int isuse, @Param("tell") String tell);// 修改用户的状态

	// 管理员登录
	Administrator findByTellOrAccountAndPasswordAndIsuse(String tell, String account, String password, int isuse);

	// 修改密码
	@Query(value = "update administrator u set u.password=? where u.aid=?", nativeQuery = true)
	@Modifying
	@Transactional
	int modifyAdminPassword(@Param("password") String password, @Param("aid") String aid);

	// 重置密码
	@Query(value = "update administrator u set u.password=? where u.tell=?", nativeQuery = true)
	@Modifying
	@Transactional
	int resetAdminPassword(@Param("password") String password, @Param("tell") String tell);

	// 手机号更改
	@Query(value = "update administrator u set u.tell=? where u.token=?", nativeQuery = true)
	@Modifying
	@Transactional
	int updateAdminTell(@Param("tell") String tell, @Param("token") String token);

	// 修改信息
	// R updateAdmin(Administrator administrator);
	Administrator findByTell(String tell);

	// 根据id
	Administrator findByAid(String aid);

}
