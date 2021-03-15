package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;
import frige.FrigeServiceImpl;
import frige.FrigeVO;
import member.MemberVO;

@Controller
public class FrigeContentsController {
	@Autowired private FrigeServiceImpl service;
	
	//냉장고 페이지 요청
	@RequestMapping("/view.fc")
	public String frigeView(HttpSession session, Model model, String keyword) {
		session.setAttribute("category", "fc");
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		if (member == null) {
			model.addAttribute("message", "로그인이 필요한 서비스입니다!");
			model.addAttribute("returnPath", "login");
			
			return "redirect";
		}
		long user_id = member.getUser_id();
		
		model.addAttribute("list", service.frige_list(user_id));
		
		return "frige/view";
	}
	
	//재료 상세 및 수정페이지 요청
	@RequestMapping("/detail.fc")
	public String frigeDetail(HttpSession session, @RequestParam(defaultValue="0") int content_list_id, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		if (member == null) {
			model.addAttribute("message", "로그인이 필요한 서비스입니다!");
			model.addAttribute("returnPath", "login");
			
			return "redirect";
		}
		long user_id = member.getUser_id();
		model.addAttribute("list", service.frige_list(user_id));
		model.addAttribute("detail", service.frige_detail(content_list_id));
		return "frige/view";
	}
	
	//재료 정보 수정요청
	@RequestMapping("/modify.fc")
	public String frigeModify(FrigeVO vo) {
		System.out.println(vo.getContent_list_id());
		System.out.println(vo.getContent_nm());
		System.out.println(vo.getShelf_life_end());
		service.frige_update(vo);
		
		return "redirect:view.fc";
	}
	
	//재료 삭제요청
	@RequestMapping("/delete.fc")
	public String frigeDelete(int content_list_id) {
		service.frige_delete(content_list_id);
		
		return "redirect:view.fc";
	}
}
