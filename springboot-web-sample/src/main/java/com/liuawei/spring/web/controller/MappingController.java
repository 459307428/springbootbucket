package com.liuawei.spring.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("mapping")
public class MappingController {
	
	/**
	 * 路径匹配
	 * @return
	 */
	@RequestMapping(value="path",method=RequestMethod.GET)
	@ResponseBody
	public String byPath(){
		return "匹配路径 GET请求";
	}
	
	/**
	 * 路径模式匹配 path/pattern/下面的路径
	 * @return
	 */
	@RequestMapping(value="path/pattern/*",method=RequestMethod.GET)
	@ResponseBody
	public String byPathPattern1(HttpServletRequest request){
		return "路径模式匹配"+request.getRequestURI();
	}
	
	/**
	 * 路径模式匹配2 path/pattern/下面的路径并且结尾是do
	 * @return
	 */
	@RequestMapping(value="path/pattern/*.do",method=RequestMethod.GET)
	@ResponseBody
	public String byPathPattern2(HttpServletRequest request){
		return "路径模式匹配"+request.getRequestURI();
	}
	
	
	/**
	 * 方法匹配 知道的方法可以访问
	 * @return
	 */
	@RequestMapping(value="method",method={RequestMethod.POST,RequestMethod.DELETE})
	@ResponseBody
	public String byMethod(HttpServletRequest request){
		return "方法过滤请求"+request.getMethod();
	}
	
	/**
	 * 有相对应的参数才可以访问
	 * @return
	 */
	@RequestMapping(value="params",method=RequestMethod.GET,params="name")
	@ResponseBody
	public String byParams(HttpServletRequest request){
		return "请求参数必须包含name才可以访问"+request.getParameterMap();
	}
	
	/**
	 * 不包含相对应的参数才可以访问
	 * @return
	 */
	@RequestMapping(value="params",method=RequestMethod.GET,params="!name")
	@ResponseBody
	public String byParams2(HttpServletRequest request){
		return "请求参数不包含name才可以访问"+request.getParameterMap();
	}
	
	/**
	 * 有相对应的请求头才可以访问
	 * @return
	 */
	@RequestMapping(value="headers",method=RequestMethod.GET,headers={"token","userid"})
	@ResponseBody
	public String byHeaders(HttpServletRequest request){
		return "请求头必须包含token,userid才可以访问"+request.getHeaderNames();
	}
	
	/**
	 * 只接受application/json;charset=UTF-8的请求头
	 * @param json
	 * @return
	 */
	@PostMapping(value="consume/json",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String consumeJson(@RequestBody String json){
		return "consumeJson请求参数:"+json;
	}
	
	/**
	 * 只接受application/xml的请求头
	 * @param xml
	 * @return
	 */
	@PostMapping(value="consume/xml",consumes=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String consumeXml(@RequestBody String xml){
		return "consumeXml请求参数:"+xml;
	}
	
	/**
	 * 响应JSON格式
	 * @return
	 */
	@GetMapping(value="produce/json",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> byProduceJson(){
		Map<String, Object> result = new HashMap<>();
		result.put("name", "json");
		result.put("age", 27);
		return result;
	}
	
	/**
	 * 响应XML格式
	 * @return
	 */
	@GetMapping(value="produce/xml",produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public Map<String, Object> produceXml(){
		Map<String, Object> result = new HashMap<>();
		result.put("name", "xml");
		result.put("age", 27);
		return result;
	}
	
	/**
	 * 响应图片文件流
	 * @param response
	 * @throws IOException
	 */
	@GetMapping(value="produce/jpeg",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public void produceJpeg(HttpServletResponse response) throws IOException{
		File file = new File(
				"D:\\liuawei\\springbootbucket\\resources\\zuixihuandewangfei.jpeg");
		FileInputStream fis = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		byte [] data = new byte[1024];
		while (fis.read(data)!=-1) {
			os.write(data);	
		}
		os.flush();
		os.close();
	}
}
