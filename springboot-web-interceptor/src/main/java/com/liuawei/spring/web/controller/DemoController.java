package com.liuawei.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("interceptor")
public class DemoController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping("index")
	public String demo(){
		logger.info("DemoController index 正在执行!");
		return "查看拦截器的顺序";
	}

}
