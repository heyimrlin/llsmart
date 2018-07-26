/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月18日下午1:33:29
 * @包名:com.leelen.test.controller
 * @描述:TODO
 */
package com.leelen;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaoxl by male
 * @EnableCaching 注解配置启用缓存，自动配置配置文件的配置信息进行条件注入缓存所需实例 xiaoxl.931015@
 */

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SmartApplication extends SpringBootServletInitializer {

	@RequestMapping("/apphome")
	String home() {
		return "Hello World!";
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SmartApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SmartApplication.class, args);
		System.out.println("smart服务启动成功!!!");
	}

	// 定义一个线程池
	@EnableAsync
	@Configuration
	class TaskPoolConfig {

		@Bean("taskExecutor")
		public Executor taskExecutor() {
			ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
			executor.setCorePoolSize(10);// 核心线程数10：线程池创建时候初始化的线程数
			executor.setMaxPoolSize(20);// 最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
			executor.setQueueCapacity(200);// 缓冲队列200：用来缓冲执行任务的队列
			executor.setKeepAliveSeconds(60);// 允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
			executor.setThreadNamePrefix("taskExecutor-");// 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
			// 采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute
			// 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
			executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
			return executor;
		}
	}

}
