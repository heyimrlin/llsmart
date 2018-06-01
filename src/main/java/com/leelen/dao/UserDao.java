/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月19日下午6:48:15
 * @包名:com.leelen.dao
 * @描述:TODO
 */
package com.leelen.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.leelen.entity.User;
import com.leelen.entity.UserThree;


/**
 * @author xiaoxl
 *
 */
@Mapper
public interface UserDao {

	@Select("select * from user where id=#{id}")
	public User findUser(int id);
	
	@Select("select * from user where tell=#{tell}")
	public User findUserId(String tell);
	
	@Select("select * from user where tell=#{tell}")
	public User findUserByTeleNum(String tell);
	
	//更新Token
	@Update("update userthree set token_value=#{token_value},end_time=#{end_time} where uid=#{uid}")
	public int updataToken(UserThree userThree);
	
	//重置密码
	@Update("update user set password=#{password} where tell=#{tell}")
	public void resetUserPassword(@Param("password")String password,@Param("tell")String tell);
	
	//修改密码
	@Update("update user set password=#{password} where uid=#{uid}")
	public void modifyUserPassword(@Param("password")String password,@Param("uid")String uid);

	@Update("update user set online=0 where tell=#{tell}")
	public void userLogout(String tell);
	
	List<User> list(Map<String,Object> map);
}
