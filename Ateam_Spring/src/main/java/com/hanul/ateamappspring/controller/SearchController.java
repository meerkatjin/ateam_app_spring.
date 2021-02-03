package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import search.dto.SearchDTO;
import search.service.SearchService;

@Controller
public class SearchController {
	@Autowired SearchService service;
	
	@RequestMapping(value = "/searchIrdnt", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchIrdnt(String searchText, Long user_id, Model model) {
		SearchDTO dto = new SearchDTO();
		dto.setSearchText("%" + searchText + "%");
		dto.setUser_id(user_id);
		//System.out.println("Controller : " + dto.getSearchText());
		//System.out.println("Controller : " + dto.getUser_id());
	
		model.addAttribute("searchIrdnt", service.searchIrdnt(dto));
		
		return "search/searchIrdnt";
	}
	
	@RequestMapping(value = "/searchRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchRecipe(String searchText, Model model) {
		System.out.println("Controller : " + searchText);
		searchText = "%" + searchText + "%";
		model.addAttribute("searchRecipe", service.searchRecipe(searchText));
		
		return "search/searchRecipe";
	}
}
