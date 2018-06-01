/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月25日下午6:57:39
 * @包名:com.leelen.dao
 * @描述:TODO
 */
package com.leelen.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.leelen.entity.UserThree;

/**
 * @author xiaoxl
 *
 */
@Mapper
public interface UserThreeDao {

	@Insert("insert into userthree(token_id,token_value,end_time,uid) values(#{tokenid},#{tokenvalue},#{endtime},#{uid})")
	public int insertuserthree(UserThree userThree);
	
	@Select("select * from userthree where uid=#{uid}")
	public UserThree findUserThreeByUid(@Param("uid") String uid);
	
//	@Select("select token_id,token_value,end_time,uid from userthree where uid=#{uid}")  
//	public UserThree findUserThreeByUid(String uid);
}
