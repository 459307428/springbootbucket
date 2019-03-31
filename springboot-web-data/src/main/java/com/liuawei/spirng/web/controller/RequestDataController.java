package com.liuawei.spirng.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liuawei.spirng.web.model.UserInfoModel;


@RestController
@RequestMapping("requestdata")
public class RequestDataController {

	private Logger logger = LoggerFactory.getLogger(RequestDataController.class);
	
	@GetMapping("getCookie")
	public String withOrginal(String name,String age,HttpServletResponse response) {
		Cookie cookie = new Cookie("token", "tokenValue");
		cookie.setHttpOnly(true);
		cookie.setComment("演示");
		response.addCookie(cookie);
		return "返回Cookie";
	}
	
	@GetMapping("withParam")
	public String withParam(@RequestParam(name="name",required=true)String name,
			@RequestParam(name="name",required=false,defaultValue="18")String age){
		return "获取的参数数据name:"+name+"age:"+age;
	}
	
	@GetMapping("withParam2")
	public String withParam(@RequestParam List<String> name){
		return "获取的参数数据name:"+name.toArray().toString();
	}
	
	@GetMapping("withPath/{userId}/info")
	public String withPath(@PathVariable String userId){
		return "获取请求路径参数"+userId;
	}
	
	@GetMapping("withHeader")
	public String withHeader(@RequestHeader String token){
		return "获取请求头参数"+token;
	}
	
	@GetMapping("withCookie")
	public String withCookie(@CookieValue String token){
		return "获取cookie参数"+token;
	}
	
	@PostMapping("withBody1")
	public String withBody1(@RequestBody String body){
		return "获取请求内容数据1:"+body;
	}
	
	@PostMapping("withBody2")
	public String withBody2(@RequestBody JSONObject body){
		return "获取请求内容数据2:"+body;
	}
	
	@PostMapping("withBody3")
	public String withBody3(@RequestBody Map<String, String> body){
		return "获取请求内容数据3:"+body;
	}
	
	@PostMapping("withBody4")
	public String withBody4(@RequestBody UserInfoModel body){
		return "获取请求内容数据4:"+body;
	}
	
	@PostMapping("withBody5")
	public String withBody5(@RequestBody HttpEntity<String> httpEntity){
		return "获取请求内容数据5:"+httpEntity.getBody()+"	headers:"+httpEntity.getHeaders();
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	@PostMapping("withBody6")
	public String withBody6(@RequestBody List<Map<String, Object>> list){
		return "获取请求内容数据6:"+list.toArray().toString();
	}
	
	/**
	 * 获取FORM表单数据  通过参数
	 * @param formKey1
	 * @param formKey2
	 * @return
	 */
	@PostMapping("withForm1")
	public String withForm1(@RequestParam String formKey1,@RequestParam String formKey2){
		return "获取FORM表单参数formKey1:"+formKey1+"	:formKey2:"+formKey2;
	}
	
	/**
	 * 获取FORM表单数据 通过对象
	 * @param userInfo
	 * @return
	 */
	@PostMapping("withForm2")
	public String withForm2(@ModelAttribute UserInfoModel userInfo){
		return "获取FORM表单参数:"+userInfo.toString();
	}
	
	@PostMapping("withRequest")
	public String withRequest(HttpServletRequest request) throws IOException{
		// 获取请求参数
		request.getParameter("");
		// 获取请求头
		request.getHeader("");
		// 获取cookie
		request.getCookies();
		// 获取路径信息 
		request.getPathInfo();
		// 获取body流
		request.getInputStream();
		return "其实上面讲了那么多，这个才是大BOOS";
	}
	
	
}
