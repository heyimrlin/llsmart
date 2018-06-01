/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:17:57
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.MachineInfoRepository;
import com.leelen.app.service.CardDeviceService;
import com.leelen.app.service.MachineInfoService;
import com.leelen.entitys.CardDevice;
import com.leelen.entitys.MachineInfo;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl
 *
 */
@Service
public class MachineInfoServiceImpl implements MachineInfoService {

	Logger logger = LoggerFactory.getLogger(getClass());

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	MachineInfoRepository machineInfoRepository;

	@Resource
	CardDeviceService cardDeviceService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MachineInfoService#save(com.leelen.entitys.
	 * MachineInfo)
	 */
	@Override
	public void save(MachineInfo machineInfo) {
		// TODO Auto-generated method stub
		machineInfoRepository.save(machineInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.MachineInfoService#updataMachineInfoStatus(java.lang.
	 * String)
	 */
	@Override
	public int updataMachineInfoStatus(String deviceid) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MachineInfoService#getMachineByPlotid(java.lang.
	 * String)
	 */
	@Override
	public RespEntity getMachineByPlotid(String token, long timestamp, String sign, String plotid) {
		// TODO Auto-generated method stub
		List<MachineInfo> machineInfos = machineInfoRepository.findByPlotidAndDevicestatusAndIsactivate(plotid, 0, 0);
		// JSONObject json = new JSONObject();
		// json.put("", value)
		return new RespEntity(RespCode.SUCCESS, machineInfos);
	}

	/*
	 * (non-Javadoc)// 根据卡id-->获取设备id集合-->获取设备信息数据集
	 * 
	 * @see com.leelen.app.service.MachineInfoService#getMachineByCardno(java.lang.
	 * String)
	 */
	@Override
	public RespEntity getMachineByCardno(String cardno) {
		// TODO Auto-generated method stub
		List<CardDevice> devices = cardDeviceService.getDeviceDataByCard(cardno);
		String[] sArrays = new String[devices.size()];

		for (int i = 0; i < devices.size(); i++) {
			sArrays[i] = devices.get(i).getDeviceid();
		}
		System.out.println(">>>" + sArrays.length + sArrays[0]);
		logger.info("该管理员有" + sArrays.length + "小区");
		List<MachineInfo> machineInfos = machineInfoRepository.findByDevicestatusAndDeviceidIn(0, sArrays);
		if (machineInfos.size() > 0) {
			return new RespEntity(RespCode.SUCCESS, machineInfos);
		} else {
			return new RespEntity(RespCode.SUCCESS, "该卡没有对应设备");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.MachineInfoService#getMachineList()
	 */
	@Override
	public List<MachineInfo> getMachineList() {
		// TODO Auto-generated method stub
		return machineInfoRepository.findAll();
	}

}
