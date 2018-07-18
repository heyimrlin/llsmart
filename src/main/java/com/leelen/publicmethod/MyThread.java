/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  MyThread.java   
* @Package com.leelen.publicmethod   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年6月29日 下午2:39:12   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.publicmethod;

import com.leelen.app.service.OperationLogService;
import com.leelen.entitys.OperationLog;

/**
 * @ClassName: MyThread
 * @Description:TODO封装一个独立的线程
 * @author: leelen科技(xiaoxl)
 * @date: 2018年6月29日 下午2:39:12
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class MyThread extends Thread {
	
	private OperationLogService operationLogService;
	
	private OperationLog operationLog;

	/**   
	* @Title:  MyThread   
	* @Description:    TODO(这里用一句话描述这个方法的作用)   
	* @param:  @param operationLogService
	* @param:  @param operationLog  
	* @throws   
	*/
	public MyThread(OperationLogService operationLogService, OperationLog operationLog) {
		//super();
		this.operationLogService = operationLogService;
		this.operationLog = operationLog;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		// 处理业务
		operationLogService.save(operationLog);
	}

}
