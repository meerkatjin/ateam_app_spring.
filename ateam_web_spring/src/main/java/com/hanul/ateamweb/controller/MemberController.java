package com.hanul.ateamweb.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import member.MemberVO;

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
	
	//로그인 요청 처리
	@ResponseBody @RequestMapping("/memberLogin")
	public boolean login(String user_email, String user_pw) {
		//입력한 이메일과 비밀번호가 일치하는지 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_email", user_email);
		map.put("user_pw", user_pw);
		
		return false;
	}

}
