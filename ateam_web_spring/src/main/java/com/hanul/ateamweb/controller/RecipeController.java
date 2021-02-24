package com.hanul.ateamweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import recipe.RecipeIrdntVO;
import recipe.RecipePage;
import recipe.RecipeServiceImpl;

@Controller
public class RecipeController{
	@Autowired private RecipeServiceImpl service;
	@Autowired private RecipePage page;
	
	@RequestMapping("/view.rp")
	public String view(HttpSession session, int recipe_id, Model model) {
		session.setAttribute("category", "rp");
		int mainIrdnt = 0, subIrdnt = 0, sauce = 0;
		List<RecipeIrdntVO> irdntVO = service.recipe_irdnt_get(recipe_id);
		for (RecipeIrdntVO vo : irdntVO) {
			if(vo.getIrdnt_ty_nm().equals("주재료")) mainIrdnt++;
			else if(vo.getIrdnt_ty_nm().equals("부재료")) subIrdnt++;
			else if(vo.getIrdnt_ty_nm().equals("양념")) sauce++;
		}
		
		model.addAttribute("irdnt", irdntVO);
		model.addAttribute("mainIrdnt", mainIrdnt);
		model.addAttribute("subIrdnt", subIrdnt);
		model.addAttribute("sauce", sauce);
		model.addAttribute("info",service.recipe_select(recipe_id));
		model.addAttribute("ing", service.recipe_view(recipe_id));
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
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
		model.addAttribute("recommend", service.recommend_list());
		model.addAttribute("page", service.recipe_list(page));
		return "recipe/list";
	}
}
