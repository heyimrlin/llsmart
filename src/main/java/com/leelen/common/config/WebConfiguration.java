/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月19日下午1:55:51
 * @包名:com.leelen.common.config
 * @描述:TODO
 */
package com.leelen.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xiaoxl 注解@Configuration，标明了该类是一个配置类并且会将该类作为一个SpringBean添加到IOC容器内
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
	 * addInterceptors(org.springframework.web.servlet.config.annotation.
	 * InterceptorRegistry) 拦截器配置
	 * 
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		super.addInterceptors(registry);
		// registry.addInterceptor(new UserInterceptor()).addPathPatterns("/sys/**");
		registry.addInterceptor(new UserInterceptor()).addPathPatterns("/leelensmart/sys/**");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
	 * addCorsMappings(org.springframework.web.servlet.config.annotation.
	 * CorsRegistry) 跨域CORS配置
	 * 
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		super.addCorsMappings(registry);
		registry.addMapping("/cors/**").allowedHeaders("*").allowedMethods("POST", "GET").allowedOrigins("*");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
	 * addViewControllers(org.springframework.web.servlet.config.annotation.
	 * ViewControllerRegistry) 视图控制器配置
	 * 
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		super.addViewControllers(registry);
		registry.addViewController("/").setViewName("/index");
	}

}
