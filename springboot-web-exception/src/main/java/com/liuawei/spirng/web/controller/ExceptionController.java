package com.liuawei.spirng.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liuawei.spirng.web.exception.BussinessException;


@RestController
@RequestMapping("exception")
public class ExceptionController {

	@RequestMapping("demo")
	public int demo(Integer a,Integer b){
		return a/b;
	}
	
	@RequestMapping("demo2")
	public int demo2(Integer a,Integer b){
		if (b==0) {
			throw new BussinessException("2001", "参数不能是0或空");
		}
		return a/b;
	}
}
