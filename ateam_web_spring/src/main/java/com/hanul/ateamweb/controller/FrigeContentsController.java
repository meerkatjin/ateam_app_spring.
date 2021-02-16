package com.hanul.ateamweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrigeContentsController {
	
	@RequestMapping("/view.fc")
	public String FrigeView() {
		return "frige/view";
	}
}
