package com.liuawei.spring.async.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerDemo {
	
	private static Logger logger = LoggerFactory.getLogger(SchedulerDemo.class);
	
	/**
	 * 任务固定延时多久
	 * @throws InterruptedException
	 */
	@Scheduled(fixedDelay = 2000)
	public void taskFixedDelay() throws InterruptedException {
		logger.info("taskFixedDelay开始:{}", System.currentTimeMillis());
		Thread.sleep(6000);
		logger.info("taskFixedDelay结束:{}", System.currentTimeMillis());
	}
	
	/**
	 * 任务固定频率
	 * @throws InterruptedException
	 */
	@Scheduled(initialDelay=1000,fixedRate = 2000)
	public void taskFixedRate() throws InterruptedException {
		logger.info("taskFixedRate开始:{}", System.currentTimeMillis());
		Thread.sleep(6000);
		logger.info("taskFixedRate结束:{}", System.currentTimeMillis());
	}
	
}
