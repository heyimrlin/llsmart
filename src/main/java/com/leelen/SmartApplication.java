/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月18日下午1:33:29
 * @包名:com.leelen.test.controller
 * @描述:TODO
 */
package com.leelen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xiaoxl
 * @EnableCaching 注解配置启用缓存，自动配置配置文件的配置信息进行条件注入缓存所需实例 xiaoxl.931015@
 */

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SmartApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SmartApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SmartApplication.class, args);
		System.out.println("smart服务启动成功!!!");
	}
}
