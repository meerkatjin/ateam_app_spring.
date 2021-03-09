package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.BoardCommentVO;
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
	
	//답글저장처리 요청
	@RequestMapping("/reply_insert.qa")
	public String reply_insert(BoardVO vo, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("loginInfo");
		vo.setUser_id( user.getUser_id() );
		service.qna_reply_insert(vo);
		return "redirect:list.qa";
	}
	
	//답글쓰기 화면 요청
	@RequestMapping("/reply.qa")
	public String reply(int board_no, Model model) {
		model.addAttribute("vo", service.qna_view(board_no));
		return "qna/reply";
	}
	
	//질문글 삭제처리 요청
	@RequestMapping("/delete.qa")
	public String delete(int board_no) {
		service.qna_delete(board_no);
		return "redirect:list.qa";
	}
	
	//질문글 수정처리 요청
	@RequestMapping("/update.qa")
	public String update(BoardVO vo) {
		service.qna_update(vo);
		return "redirect:list.qa?board_no=" + vo.getBoard_no();
	}
	
	//질문글 수정화면 요청
	@RequestMapping("/modify.qa")
	public String modify(Model model, int board_no) {
		model.addAttribute("vo", service.qna_view(board_no));
		return "qna/modify";
	}
	
	
	//질문글 상세화면 보기
	@RequestMapping("/view.qa")
	public String view(Model model, int board_no) {
		service.qna_read(board_no);
		
		model.addAttribute("vo", service.qna_view(board_no));
		model.addAttribute("page", page);
		return "qna/view";
	}
	
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
		page.setCurPage(curPage);
		model.addAttribute("page", service.qna_list(page));
		return "qna/list";
	}
	
}
