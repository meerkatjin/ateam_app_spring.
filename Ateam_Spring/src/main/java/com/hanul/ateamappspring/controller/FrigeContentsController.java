package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.service.FrigeContentsService;

@Controller
public class FrigeContentsController {
	@Autowired FrigeContentsService service;
	
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String insert(String content_nm , Model model ) {
		model.addAttribute("insert", content_nm );
		service.irdntInsert(content_nm );
	//	System.out.println(name);
		return "insert";
	}
	
	@RequestMapping(value = "/sortType", method = { RequestMethod.GET, RequestMethod.POST })
	public String type(Model model, FrigeContentsDTO dto) {
		model.addAttribute("sortType");
		
		return "sortType";
	}
	
	
	@RequestMapping(value = "/sortDate", method = { RequestMethod.GET, RequestMethod.POST })
	public String date(Model model, FrigeContentsDTO dto) {
		model.addAttribute("sortDate");
		
		return "sortDate";
	}
	
	@RequestMapping(value = "/sortName", method = { RequestMethod.GET, RequestMethod.POST })
	public String name(Model model, FrigeContentsDTO dto) {
		model.addAttribute("sortName");
		
		return "sortName";
	}
	
	
}
