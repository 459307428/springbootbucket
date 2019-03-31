package com.liuawei.spirng.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpirngWebExceptionApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpirngWebExceptionApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpirngWebExceptionApplication.class, args);
	}

}
