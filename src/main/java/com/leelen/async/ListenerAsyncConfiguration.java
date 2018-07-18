/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  ListenerAsyncConfiguration.java   
* @Package com.leelen.async   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年7月17日 下午3:20:03   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.async;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**   
* @ClassName:  ListenerAsyncConfiguration   
* @Description:TODO(这里用一句话描述这个类的作用)   
* @author: leelen科技(xiaoxl) 
* @date:   2018年7月17日 下午3:20:03   
*     
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/
@Configuration
@EnableAsync
public class ListenerAsyncConfiguration implements AsyncConfigurer {

	/**   
	* <p>Title: getAsyncExecutor</p>   
	* <p>Description: </p>   
	* @return   
	* @see org.springframework.scheduling.annotation.AsyncConfigurer#getAsyncExecutor()   
	*/

	/**
     * 获取异步线程池执行对象
     * @return
     */
	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
		//使用Spring内置线程池任务对象
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置线程池参数
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
	}

	/**   
	* <p>Title: getAsyncUncaughtExceptionHandler</p>   
	* <p>Description: </p>   
	* @return   
	* @see org.springframework.scheduling.annotation.AsyncConfigurer#getAsyncUncaughtExceptionHandler()   
	*/

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}
