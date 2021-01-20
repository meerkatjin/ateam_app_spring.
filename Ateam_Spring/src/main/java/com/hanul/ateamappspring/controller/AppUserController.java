package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import user.dto.AppUserDTO;
import user.service.AppUserService;

@Controller
public class AppUserController {
	@Autowired
	private AppUserService service;

	@RequestMapping(value = "/appJoin", method = { RequestMethod.GET, RequestMethod.POST })
	public String appJoin(Model model, AppUserDTO dto) {

		model.addAttribute("appJoin", String.valueOf(service.appJoin(dto)));

		return "appJoin";
	}

	@RequestMapping(value = "/appLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String appLogin(Model model, AppUserDTO dto) {

		model.addAttribute("jsonReturn", service.appLogin(dto));

		return "jsonReturn";
	}
	
	@RequestMapping(value = "/userInfoChange")
	public String userInfoModify(AppUserDTO dto, Model model) {
		
		model.addAttribute("userInfoChange", service.userInfoModify(dto));
		
		return "userInfoChange";
	}
	
	

}
