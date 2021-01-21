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
	@RequestMapping(value = "/appJoin")
	public String appJoin(Model model, AppUserDTO dto) {
		//먼저 중복가입인지 확인한다.
		AppUserDTO chaeck = service.appUserCheck(dto);
		
		int succ = 0;
		if(chaeck == null) {	//중복가입이 아니면 회원가입진행
			succ = service.appJoin(dto);
		}else {					//중복가입이면 실패 리턴
			succ = -100;
		}
		
		model.addAttribute("appJoin", String.valueOf(succ));

		return "appJoin";
	}

	//로그인
	@RequestMapping(value = "/appLogin")
	public String appLogin(Model model, AppUserDTO dto) {
		model.addAttribute("appLogin", service.appLogin(dto));
		return "appLogin";
	}
	
	//카카오 로그인
	@RequestMapping(value = "/appKakaoLogin")
	public String appKakaoLogin(Model model, AppUserDTO dto) {
		//회원에 등록되어있는 카카오 유저인지 확인
		AppUserDTO chaeck = service.appUserCheck(dto);
		
		int succ = 0;
		if(chaeck == null) {	//회원 등록이 안되어있으면 db에 회원 정보 저장 진행
				service.appJoin(dto);
		}
		
		model.addAttribute("appLogin", service.appLogin(dto));		
		
		return "appLogin";
	}
	
	//회원정보수정
	@RequestMapping(value = "/userInfoChange")
	public String userInfoModify(AppUserDTO dto, Model model) {
		model.addAttribute("userInfoChange", service.userInfoModify(dto));
		return "userInfoChange";
	}
}
