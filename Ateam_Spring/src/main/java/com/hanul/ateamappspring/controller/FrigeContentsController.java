package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.InsertDTO;
import frigecontents.service.FrigeContentsService;

@Controller
public class FrigeContentsController {
	@Autowired FrigeContentsService service;
	
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String insert(String content_nm, Long user_id, Model model) {
		model.addAttribute("insert", content_nm);
		model.addAttribute("user_id", user_id);
		InsertDTO dto = new InsertDTO();
		dto.setContent_nm(content_nm);
		dto.setUser_id(user_id);
		//System.out.println(dto.getContent_nm());
		//System.out.println(dto.getUser_id());
		service.irdntInsert(dto);
		return "insert";
	}
	
	@RequestMapping(value = "/irdntList", method = { RequestMethod.GET, RequestMethod.POST })
	public String irdntList(Long user_id, Model model) {
		model.addAttribute("irdntList", service.irdntList(user_id));
		
		return "irdntList";
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
