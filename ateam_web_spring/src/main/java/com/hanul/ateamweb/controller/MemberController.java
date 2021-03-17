package com.hanul.ateamweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.mail.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;
import frige.FrigeServiceImpl;
import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class MemberController {
	@Autowired private MemberServiceImpl service;
	@Autowired private FrigeServiceImpl frige;
	@Autowired private CommonService common;
	private String kakao_client_key = "023c7753cf994a68fb4bfd14b7c1b4db";
	private String google_client_key = "AIzaSyC7fhf9A1XZUpdS3EYBkB6UP8PkMqBBlig";
	
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
	
	//회원정보수정화면 요청 처리
	@RequestMapping("/modify.me")
	public String modify(HttpSession session, Model model) {
		session.removeAttribute("category");
		return "member/modify";
	}
	
	//회원가입처리 요청
	@ResponseBody @RequestMapping(value="/joinRequest", produces="text/html; charset=utf-8")
	public String join(MemberVO vo, HttpSession session, HttpServletRequest request) { 
		//session 은 이메일 보낼때 필요 구현은 나중에..
		
		//화면에서 입력한 회원정보를 DB에 저장한 후 홈으로 연결 
		StringBuffer msg = new StringBuffer("<script>"); 
		if (service.member_join(vo)) { 
			msg.append("alert('속보이는 냉장고 회원가입이 완료되었습니다!'); location='" 
			+ request.getContextPath() + "'; "); 
		} else {
			msg.append("alert('회원가입을 실패했습니다.'); history.go(-1)"); 
		}
		msg.append("</script>");
	 
	 	return msg.toString(); 
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
	
	//테스트 로그인
	@RequestMapping(value = "/appNomalLogin")
	public String appNomalLogin(Model model, String user_email, String user_pw, HttpSession session) {
		//입력한 이메일과 비밀번호가 일치하는 회원정보 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_email", user_email);
		map.put("user_pw", user_pw);
		MemberVO vo = service.member_login(map);
		//로그인한 회원정보를 세션에 저장
		session.setAttribute("loginInfo", vo);
		return "redirect:list.no";
	}
	
	@RequestMapping(value = "/appKakaoLogin")
	public String appKakaoLogin(Model model, long user_id, String user_type, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("user_type", user_type);
		MemberVO vo = service.member_login(map);
		//로그인한 회원정보를 세션에 저장
		session.setAttribute("loginInfo", vo);
		return "redirect:list.no";
	}
	
	//이메일 중복 확인
	@ResponseBody @RequestMapping("/email_check")
	public boolean email_check(String user_email) {
		return service.member_email_check(user_email);
	}
	
	//카카오 아이디로 로그인 요청
	@RequestMapping("/kakaoLogin")
	public String kakaoLogin(HttpSession session) {
		// https://kauth.kakao.com/oauth/authorize?client_id={REST_API_KEY}
				//&redirect_uri={REDIRECT_URI}
				//&response_type=code
		
		String state = UUID.randomUUID().toString();
		session.setAttribute("state", state);
		
		StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/authorize?response_type=code");
		url.append("&client_id=").append(kakao_client_key);
		url.append("&state=").append(state);
		url.append("&redirect_uri=").append("http://localhost/ateamweb/kakaocallback");
		//시연용 접속시
		//url.append("&redirect_uri=").append("http://112.164.58.217:8999/ateamweb/kakaocallback");
		
		return "redirect:" + url.toString();
	}
	
	//카카오 아이디로 로그인 처리
	@RequestMapping("/kakaocallback")
	public String kakaocallback(HttpSession session, String state
								, String code, String error) {
		if( !state.equals( (String)session.getAttribute("state") ) 
				|| error!=null )
			return "redirect:/";
		
		//토큰 발급받기
		StringBuffer url = new StringBuffer(
			"https://kauth.kakao.com/oauth/token?grant_type=authorization_code");
		url.append("&client_id=").append(kakao_client_key);
//		url.append("&client_secret=").append("K1N91CKhB2");
		url.append("&code=").append(code);
		url.append("&state=").append(state);
	
		JSONObject json = new JSONObject( common.requestAPI(url) );
		String token_type = json.getString("token_type");
		String access_token = json.getString("access_token");
		
//		curl -v -X POST "https://kauth.kakao.com/oauth/token" \
//		 -d "grant_type=authorization_code" \
//		 -d "client_id={REST_API_KEY}" \
//		 -d "redirect_uri={REDIRECT_URI}" \
//		 -d "code={AUTHORIZATION_CODE}
	
//		curl -v -X GET "https://kapi.kakao.com/v2/user/me" \
//		  -H "Authorization: Bearer {ACCESS_TOKEN}"
		
		//사용자정보 가져오기
		url = new StringBuffer("https://kapi.kakao.com/v2/user/me");
		json = new JSONObject(
				common.requestAPI(url, token_type+" "+access_token) );
		if( !json.isEmpty() ) {
			MemberVO vo = new MemberVO();
			vo.setUser_type("kakao");
			vo.setUser_id( json.getLong("id") );
			
			json = json.getJSONObject("kakao_account");
			vo.setUser_email(json.getString("email"));
		
			json = json.getJSONObject("profile");
			vo.setUser_nm( json.getString("nickname") );
			//카카오 로그인 정보가 DB에 있으면 update, 없으면 insert
			
			if( service.member_social_id(vo) ) { //id가 있으면 update
				service.member_social_update(vo);
			} else { //id가 없으면 insert
				service.member_social_join(vo);
			}
			session.setAttribute("loginInfo", vo);
		}
		return "redirect:/";
	}
	
	//구글 아이디로 로그인 요청
	@RequestMapping("/googleLogin")
	public String googleLogin(HttpSession session) {
		String state = UUID.randomUUID().toString();
		session.setAttribute("state", state);
		
		StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/authorize?response_type=code");
		url.append("&client_id=").append(kakao_client_key);
		url.append("&state=").append(state);
		url.append("&redirect_uri=").append("http://localhost/ateamweb/kakaocallback");
		//시연용 접속시
		//url.append("&redirect_uri=").append("http://112.164.58.217:8999/ateamweb/kakaocallback");
		
		return "redirect:" + url.toString();
	}
	

	//로그아웃 처리 요청
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginInfo");
		return "redirect:/";
	}
	
	//메인화면 이동 처리
	@RequestMapping("/main")
	public String main() {
		return "redirect:/";
	}
	
	//회원정보수정 처리 요청
	@RequestMapping("/modifyRequest")
	public String modifyRequest(MemberVO vo, Model model) {
		int succ = service.member_update(vo);
		if (succ > 0) {
			model.addAttribute("message", "정상적으로 수정되었습니다.");
		} else {
			model.addAttribute("message", "오류가 발생하여 수정되지 않았습니다.");
		}
		model.addAttribute("returnPath", "main");
		
		return "redirect";
	}
	
	//회원탈퇴 처리 요청
	@RequestMapping("/withdrawal")
	public String withdrawal(long user_id, Model model) {
		int succ = service.member_delete(user_id);
		if (succ > 0) {
			model.addAttribute("message", "정상적으로 회원탈퇴되었습니다. 이용해주셔서 감사합니다.");
		} else {
			model.addAttribute("message", "오류가 발생하여 탈퇴되지 않았습니다.");
		}
		model.addAttribute("returnPath", "logout");
		
		return "redirect";
	}

}
