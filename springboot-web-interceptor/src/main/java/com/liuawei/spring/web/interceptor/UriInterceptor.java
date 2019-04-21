package com.liuawei.spring.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class UriInterceptor implements HandlerInterceptor{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 定义接口白名单
	private static String[] INTERFACE_WHITE_LIST = {"login","index"};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("UriInterceptor preHandle controller 执行之前");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("UriInterceptor postHandle controller 执行之后,渲染视图之前");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("UriInterceptor afterCompletion  渲染视图之后");		
	}

	
}
