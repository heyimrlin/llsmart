/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午7:27:11
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

import com.leelen.entitys.RespEntity;
import com.leelen.entitys.SysUser;

/**
 * @author xiaoxl
 *
 */
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

	// 根据用户手机号修改状态
	@Query(value = "update sysuser u set u.useable=? where u.tell=?", nativeQuery = true)
	@Modifying
	@Transactional
	int updateuseable(@Param("useable") int useable, @Param("tell") String tell);// 修改用户的状态

	// 遵循jpa规则,获取用户信息
	SysUser findByTell(String tell);

	// 根据uid获取用户信息
	SysUser findByUid(String uid);

	// 获取成员
	List<SysUser> findByFamilyhost(String familyhost);

	// // 配置用户
	// void save(SysUser sysUser);
	//
	// // 检查是否移动端已注册
	// boolean checkUserInMoblie(String tell);
	//
	// // 修改用户状态
	// int updataUserStatus(String tell);
	//
	// // 获取用户状态
	// int getUserStatus(String uid);// 移动端接口要此判断
	//
	// // 修改用户信息
	@Query(value = "update sysuser u set u.useable=? where u.tell=?", nativeQuery = true)
	@Modifying
	@Transactional
	RespEntity updateUserInfo(SysUser sysUser);

	// ...

}
