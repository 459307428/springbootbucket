package com.liuawei.spring.scheduler.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.ErrorHandler;

@Configuration
public class JobSchedulingConfigurer implements SchedulingConfigurer {

	private static final Logger logger = LoggerFactory.getLogger(JobSchedulingConfigurer.class);

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler handler = new ThreadPoolTaskScheduler();
		handler.setPoolSize(10);
		handler.setThreadNamePrefix("schedule-");
		handler.setAwaitTerminationSeconds(60);
		handler.setErrorHandler(new ErrorHandler() {

			@Override
			public void handleError(Throwable t) {
				logger.info("异常统一处理......" + t.getMessage());
				// 发送邮件
				// 发送短信
			}
		});
		handler.initialize();
		taskRegistrar.setScheduler(handler);
	}

}
