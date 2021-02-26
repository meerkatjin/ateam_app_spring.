package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;
import frige.FrigeServiceImpl;
import member.MemberVO;

@Controller
public class FrigeContentsController {
	@Autowired private FrigeServiceImpl service;
	@Autowired private CommonService common;
	
	//냉장고 페이지 요청
	@RequestMapping("/view.fc")
	public String frigeView(HttpSession session, Model model, String keyword, String filter, String type) {
		session.setAttribute("category", "fc");
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		if (member == null) {
			return "member/login";
		}
		long user_id = member.getUser_id();
		
		model.addAttribute("list", service.frige_list(user_id));
		
		return "frige/view";
	}
	
	@ResponseBody @RequestMapping(value="/frige/date", produces="application/json; charset=utf-8")
	public Object frige_date() {
		return "";
	}
}
