package com.liuawei.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value="forward")
public class ForwardController {

	@GetMapping(value="/tobaidu")
	public String toBaidu(){
		return "forward:https://www.baidu.com";
	}
	
	@GetMapping(value="/tosina")
	public ModelAndView toSina(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "姓名");
		mv.addObject("age","28");
		mv.setViewName("https://www.baidu.com");
		return mv;
	}
}
