package com.liuawei.spring.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

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
