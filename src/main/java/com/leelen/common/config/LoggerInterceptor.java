/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月28日上午10:43:56
 * @包名:com.leelen.common.config
 * @描述:TODO
 */
package com.leelen.common.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.leelen.entity.LoggerEntity;
import com.sleepycat.je.utilint.LoggerUtils;

/**
 * @author xiaoxl 日志记录
 */
public class LoggerInterceptor implements HandlerInterceptor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// 创建日志实体
		LoggerEntity logger = new LoggerEntity();
		// 获取请求sessionid
		String sessionId = request.getRequestedSessionId();
		// 获取请求路径
		String uri = request.getRequestURI();
		// 获取请求参数信息
		String paramData = JSON.toJSONString(request.getParameterMap(),
				SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
		//
		logger.setClienIp(LoggerUtils.getStackTrace());

		return false;
	}

	/*
	 * (non-Javadoc) .properties
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
