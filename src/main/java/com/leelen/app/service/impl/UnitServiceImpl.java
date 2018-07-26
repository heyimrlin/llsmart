/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  UnitServiceImpl.java   
* @Package com.leelen.app.service.impl   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年7月26日 上午11:11:31   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelen.app.repository.UnitRepository;
import com.leelen.app.service.UnitService;
import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;

/**
 * @ClassName: UnitServiceImpl
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: leelen科技(xiaoxl)
 * @date: 2018年7月26日 上午11:11:31
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	UnitRepository unitRepository;

	/**
	 * <p>
	 * Title: findByUnitid
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param unitid
	 * @return
	 * @see com.leelen.app.service.UnitService#findByUnitid(java.lang.String)
	 */

	@Override
	public RespEntity findByUnitid(String unitid) {
		// TODO Auto-generated method stub
		return new RespEntity(RespCode.SUCCESS, unitRepository.findByUnitid(unitid));
	}

	/**
	 * <p>
	 * Title: findByPlotid
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param plotid
	 * @return
	 * @see com.leelen.app.service.UnitService#findByPlotid(java.lang.String)
	 */

	@Override
	public RespEntity findByPlotid(String token, String sign, long timestamp, String plotid) {
		// TODO Auto-generated method stub
		return new RespEntity(RespCode.SUCCESS, unitRepository.findByPlotid(plotid));
	}

	/**
	 * <p>
	 * Title: findByCreater
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param creater
	 * @return
	 * @see com.leelen.app.service.UnitService#findByCreater(java.lang.String)
	 */

	@Override
	public RespEntity findByCreater(String creater) {
		// TODO Auto-generated method stub
		return new RespEntity(RespCode.SUCCESS, unitRepository.findByCreater(creater));
	}

}
