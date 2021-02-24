package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.BoardVO;
import common.CommonService;
import member.MemberVO;
import notice.NoticePage;
import qna.QnaServiceImpl;

@Controller
public class QnaController {
	@Autowired private QnaServiceImpl service;
	@Autowired private NoticePage page;
	@Autowired private CommonService common;
	
	//질문글 쓰기처리 요청
	@RequestMapping("/insert.qa")
	public String insert(BoardVO vo, HttpSession session, MultipartFile file) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		vo.setUser_id( member.getUser_id() );
		
		if( ! file.isEmpty() ) {
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload(session, file, "notice") );
		}
		
		service.qna_insert(vo);
		return "redirect:list.qa";
	}
	
	//질문글쓰기 화면 요청
	@RequestMapping("/new.qa")
	public String qnaView() {
		return "qna/new";
	}

	//질문게시판 화면요청
	@RequestMapping("/list.qa")
	public String qna(HttpSession session, Model model, @RequestParam(defaultValue = "1") int curPage) {
		session.setAttribute("category", "cu");
		
		page.setCurPage(curPage);
		model.addAttribute("page", service.qna_list(page));
		return "qna/list";
	}
	
}
