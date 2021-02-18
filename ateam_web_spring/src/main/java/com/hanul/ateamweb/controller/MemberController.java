package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	//로그인화면 요청 처리
	@RequestMapping("/login")
	public String login(HttpSession session) {
		session.removeAttribute("category");
		return "member/login";
	}

	//회원가입화면 요청 처리
	@RequestMapping("/join")
	public String join(HttpSession session) {
		session.removeAttribute("category");
		return "member/join";
	}

}
