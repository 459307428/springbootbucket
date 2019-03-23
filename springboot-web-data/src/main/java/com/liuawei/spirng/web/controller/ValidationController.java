package com.liuawei.spirng.web.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liuawei.spirng.web.model.ValBean;

@RestController
public class ValidationController {

	@GetMapping("validata")
	public String validata(@Valid ValBean bean,BindingResult result){
		if (result.hasErrors()) {
			return "参数校验失败:";
		}
		return "参数校验成功";
	}
}
