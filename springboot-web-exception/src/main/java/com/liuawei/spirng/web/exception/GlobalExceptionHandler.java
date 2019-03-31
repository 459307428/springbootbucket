package com.liuawei.spirng.web.exception;

import java.io.IOException;
import java.rmi.server.RMIClassLoaderSpi;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 处理业务异常
	 * @param request
	 * @param e
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value={BussinessException.class})
	@ResponseBody
	public ResultModel jsonHandler(HttpServletRequest request,Exception e) throws IOException{
		BussinessException bussinessException = (BussinessException) e;		
		logger.error("请求路径:{}",request.getRequestURI());
		logger.error("请求方法:{}",request.getMethod());
		if (request.getMethod().equals(RequestMethod.GET)) {
			logger.error("请求参数:{}",request.getQueryString());
		}else if (request.getMethod().equals(RequestMethod.POST)) {
			logger.error("请求参数:{}",request.getReader().toString());
		}
		logger.error("异常原因:{}",e);
		ResultModel rm = new ResultModel<>();
		rm.setCode(bussinessException.getCode());
		rm.setMsg(bussinessException.getMessage());
		return rm;
	}	
}
