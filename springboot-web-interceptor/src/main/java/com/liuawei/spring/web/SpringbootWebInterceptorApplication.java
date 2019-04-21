package com.liuawei.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootWebInterceptorApplication  extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootWebInterceptorApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebInterceptorApplication.class, args);
	}

}
