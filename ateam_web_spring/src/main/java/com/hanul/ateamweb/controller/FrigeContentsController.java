package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.CommonService;
import frige.FrigeServiceImpl;
import member.MemberVO;

@Controller
public class FrigeContentsController {
	@Autowired private FrigeServiceImpl service;
	@Autowired private CommonService common;
	
	//냉장고 페이지 요청
	@RequestMapping("/view.fc")
	public String frigeView(HttpSession session, Model model, String search, String keyword) {
		session.setAttribute("category", "fc");
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		int user_id = member.getUser_id();
		
		model.addAttribute("list", service.frige_list(user_id));
		return "frige/view";
	}
}
