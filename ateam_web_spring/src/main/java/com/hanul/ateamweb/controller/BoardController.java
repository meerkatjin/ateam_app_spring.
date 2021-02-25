package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import board.BoardServiceImpl;
import common.BoardVO;
import common.CommonService;
import member.MemberVO;
import notice.NoticePage;

@Controller
public class BoardController {
	
	@Autowired private BoardServiceImpl service;
	@Autowired private NoticePage page;
	@Autowired private CommonService common;
	
	//게시판글 삭제처리
	@RequestMapping("/delete.bo")
	public String delete(int board_no) {
		service.board_delete(board_no);
		return "redirect:list.bo";
	}
	
	//게시판글 수정처리
	@RequestMapping("/update.bo")
	public String update(BoardVO vo) {
		service.board_update(vo);
		return "redirect:list.bo";
	}
	
	//게시판글 수정화면 요청
	@RequestMapping("/modify.bo")
	public String modify(Model model, int board_no) {
		model.addAttribute("vo", service.board_view(board_no));
		return "board/modify";
	}
	
	//게시판글 상세화면 보기
	@RequestMapping("/view.bo")
	public String view(Model model, int board_no) {
		service.board_read(board_no);
		
		model.addAttribute("vo", service.board_view(board_no));
		model.addAttribute("page", page);
		return "board/view";
	}
	
	//게시판 글쓰기처리 요청
	@RequestMapping("/insert.bo")
	public String insert(HttpSession session, MultipartFile file, BoardVO vo) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		vo.setUser_id( member.getUser_id() );
		
		if( ! file.isEmpty() ) {
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload(session, file, "notice") );
		}
		service.board_insert(vo);
		return "redirect:list.bo";
	}
	
	//게시판 글쓰기 화면 요청
	@RequestMapping("/new.bo")
	public String boardView() {
		return "board/new";
	}

	//게시판화면 요청
	@RequestMapping("/list.bo")
	public String board(HttpSession session, Model model, @RequestParam(defaultValue = "1") int curPage) {
		page.setCurPage(curPage);
		model.addAttribute("page", service.board_list(page));

		return "board/list";
	}
}
