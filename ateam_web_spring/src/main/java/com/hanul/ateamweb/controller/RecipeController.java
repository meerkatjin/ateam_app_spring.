package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.PageVO;
import recipe.RecipePage;
import recipe.RecipeServiceImpl;

@Controller
public class RecipeController {
	@Autowired private RecipeServiceImpl service;
	@Autowired private RecipePage page;
	
	@RequestMapping("/view.rp")
	public String view(int id, Model model) {
		model.addAttribute("vo", service.recipe_view(id));
		return "recipe/view";
	}

	@RequestMapping("/list.rp")
	public String list(HttpSession session, Model model
					, String search, String keyword
					, @RequestParam(defaultValue="10") int pageList
					, @RequestParam(defaultValue="1") int curPage) {
		session.setAttribute("category", "rp");
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		page.setPageList(pageList);
		model.addAttribute("page", service.recipe_list(page));
		return "recipe/list";
	}
}
