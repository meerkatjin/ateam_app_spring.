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

	//회원가입
	@RequestMapping(value = "/appJoin", method = { RequestMethod.GET, RequestMethod.POST })
	public String appJoin(Model model, AppUserDTO dto) {

		AppUserDTO chaeck = service.appUserCheck(dto);
		
		int succ = 0;
		if(chaeck == null) {
			succ = service.appJoin(dto);
		}else {
			succ = -100;
		}
		
		model.addAttribute("appJoin", String.valueOf(succ));

		return "appJoin";
	}

	//로그인
	@RequestMapping(value = "/appLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String appLogin(Model model, AppUserDTO dto) {

		model.addAttribute("appLogin", service.appLogin(dto));

		return "appLogin";
	}
	
	//회원정보수정
	@RequestMapping(value = "/userInfoChange")
	public String userInfoModify(AppUserDTO dto, Model model) {
		/*
		 * System.out.println("email : " + dto.getUser_email());
		 * System.out.println("pw : " + dto.getUser_pw()); System.out.println("name : "
		 * + dto.getUser_nm()); System.out.println("addr : " + dto.getUser_addr());
		 * System.out.println("phone : " + dto.getUser_phone_no());
		 * System.out.println("img : " + dto.getUser_pro_img());
		 */
		model.addAttribute("userInfoChange", service.userInfoModify(dto));
		
		return "userInfoChange";
	}
}
