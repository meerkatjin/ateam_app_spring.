package com.hanul.ateamweb.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("keyword", keyword);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", service.frige_list(map));
		
		List<Integer> end_content = service.getLifeEndList(user_id);
		List<Integer> new_content = service.getNewContentList(user_id);
		//확인해야할 재료 개수를 세션에 저장
		session.setAttribute("getLifeEndList", end_content);
		session.setAttribute("getNewContentList", new_content);
				
		return "frige/view";
	}
	
	//재료 상세 및 수정페이지 요청
	@RequestMapping("/detail.fc")
	public String frigeDetail(HttpSession session, @RequestParam(defaultValue="0") int content_list_id, String keyword, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		if (member == null) {
			model.addAttribute("message", "로그인이 필요한 서비스입니다!");
			model.addAttribute("returnPath", "login");
			
			return "redirect";
		}
		long user_id = member.getUser_id();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("keyword", keyword);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", service.frige_list(map));
		model.addAttribute("detail", service.frige_detail(content_list_id));
		return "frige/view";
	}
	
	//재료 정보 수정요청
	@RequestMapping("/modify.fc")
	public String frigeModify(FrigeVO vo) {
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
