package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.FrigeViewDTO;
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
	
	@RequestMapping(value = "/irdntListType", method = { RequestMethod.GET, RequestMethod.POST })
	public String irdntListType(Long user_id, String content_ty, Model model) {
		FrigeViewDTO dto = new FrigeViewDTO();
		dto.setUser_id(user_id);
		dto.setContent_ty(content_ty);
		//System.out.println("ID : " + dto.getUser_id() + " Type : " + dto.getContent_ty());
		
		model.addAttribute("irdntListType", service.irdntListType(dto));
		
		return "irdntListType";
	}
	
	@RequestMapping(value = "/irdntListDate", method = { RequestMethod.GET, RequestMethod.POST })
	public String irdntListDate(Long user_id, Model model) {
		model.addAttribute("irdntListDate", service.irdntListDate(user_id));
		//System.out.println("Date : " + user_id);
		
		return "irdntListDate";
	}
	
	@RequestMapping(value = "/irdntListName", method = { RequestMethod.GET, RequestMethod.POST })
	public String irdntListName(Long user_id, Model model) {
		model.addAttribute("irdntListName", service.irdntListName(user_id));
		//System.out.println("Name : " + user_id);
		
		return "irdntListName";
	}
	
}
