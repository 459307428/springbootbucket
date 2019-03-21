package com.liuawei.spring.async.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
	
	private Logger logger = LoggerFactory.getLogger(AsyncConfigurer.class);

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(40);
		executor.setQueueCapacity(20);
		executor.setKeepAliveSeconds(60);
		executor.setThreadNamePrefix("asyncTask-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 等待线程执行完才关闭容器
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncUncaughtExceptionHandler(){

			/* 
			 * 异常处理器，打印日志，方便跟踪bug 	 
			 */
			@Override
			public void handleUncaughtException(Throwable arg0, Method arg1, Object... arg2) {
				logger.error("=========task线程error:{}=========",arg0.toString());
				logger.error("=========method:{},params:{}=========",arg1.getName(),arg2);
			}
			
		};
	}

}
