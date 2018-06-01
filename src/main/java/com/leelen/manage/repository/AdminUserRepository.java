/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月9日上午10:26:34
 * @包名:com.leelen.manage.repository
 * @描述:TODO
 */
package com.leelen.manage.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leelen.entity.AdminUser;

/**
 * @author xiaoxl
 *
 */
@Transactional
public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {

	// 管理端 登录
	AdminUser findByAccountAndPassword(String account, String password);

	// 更新Token
	@Modifying
	@Query(value = "update administrator a set a.token=?, a.tokentime=? where a.aid=?", nativeQuery = true)
	public int upDateToken(@Param("token") String token, @Param("tokentime") String tokentime,
			@Param("aid") String aid);

	// 修改密码
	@Modifying
	@Query(value = "update administrator a set a.password=? where a.token=?", nativeQuery = true)
	public int modifyPwd(@Param("password") String password, @Param("token") String token);

	// 匹配Token
	@Query(value = "select * from administrator where token=?", nativeQuery = true)
	AdminUser findByToken(String token);

	// 重置密码
	@Modifying
	@Query(value = "update administrator a set a.password=? where a.token=?", nativeQuery = true)
	public int resetPwd(@Param("password") String password, @Param("token") String token);
	
	// 修改手机号
	@Modifying
	@Query(value = "update administrator a set a.tell=? where a.token=?", nativeQuery = true)
	public int modifyTell(@Param("tell") String tell, @Param("token") String token);

}
