/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  WebLogAspect.java   
* @Package com.leelen.mylog   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年7月2日 下午4:26:24   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.mylog;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.leelen.app.repository.OperationLogRepository;
import com.leelen.entitys.OperationLog;

/**
 * @ClassName: WebLogAspect
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: leelen科技(xiaoxl)
 * @date: 2018年7月2日 下午4:26:24
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {

	@Autowired
	OperationLogRepository operationLogRepository;

	OperationLog operationLog = new OperationLog();

	private Logger logger = Logger.getLogger(getClass());

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	// 通过@Pointcut定义的切入点为com.leelen.test包下的所有函数（对web层所有请求处理做切入点），然后通过@Before实现，对请求内容的日志记录（可以根据需要调整内容），最后通过@AfterReturning记录请求返回的对象。
	@Pointcut(value = "execution(public * com.leelen.*.controller.*.*(..))||execution(public * com.leelen.*.app.controller.*.*(..))||execution(public * com.leelen.*.api.*.*(..))") //
	// 可参考:https://blog.csdn.net/zhengchao1991/article/details/53391244
	// @Pointcut(value = "execution(public * *())")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		try {
			HttpServletRequest request = attributes.getRequest();
			if (null == request) {
				logger.info("RESPONSE : " + null);
			} else {

				// 记录下请求内容
				logger.info(
						"\n*********************************************************************************************************");
				logger.info("请求时间:" + dateFormater.format(date));
				logger.info("URL : " + request.getRequestURL().toString());
				logger.info("HTTP_METHOD : " + request.getMethod());
				logger.info("IP : " + request.getRemoteAddr());
				logger.info("remoteHost" + request.getRemoteHost());
				logger.info("remotePort" + request.getRemotePort());
				logger.info("headers" + getHeadersInfo(request));
				logger.info("parameters" + JSONObject.toJSONString(request.getParameterMap()));
				logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
						+ joinPoint.getSignature().getName());
				logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
				logger.info("METHOD:" + request.getMethod());
				logger.info("queryString" + request.getQueryString());

				// BasicDBObject logInfo = getBasicDBObject(request, joinPoint);
				// logger.info(logInfo);

				operationLog.setOperdate(dateFormater.format(date));
				operationLog.setUrl(request.getRequestURL().toString());
				operationLog.setMethod(request.getMethod() + joinPoint.getSignature().getDeclaringTypeName() + "."
						+ joinPoint.getSignature().getName());
				operationLog.setRequestip(request.getRemoteAddr());
				operationLog.setParams("headers" + getHeadersInfo(request) + "parameters"
						+ JSONObject.toJSONString(request.getParameterMap()));

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}

	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("RESPONSE : " + JSONObject.toJSONString(ret));
		operationLog.setDetail(JSONObject.toJSONString(ret));
		operationLogRepository.save(operationLog);
		logger.info(
				"\n*********************************************************************************************************");
	}

	// private BasicDBObject getBasicDBObject(HttpServletRequest request, JoinPoint
	// joinPoint) {
	// // 基本信息
	// BasicDBObject bd = new BasicDBObject();
	// bd.append("requestURL", request.getRequestURL().toString());
	// bd.append("requestURI", request.getRequestURI());
	// bd.append("queryString", request.getQueryString());
	// bd.append("remoteAddr", request.getRemoteAddr());
	// bd.append("remoteHost", request.getRemoteHost());
	// bd.append("remotePort", request.getRemotePort());
	// bd.append("localAddr", request.getLocalAddr());
	// bd.append("localName", request.getLocalName());
	// bd.append("method", request.getMethod());
	// bd.append("headers", getHeadersInfo(request));
	// bd.append("parameters", request.getParameterMap());
	// bd.append("classMethod",
	// joinPoint.getSignature().getDeclaringTypeName() + "." +
	// joinPoint.getSignature().getName());
	// bd.append("args", Arrays.toString(joinPoint.getArgs()));
	// return bd;
	// }

	private Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

}