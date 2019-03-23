package com.liuawei.spring.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="jsp")
public class JspController {
	
	@GetMapping("index")
	public String toIndex(){
		return "index";
	}
	
	@GetMapping("user")
	public String toUser(HttpServletRequest request){
		request.setAttribute("name", "shuaige");
		request.setAttribute("age", "18");
		return "user";
	}

}
