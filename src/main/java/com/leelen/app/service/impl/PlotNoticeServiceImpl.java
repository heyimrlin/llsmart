/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:15:44
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.PlotNoticeRepository;
import com.leelen.app.service.PlotNoticeService;
import com.leelen.entitys.PlotNotice;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;

/**
 * @author xiaoxl
 *
 */
@Service
public class PlotNoticeServiceImpl implements PlotNoticeService {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	PlotNoticeRepository plotNoticeRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.PlotNoticeService#save(com.leelen.entitys.PlotNotice)
	 */
	@Override
	public void save(PlotNotice plotNotice) {
		// TODO Auto-generated method stub
		plotNoticeRepository.save(plotNotice);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.PlotNoticeService#getAllPlotNotice()
	 */
	@Override
	public List<PlotNotice> getAllPlotNotice() {
		// TODO Auto-generated method stub
		return plotNoticeRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.PlotNoticeService#getAllPlotNotice(int)
	 */
	@Override
	public List<PlotNotice> getAllPlotNotice(int isshow) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.PlotNoticeService#updataPlotNotice(com.leelen.entitys.
	 * PlotNotice)
	 */
	@Override
	public int updataPlotNotice(PlotNotice plotNotice) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.leelen.app.service.PlotNoticeService#getPlotAllNotice(java.lang.String,
	 * int, java.util.Date)
	 */
	@Override
	public RespEntity getPlotAllNotice(String plotid, int isshow, Date validity) {
		// TODO Auto-generated method stub
		List<PlotNotice> plotNotices = plotNoticeRepository.findByPlotidAndValidityAndIsshow(plotid, new Date(),
				isshow);
		if (plotNotices.size() > 0) {
			return new RespEntity(RespCode.SUCCESS, plotNotices);
		} else {
			return new RespEntity(RespCode.SUCCESS, "暂无公告");
		}
	}

}
