package com.liuawei.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value="forward")
public class ForwardController {

	@GetMapping(value="/toUser1")
	public String toUser1(){
		return "forward:user";
	}
	
	@GetMapping(value="/toUser2")
	public ModelAndView toUser2(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "姓名");
		mv.addObject("age","28");
		mv.setViewName("user");
		return mv;
	}
}
