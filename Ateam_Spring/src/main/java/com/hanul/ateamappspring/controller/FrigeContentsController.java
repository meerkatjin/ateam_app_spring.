package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.FrigeDeleteDTO;
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
		return "frige/insert";
	}
	
	@RequestMapping(value = "/irdntListType", method = { RequestMethod.GET, RequestMethod.POST })
	public String irdntListType(Long user_id, String content_ty, Model model) {
		FrigeViewDTO dto = new FrigeViewDTO();
		dto.setUser_id(user_id);
		dto.setContent_ty(content_ty);
		//System.out.println("ID : " + dto.getUser_id() + " Type : " + dto.getContent_ty());
		
		model.addAttribute("irdntListType", service.irdntListType(dto));
		
		return "frige/irdntListType";
	}
	
	@RequestMapping(value = "/irdntListDate", method = { RequestMethod.GET, RequestMethod.POST })
	public String irdntListDate(Long user_id, Model model) {
		model.addAttribute("irdntListDate", service.irdntListDate(user_id));
		//System.out.println("Date : " + user_id);
		
		return "frige/irdntListDate";
	}
	
	@RequestMapping(value = "/irdntListName", method = { RequestMethod.GET, RequestMethod.POST })
	public String irdntListName(Long user_id, Model model) {
		model.addAttribute("irdntListName", service.irdntListName(user_id));
		//System.out.println("Name : " + user_id);
		
		return "frige/irdntListName";
	}
	
	@RequestMapping(value = "/irdntListDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public String irdntListDelete(Long user_id, int content_list_id, Model model) {
		model.addAttribute("user_id", user_id);
		model.addAttribute("content_list_id", content_list_id);
		FrigeDeleteDTO dto = new FrigeDeleteDTO();
		dto.setUser_id(user_id);
		dto.setContent_list_id(content_list_id);
		
		service.irdntListDelete(dto);
		
		return "frige/irdntListDelete";
	}
	
	//유통기한 임박한 내용물 갯수 가져오기
	@RequestMapping("/getLifeEndNum")
	public String getLifeEndNum(Model model, long user_id) {
		System.out.println(service.getLifeEndNum(user_id));
		model.addAttribute("getLifeEndNum",String.valueOf(service.getLifeEndNum(user_id)));
		return "frige/getLifeEndNum";
	}
	
}
