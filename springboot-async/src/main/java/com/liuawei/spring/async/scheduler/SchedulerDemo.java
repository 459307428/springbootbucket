package com.liuawei.spring.async.scheduler;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.liuawei.spring.async.task.TaskDemo1;

@Component
public class SchedulerDemo {

	private static Logger logger = LoggerFactory.getLogger(SchedulerDemo.class);

	@Autowired
	private TaskDemo1 taskDemo1;

	/**
	 * 任务固定延时多久
	 * 
	 * @throws InterruptedException
	 */
	@Scheduled(fixedDelay = 2000)
	public void taskFixedDelay() throws InterruptedException {
		logger.info("taskFixedDelay开始:{}", System.currentTimeMillis());

		CountDownLatch downLatch = new CountDownLatch(15);
		for (int i = 0; i < 2; i++) {
			taskDemo1.doTask(i, downLatch);
		}
		downLatch.await(20, TimeUnit.SECONDS);
		logger.info("taskFixedDelay结束:{}", System.currentTimeMillis());
	}
	
	/**
	 * 任务固定延时多久
	 * 
	 * @throws InterruptedException
	 */
//	@Scheduled(fixedDelay = 2000)
//	public void taskFixedDelay2() throws InterruptedException {
//		logger.info("taskFixedDelay2开始:{}", System.currentTimeMillis());
//
//		CountDownLatch downLatch = new CountDownLatch(15);
//		for (int i = 0; i < 15; i++) {
//			taskDemo1.doTask(i, downLatch);
//		}
//		downLatch.await();
//		logger.info("taskFixedDelay2结束:{}", System.currentTimeMillis());
//	}

	/**
	 * 任务固定频率
	 * 
	 * @throws InterruptedException
	 */
//	@Scheduled(initialDelay = 1000, fixedRate = 2000)
//	public void taskFixedRate() throws InterruptedException {
//		CountDownLatch downLatch = new CountDownLatch(15);
//		for (int i = 0; i < 15; i++) {
//			taskDemo1.doTask2(i, downLatch);
//		}
//		downLatch.await();
//		logger.info("taskFixedDelay结束:{}", System.currentTimeMillis());
//	}

}
