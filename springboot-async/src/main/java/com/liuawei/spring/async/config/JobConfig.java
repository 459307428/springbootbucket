package com.liuawei.spring.async.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableAutoConfiguration
public class JobConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setAwaitTerminationSeconds(60);
		scheduler.setPoolSize(10);
		scheduler.setThreadNamePrefix("job-scheduler-");
		scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		scheduler.setWaitForTasksToCompleteOnShutdown(true);
		scheduler.initialize();
		taskRegistrar.setScheduler(scheduler);
	}

}
