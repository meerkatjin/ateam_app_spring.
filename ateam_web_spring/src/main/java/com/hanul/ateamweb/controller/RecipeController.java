package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

	@RequestMapping("/list.rp")
	public String list(HttpSession session) {
		session.setAttribute("category", "rp");
		return "recipe/list";
	}
}
