package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {

	@RequestMapping("/list.no")
	public String noticeView(HttpSession session) {
		session.setAttribute("category", "cu");
		return "notice/list";
	}
}
