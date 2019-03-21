package com.liuawei.spring.async;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.liuawei.spring.async.Application;
import com.liuawei.spring.async.task.TaskDemo1;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class ApplicationTests {

	@Autowired
	private TaskDemo1 taskDemo1;
	
	@Test
	public void testAsyncTask() throws InterruptedException{
		CountDownLatch downLatch = new CountDownLatch(45);
		for (int i = 0; i < 45; i++) {
			taskDemo1.doTask(i,downLatch);
		}
		downLatch.await();
		//Thread.currentThread().join();
	}
	

}
