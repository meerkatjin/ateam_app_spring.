package com.hanul.ateamweb.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.BoardVO;
import common.CommonService;
import member.MemberVO;
import notice.NoticePage;
import notice.NoticeServiceImpl;

@Controller
public class NoticeController {
	@Autowired private NoticeServiceImpl service;
	@Autowired private NoticePage page;
	@Autowired private CommonService common;
	
	//첨부파일 다운로드 요청
	@ResponseBody @RequestMapping("/download.no")
	public void download(int board_no, HttpSession session, HttpServletResponse response) {
		BoardVO vo = service.notice_view(board_no);
		common.fileDownload( vo.getFilename(), vo.getFilepath(), session, response );
	}
	
	//공지글 삭제처리 요청
	@RequestMapping("/delete.no")
	public String delete(int board_no, HttpSession session, Model model) {
		BoardVO vo = service.notice_view(board_no);
		if( vo.getFilename()!=null  ) {
			File file = new File( "D:\\ateam_app_springs\\ateam_web_spring\\resources" + "/" + vo.getFilepath() );
			if( file.exists() ) file.delete();
		}
		service.notice_delete(board_no);
		return "redirect:list.no";
	}
	
	//공지글 수정처리 요청
	@RequestMapping("/update.no")
	public String update(BoardVO vo, String filename, HttpSession session, MultipartFile file) {
		BoardVO board = service.notice_view( vo.getBoard_no() );
		String uuid = "D:\\ateam_app_springs\\ateam_web_spring\\resources" + "/" + board.getFilepath();
		//첨부파일 관련처리
		if( ! file.isEmpty() ) { //첨부파일 있는 경우
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload(session, file, "board") );
			
			//원래 첨부된 파일이 있었다면 서버에서 삭제
			if( board.getFilename() != null ) {
				File f = new File( uuid );
				if( f.exists() ) f.delete();
			}
		}else {
			//원래 첨부된 파일을 삭제/ 원래부터 첨부파일이 없는 경우
			if( filename.isEmpty() ) {
				if( board.getFilename() != null ) {
					File f = new File( uuid );
					if( f.exists() ) f.delete();
				}
				
			}else {
				//원래 첨부된 파일을 그대로 사용하는 경우
				vo.setFilename( board.getFilename() );
				vo.setFilepath( board.getFilepath() );
			}
		}
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
		service.notice_read(board_no);
		
		model.addAttribute("vo", service.notice_view(board_no));
		model.addAttribute("page", page);
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "notice/view";
	}
	
	//공지글쓰기처리 요청
	@RequestMapping("/insert.no")
	public String insert(BoardVO vo, HttpSession session, MultipartFile file, Model model) {
		
		if( ! file.isEmpty() ) {
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload(session, file, "notice") );
		}
		
		MemberVO user = (MemberVO) session.getAttribute("loginInfo");
		vo.setUser_id(user.getUser_id());
		vo.setUser_type(user.getUser_type());
		
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
	public String noticeView(HttpSession session, Model model, @RequestParam(defaultValue="10") int pageList, @RequestParam(defaultValue = "1") int curPage, String search, String keyword) {
		session.setAttribute("category", "no");
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		page.setPageList(pageList);
		model.addAttribute("page", service.notice_list(page));
		return "notice/list";
	}
}
