/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月18日下午2:34:51
 * @包名:com.leelen.app.dao
 * @描述:TODO
 */
package com.leelen.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.leelen.entitys.MoblieUser;

/**
 * @author xiaoxl
 *
 */
@Mapper
public interface MoblieUserDao {

	@Select("select * from moblieuser where tell=#{tell}")
	public MoblieUser findUserByTell(String tell);
}
