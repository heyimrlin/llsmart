/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:20:28
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.leelen.app.repository.AdvertisingRepository;
import com.leelen.app.service.AdvertisingService;
import com.leelen.entitys.Advertising;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.publicmethod.MyMethod;

/**
 * @author xiaoxl
 *
 */
@Service
public class AdvertisingServiceImpl implements AdvertisingService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	AdvertisingRepository advertisingRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AdvertisingService#save(com.leelen.entitys.
	 * Advertising)
	 */
	@Override
	public void save(Advertising advertising) {
		// TODO Auto-generated method stub
		advertisingRepository.save(advertising);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.AdvertisingService#getAllAdvertisingByAuditstatus(int)
	 */
	@Override
	public RespEntity getAllAdvertisingByAuditstatus(String advtype, int auditstatus) {
		// TODO Auto-generated method stub "0"广告类型，0表示平台广告 1表示小区广告
		List<Advertising> advertisings = advertisingRepository.findByAdvtypeAndAuditstatusAndIsshow(advtype,
				auditstatus, 0);
		return new RespEntity(RespCode.SUCCESS, advertisings);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AdvertisingService#getAllAdvertisingByIsshow(int)
	 */
	@Override
	public RespEntity getAllAdvertisingByIsshow(int isshow) {
		// TODO Auto-generated method stub
		List<Advertising> advertisings = advertisingRepository.findByIsshow(isshow);
		if (advertisings.size() > 0) {
			return new RespEntity(RespCode.SUCCESS, advertisings);
		} else {
			return new RespEntity(RespCode.SUCCESS, "暂无数据");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AdvertisingService#
	 * getAllAdvertisingByAdvtypeAndAuditstatusAndIsshow(java.lang.String, int, int)
	 */
	@Override
	public RespEntity getAllAdvertisingByAdvtypeAndAuditstatusAndIsshow(String advtype, int auditstatus, int isshow,
			String plotid, String token, String sign) {
		// TODO Auto-generated method stub advtype 广告类型，0表示平台广告 1表示小区广告
		List<Advertising> advertisings = advertisingRepository.findByAdvtypeAndAuditstatusAndIsshowAndPlotid(advtype,
				auditstatus, isshow, plotid);
		return new RespEntity(RespCode.SUCCESS, advertisings);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.AdvertisingService#getAllAdv()
	 */
	@Override
	public List<Advertising> getAllAdv() {
		// TODO Auto-generated method stub
		return advertisingRepository.findAll();
	}

	/**
	 * <p>
	 * Title: getAllAdvertisingByAdvtypeAndAuditstatusAndIsshowImg
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param advtype
	 * @param auditstatus
	 * @param isshow
	 * @param plotid
	 * @param token
	 * @param sign
	 * @return
	 * @see com.leelen.app.service.AdvertisingService#getAllAdvertisingByAdvtypeAndAuditstatusAndIsshowImg(java.lang.String,
	 *      int, int, java.lang.String, java.lang.String, java.lang.String)
	 */

	@Override
	public RespEntity getAllAdvertisingByAdvtypeAndAuditstatusAndIsshowImg(String advtype, int auditstatus, int isshow,
			String plotid, String token, String sign, long timestamp) {
		// TODO Auto-generated method stub

		if (!MyMethod.checkTimestamp(timestamp, System.currentTimeMillis())) {
			return new RespEntity(RespCode.INVALID_REQUEST, null);
		}

		String StrSign = "/app/adv/getImg?token=" + token + "&timestamp=" + timestamp;
		if (!MyMethod.verdictSign(StrSign, sign)) {
			return new RespEntity(RespCode.SIGN_ERROR, null);
		}

		List<Advertising> advertisings = advertisingRepository.findByAdvtypeAndAuditstatusAndIsshowAndPlotid(advtype,
				auditstatus, isshow, plotid);
		Map<String, Object> map = new HashMap<String, Object>();
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < advertisings.size(); i++) {
			map.put("advid", advertisings.get(i).getAdvid());
			map.put("advimg", advertisings.get(i).getAdvimg());
			map.put("advlink", advertisings.get(i).getAdvlink());
			jsonArray.add(i, map);
		}
		return new RespEntity(RespCode.SUCCESS, jsonArray);
	}

}
