package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommunityController {
	
	//커뮤니티 게시판 이동
	@RequestMapping("/commu.cu")
	public String commu(HttpSession session) {
		session.setAttribute("category", "cu");
		return "community/commu";
	}
	
	
}
