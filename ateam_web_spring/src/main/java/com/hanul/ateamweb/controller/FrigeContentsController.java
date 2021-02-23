package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.CommonService;
import frige.FrigeServiceImpl;

@Controller
public class FrigeContentsController {
	@Autowired private FrigeServiceImpl service;
	@Autowired private CommonService common;
	
	@RequestMapping("/view.fc")
	public String frigeView(HttpSession session, Model model, String search, String keyword) {
		session.setAttribute("category", "fc");
		
		return "frige/view";
	}
}
