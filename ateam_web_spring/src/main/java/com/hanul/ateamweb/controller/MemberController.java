package com.hanul.ateamweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	//로그인화면 요청 처리
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}
