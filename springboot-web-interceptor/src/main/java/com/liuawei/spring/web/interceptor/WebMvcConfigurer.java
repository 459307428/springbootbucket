package com.liuawei.spring.web.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

	
	@Bean
	public UriInterceptor uriInterceptor(){
		return new UriInterceptor();
	}
	
	/* 
	 * 自定义拦截器添加到拦截器链中
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 匹配所有请求
		registry.addInterceptor(uriInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
