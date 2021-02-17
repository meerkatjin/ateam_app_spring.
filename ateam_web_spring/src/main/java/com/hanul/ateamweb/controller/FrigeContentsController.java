package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrigeContentsController {
	
	@RequestMapping("/view.fc")
	public String frigeView(HttpSession session) {
		session.setAttribute("category", "fc");
		return "frige/view";
	}
}
