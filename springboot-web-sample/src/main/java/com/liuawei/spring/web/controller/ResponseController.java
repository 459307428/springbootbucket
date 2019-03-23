package com.liuawei.spring.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="response",method=RequestMethod.GET)
public class ResponseController {
	
	/**
	 * 响应内容
	 * @return
	 */
	@RequestMapping(value="/toContent")
	@ResponseBody
	public String toStr(){
		return "响应文本内容";
	}
	
	/**
	 * 响应内容 并设置响应码
	 * @return
	 */
	@RequestMapping(value="/entity/status")
	@ResponseBody
	public ResponseEntity<String> entityStatus(){
		ResponseEntity<String> responseEntity =new ResponseEntity<>("401未授权！",HttpStatus.UNAUTHORIZED);
		return responseEntity;
	}
	
	/**
	 * 响应内容  设置响应吗 设置响应头
	 * @return
	 */
	@RequestMapping(value="/entity/header")
	@ResponseBody
	public ResponseEntity<String> entityHeader(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.setExpires(System.currentTimeMillis()+1000);
		ResponseEntity<String> responseEntity =new ResponseEntity<>("哎呀成功了!",headers,HttpStatus.OK);
		return responseEntity;
	}
	
}
