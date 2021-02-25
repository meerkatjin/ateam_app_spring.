package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import member.MemberVO;
import common.BoardVO;
import common.CommonService;
import notice.NoticePage;
import notice.NoticeServiceImpl;

@Controller
public class NoticeController {
	@Autowired private NoticeServiceImpl service;
	@Autowired private NoticePage page;
	@Autowired private CommonService common;
	
	//공지글 삭제처리 요청
	@RequestMapping("/delete.no")
	public String delete(int board_no) {
		service.notice_delete(board_no);
		return "redirect:list.no";
	}
	
	//공지글 수정처리 요청
	@RequestMapping("/update.no")
	public String update(BoardVO vo) {
		service.notice_update(vo);
		return "redirect:list.no?board_no=" + vo.getBoard_no();
	}
	
	//공지글 수정화면 요청
	@RequestMapping("/modify.no")
	public String modify(Model model, int board_no) {
		model.addAttribute("vo", service.notice_view(board_no));
		return "notice/modify";
	}
	
	//공지글 상세보기
	@RequestMapping("/view.no")
	public String view(Model model, int board_no) {
		
		model.addAttribute("vo", service.notice_view(board_no));
		model.addAttribute("page", page);
		return "notice/view";
	}
	
	//공지글쓰기처리 요청
	@RequestMapping("/insert.no")
	public String insert(BoardVO vo, HttpSession session, MultipartFile file) {
		
		if( ! file.isEmpty() ) {
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload(session, file, "notice") );
		}
		
		service.notice_insert(vo);
		return "redirect:list.no";
	}
	
	//공지사항 글신규화면 요청
	@RequestMapping("/new.no")
	public String noticeNew() {
		return "notice/new";
	}

	//공지사항 화면 요청
	@RequestMapping("/list.no")
	public String noticeView(HttpSession session, Model model, @RequestParam(defaultValue = "1") int curPage, String search, String keyword) {
		session.setAttribute("category", "cu");
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		model.addAttribute("page", service.notice_list(page));
		return "notice/list";
	}
}
