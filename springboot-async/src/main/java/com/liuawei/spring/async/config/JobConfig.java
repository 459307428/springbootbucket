package com.liuawei.spring.async.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.ErrorHandler;

@Configuration
@EnableAutoConfiguration
public class JobConfig implements SchedulingConfigurer {
	
	private static Logger Logger = LoggerFactory.getLogger(JobConfig.class);

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setAwaitTerminationSeconds(60);
		scheduler.setPoolSize(10);
		scheduler.setThreadNamePrefix("job-scheduler-");
		scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		scheduler.setWaitForTasksToCompleteOnShutdown(true);
		scheduler.setErrorHandler(new ErrorHandler() {
			
			@Override
			public void handleError(Throwable t) {
				Logger.error("异常了---",t);
				
			}
		});
		scheduler.initialize();
		taskRegistrar.setScheduler(scheduler);
	}

}
