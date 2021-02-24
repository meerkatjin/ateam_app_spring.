package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QnaController {

	//자주하는질문 게시판 화면요청
	@RequestMapping("/list.qa")
	public String qna(HttpSession session) {
		session.setAttribute("category", "cu");
		return "qna/list";
	}
	
}
