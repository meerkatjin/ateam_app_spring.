package com.hanul.ateamappspring.controller;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import recipe.service.RecipeInfoService;
import recipeinfo.dto.RecipeInfoDTO;
import user.service.AppUserService;

public class RecipeController {
	@Autowired
	private RecipeInfoService service;

	@RequestMapping(value = "/recipeInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public String recipeInfo(Model model, RecipeInfoDTO dto) {

		model.addAttribute("recipeInfo", service.recipeInfo(dto));

		return "appJoin";
	}

}
