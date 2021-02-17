package com.hanul.ateamweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

	@RequestMapping("/list.rp")
	public String list() {
		
		return "recipe/list";
	}
}
