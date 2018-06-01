/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:14:08
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.SystemInfoRepository;
import com.leelen.app.service.SystemInfoService;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.entitys.SystemInfo;

/**
 * @author xiaoxl
 *
 */
@Service
public class SystemInfoServiceImpl implements SystemInfoService {

	@Autowired
	SystemInfoRepository systemInfoRepository;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.SystemInfoService#save(com.leelen.entitys.SystemInfo)
	 */
	@Override
	public void save(SystemInfo systemInfo) {
		// TODO Auto-generated method stub
		systemInfoRepository.save(systemInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.SystemInfoService#updateSystemInfo(int)
	 */
	@Override
	public RespEntity updateSystemInfo(int id) {
		// TODO Auto-generated method stub
		if (systemInfoRepository.updateSystemInfoById(id) == 1) {
			return new RespEntity(RespCode.SUCCESS, null);
		} else {
			return new RespEntity(RespCode.MODIFY_ERROR, null);
		}
	}

}
