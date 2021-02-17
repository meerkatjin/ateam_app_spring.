package com.hanul.ateamweb.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(HttpSession session) {
		session.removeAttribute("category");
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
