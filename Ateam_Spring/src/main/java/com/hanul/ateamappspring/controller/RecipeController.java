package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import recipe.service.RecipeInfoService;

@Controller
public class RecipeController {
	@Autowired
	private RecipeInfoService service;

	@RequestMapping(value = "/recipeInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public String recipeInfo(Model model) {
		model.addAttribute("recipeInfo", service.recipeInfo());	//1. 일단 app으로 json 타입으로 리턴할것들은 전부 jsonReturn으로 통일했습니다

		//2. jsonReturn.jsp로 넘깁니다. 여기서 전부 json으로 바꿔 가져온다고 보시면 됩니다. ->RecipeInfoService로
		return "recipe/recipeInfo";
	}
	
	@RequestMapping(value = "/recipeInfoMf", method = { RequestMethod.GET, RequestMethod.POST })
	public String recipeInfoMf(Model model) {
		 int recipe_id = 1;
		model.addAttribute("recipeInfoMf", service.recipeInfoMf(recipe_id));	//1. 일단 app으로 json 타입으로 리턴할것들은 전부 jsonReturn으로 통일했습니다
		System.out.println("확인용 : ");
		//2. jsonReturn.jsp로 넘깁니다. 여기서 전부 json으로 바꿔 가져온다고 보시면 됩니다. ->RecipeInfoService로
		return "recipe/recipeInfoMf";
	}
	

}
