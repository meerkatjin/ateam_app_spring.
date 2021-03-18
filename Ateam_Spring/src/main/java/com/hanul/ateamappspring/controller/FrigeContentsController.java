package com.hanul.ateamappspring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.ibatis.type.TypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frigecontents.dto.FrigeConfrimVO;
import frigecontents.dto.FrigeContentsDTO;
import frigecontents.dto.FrigeDeleteDTO;
import frigecontents.dto.FrigeViewDTO;
import frigecontents.service.FrigeContentsService;

@Controller
public class FrigeContentsController {
	@Autowired private FrigeContentsService service;
	
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String insert(FrigeContentsDTO dto, Model model) {
		model.addAttribute("insert", String.valueOf(service.irdntInsert(dto)));
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
		model.addAttribute("getNum",String.valueOf(service.getLifeEndNum(user_id)));
		return "frige/getNum";
	}
	
	//유통기한이 임박한 내용물 아이디 리스트 가져오기
	@RequestMapping("/getLifeEndList")
	public String getLifeEndList(Model model, long user_id) {
		model.addAttribute("getIDList", service.getLifeEndList(user_id));
		return "frige/getIDList";
	}
	
	//새로 등록된 내용물 갯수 가져오기
	@RequestMapping("/getNewContentNum")
	public String getNewContentNum(Model model, long user_id) {
		model.addAttribute("getNum", String.valueOf(service.getNewContentNum(user_id)));
		return "frige/getNum";
	}
	
	//새로 등록된 내용물 아이디 리스트 가져오기
	@RequestMapping("/getNewContentList")
	public String getNewContentList(Model model, long user_id) {
		model.addAttribute("getIDList", service.getNewContentList(user_id));
		return "frige/getIDList";
	}
	
	//새로 등록된 내용물을 확인했을때
	@RequestMapping("/irdntConfirm")
	public String irdntConfirm(Model model, FrigeContentsDTO dto) {
		FrigeConfrimVO vo = new FrigeConfrimVO();
		vo.setContent_list_id(dto.getContent_list_id());
		vo.setContent_nm(dto.getContent_nm());
		vo.setContent_ty(dto.getContent_ty());
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				vo.setShelf_life_start(transFormat.parse(dto.getShelf_life_start()));				
			} catch (TypeException e) {
				vo.setShelf_life_start(null);
			} catch (ParseException e) {
				vo.setShelf_life_start(null);
			}
			
			try {
				vo.setShelf_life_end(transFormat.parse(dto.getShelf_life_end()));				
			} catch (TypeException e) {
				vo.setShelf_life_end(null);
			} catch (ParseException e) {
				vo.setShelf_life_start(null);
			}
		model.addAttribute("requestSuccess", String.valueOf(service.irdntConfirm(vo)));
		return "requestSuccess";
	}
}
