/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月18日下午2:34:51
 * @包名:com.leelen.app.dao
 * @描述:TODO
 */
package com.leelen.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.leelen.entitys.MoblieUser;

/**
 * @author xiaoxl
 *
 */
@Mapper
public interface MoblieUserDao {

	@Select("select * from moblieuser where tell=#{tell}")
	public MoblieUser findUserByTell(String tell);

	// 根据token查找用户id
	@Select("select * from moblieuser where token=#{token}")
	public MoblieUser findUserByToken(String token);

	// 根据uid更新用户数据
	@Update("update moblieuser set password=#{password},registertime=#{registertime} where uid=#{uid}")
	public int updateMoblieuser(@Param("password") String password, @Param("registertime") String registertime,
			@Param("uid") String uid);
}
