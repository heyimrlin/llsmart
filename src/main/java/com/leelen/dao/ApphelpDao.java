package com.leelen.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.leelen.entity.Apphelp;


@Mapper
public interface ApphelpDao {

	@Insert("insert into apphelp(id,problemtype,problemname,problemexplain,createtime,isshow,createer) "
			+ "values(#{id},#{problemtype},#{problemname},#{problemexplain},#{createtime},#{isshow},#{createer})")
	public int addapphelp(Apphelp apphelp);
	
	@Select("select * from apphelp where id=#{id}")
	public Apphelp findApphelpById(int id);
	
	@Update("update apphelp set problemtype=#{problemtype},problemname=#{problemname},problemexplain=#{problemexplain},"
			+ "createtime=#{createtime},isshow=#{isshow},createer=#{createer} where id=#{id}")
	public int modifyApphelp(Apphelp apphelp);
	
	@Delete("delete from apphelp where id=#{id}")
	public void deleteApphelpById(int id);
	
    @Delete("delete from apphelp where id in (${ids})")
    public int deleteApphelpBatch(@Param("ids")String ids);
	
	@Select("select * from apphelp")
	public List<Apphelp> findAllApphelp();
}
