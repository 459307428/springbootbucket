package com.liuawei.spring.async.task;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TaskDemo1 {

	private static final Logger logger = LoggerFactory.getLogger(TaskDemo1.class);

	@Async
	public void doTask(int i,CountDownLatch downLatch) throws InterruptedException {
		long start = System.currentTimeMillis();
		logger.info("doTask{}开始",i);
		Thread.sleep(new Random().nextInt(1000)+400000);
		long end = System.currentTimeMillis();
		logger.info("doTask{}结束,总耗时:{}",i,end-start);
		downLatch.countDown();
	}
	
	public void doTask2(int i,CountDownLatch downLatch) throws InterruptedException {
		long start = System.currentTimeMillis();
		logger.info("doTask2--{}开始",i);
		Thread.sleep(new Random().nextInt(1000)+100);
		long end = System.currentTimeMillis();
		logger.info("doTask2--{}结束,总耗时:{}",i,end-start);
		downLatch.countDown();
	}
	
	
}
