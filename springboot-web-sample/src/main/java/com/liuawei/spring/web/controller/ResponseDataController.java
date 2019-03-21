package com.liuawei.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="response")
public class ResponseDataController {

	@RequestMapping(value="hello",method=RequestMethod.GET)
	@ResponseBody
	public String sayHello(){
		return "say hello";
	}
	
	@GetMapping(value="hell2")
	@ResponseBody
	public String sayHello2(){
		return "say hello2";
	}
	
	@GetMapping(value="produce/json",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> produceJson(){
		Map<String, Object> result = new HashMap<>();
		result.put("name", "json");
		result.put("age", 27);
		return result;
	}
	
	@GetMapping(value="produce/xml",produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public Map<String, Object> produceXml(){
		Map<String, Object> result = new HashMap<>();
		result.put("name", "xml");
		result.put("age", 27);
		return result;
	}
	
	@PostMapping(value="consume/json",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String consumeJson(@RequestBody String json){
		return "consumeJson请求参数:"+json;
	}
	
	@PostMapping(value="consume/xml",consumes=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String consumeXml(@RequestBody String xml){
		return "consumeXml请求参数:"+xml;
	}
}
