package com.hanul.ateamweb.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class MemberController {
	@Autowired private MemberServiceImpl service;
	private String kakao_client_key;
	private String naver_client_key;
	
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
	public boolean login(String user_email, String user_pw, HttpSession session) {
		//입력한 이메일과 비밀번호가 일치하는 회원정보 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_email", user_email);
		map.put("user_pw", user_pw);
		MemberVO vo = service.member_login(map);
		//로그인한 회원정보를 세션에 저장
		session.setAttribute("loginInfo", vo);

		return vo == null ? false : true;
	}
	
	//이메일 중복 확인
	@ResponseBody @RequestMapping("/email_check")
	public boolean email_check(String user_email) {
		return service.member_email_check(user_email);
	}
	
	//회원가입처리 요청
	@ResponseBody @RequestMapping(value="/join", produces="text/html; charset=utf-8")
	public String join(MemberVO vo, HttpSession session, HttpServletRequest request) { 
		//화면에서 입력한 회원정보를 DB에 저장한 후 홈으로 연결 
		StringBuffer msg = new StringBuffer("<script>"); 
		if (service.member_join(vo)) { 
			msg.append("alert('회원가입을 축하합니다 ^^'); location='" 
			+ request.getContextPath() + "'; "); 
		} else {
			msg.append("alert('회원가입 실패 ㅠㅠ'); history.go(-1)"); 
		}
		msg.append("</script>");
	 
	 	return msg.toString(); 
	}
	
	//카카오 아이디로 로그인 요청
	@RequestMapping("/kakaoLogin")
	public String kakaoLogin() {
		return "";
	}
	

	//로그아웃 처리 요청
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginInfo");
		return "redirect:/";
	}

}
