package com.leelen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.leelen.entity.MachineInfo;

@Mapper
public interface MachineInfoDao {

	@Select("select * from machineinfo where isactivate=1 and plotid=#{plotid}")
	public List<MachineInfo> getActivateMachinesByPlotId(String plotid);
}
