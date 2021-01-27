package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import search.service.SearchService;

public class SearchController {
	@Autowired SearchService service;
	
	@RequestMapping(value = "/searchIrdnt", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchIrdnt(String searchText, Long user_id, Model model) {
		return "searchIrdnt";
	}
	
	@RequestMapping(value = "/searchRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchRecipe(String searchText, Model model) {
		return "searchRecipe";
	}
}
