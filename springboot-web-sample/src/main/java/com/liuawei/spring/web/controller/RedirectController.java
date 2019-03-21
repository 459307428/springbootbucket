package com.liuawei.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value="redirect")
public class RedirectController {

	@GetMapping(value="/tobaidu")
	public String toBaidu(){
		return "redirect:https://www.baidu.com";
	}
	
	@GetMapping(value="/tosina")
	public RedirectView toSina(){
		RedirectView rv = new RedirectView();
		rv.setUrl("https://www.sina.com.cn/");
		return rv;
	}
}
