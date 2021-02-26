package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import board.BoardServiceImpl;
import notice.NoticeServiceImpl;
import qna.QnaServiceImpl;
import recipe.RecipeServiceImpl;

@Controller
public class HomeController {
	@Autowired private RecipeServiceImpl recipe;
	@Autowired private NoticeServiceImpl notice;
	@Autowired private QnaServiceImpl qna;
	@Autowired private BoardServiceImpl board;
	
	@RequestMapping("/")
	public String home(HttpSession session, Model model) {
		session.removeAttribute("category");
		model.addAttribute("board", board.gethome());
		model.addAttribute("qna", qna.gethome());
		model.addAttribute("notice", notice.gethome());
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
