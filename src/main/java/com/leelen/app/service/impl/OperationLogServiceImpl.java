/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月17日下午8:16:55
 * @包名:com.leelen.app.service.impl
 * @描述:TODO
 */
package com.leelen.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.OperationLogRepository;
import com.leelen.app.service.OperationLogService;
import com.leelen.entitys.OperationLog;

/**
 * @author xiaoxl
 *
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

	@Autowired
	OperationLogRepository operationLogRepository;

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.OperationLogService#save(com.leelen.entitys.
	 * OperationLog)
	 */
	@Override
	public void save(OperationLog operationLog) {
		// TODO Auto-generated method stub
		operationLogRepository.save(operationLog);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leelen.app.service.OperationLogService#getOperationLog()
	 */
	@Override
	public List<OperationLog> getOperationLog() {
		// TODO Auto-generated method stub
		return operationLogRepository.findAll();
	}

}
