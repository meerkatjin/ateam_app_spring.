package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import recipe.service.RecipeIngService;
@Controller
public class RecipeIngController {
	@Autowired
    private RecipeIngService service;

    @RequestMapping(value = "/recipeIng", method = { RequestMethod.GET, RequestMethod.POST })
    public String recipeIng( int recipe_id  ,Model model) {
         
    	model.addAttribute("recipeIng", service.recipeIng(recipe_id));    //1. 일단 app으로 json 타입으로 리턴할것들은 전부 jsonReturn으로 통일했습니다
        return "recipeIng";
    }
        
        
    @RequestMapping(value = "/recipeIrdnt", method = { RequestMethod.GET, RequestMethod.POST })
    public String recipeIngIrdnt(int recipe_id, Model model) {
    	model.addAttribute("recipeIrdnt", service.recipeIrdnt(recipe_id));
    	return "recipe/recipeIrdnt";
    }
}