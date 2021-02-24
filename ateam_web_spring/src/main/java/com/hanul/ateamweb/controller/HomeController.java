package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import recipe.RecipeServiceImpl;

@Controller
public class HomeController {
	@Autowired private RecipeServiceImpl recipe;
	
	@RequestMapping("/")
	public String home(HttpSession session, Model model) {
		session.removeAttribute("category");
		model.addAttribute("recommend", recipe.recommend_list());
		return "main";
	}
	
	@RequestMapping("/intro.it")
	public String intro(HttpSession session) {
		session.setAttribute("category", "it");
		return "intro";
	}
	
	@RequestMapping("/product.pd")
	public String product() {
		return "product/product";
	}
}
