package com.hejianlin.taskexecutor;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//实现基于线程池的TaskExector
@Configuration
@EnableAsync // 开启异步任务支持
@ComponentScan("com.hejianlin.taskexecutor")
public class TaskExectorConfig implements AsyncConfigurer {
	// 重写方法，返回一个ThreadPoolTaskExecutor对象
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor threadPoolExecutor=new ThreadPoolTaskExecutor();
		threadPoolExecutor.setCorePoolSize(5);
		threadPoolExecutor.setMaxPoolSize(10);
		threadPoolExecutor.setQueueCapacity(25);
		threadPoolExecutor.initialize();//初始化线程池
		return threadPoolExecutor;
	}

	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

}
