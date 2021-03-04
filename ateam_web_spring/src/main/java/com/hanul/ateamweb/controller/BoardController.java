package com.hanul.ateamweb.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import board.BoardServiceImpl;
import common.BoardCommentVO;
import common.BoardVO;
import common.CommonService;
import member.MemberVO;
import notice.NoticePage;

@Controller
public class BoardController {
	
	@Autowired private BoardServiceImpl service;
	@Autowired private NoticePage page;
	@Autowired private CommonService common;
	
	//댓글삭제처리 요청
	@ResponseBody @RequestMapping("/board/comment/delete/{sub_no}")
	public void comment_delete(@PathVariable int sub_no) {
		service.board_comment_delete(sub_no);
	}
	
	//댓글 수정처리 요청
	@ResponseBody @RequestMapping(value="/board/comment/update", produces="application/text; charset=utf-8")
	public String comment_update(@RequestBody BoardCommentVO vo) {
		return service.board_comment_update(vo) > 0 ? "성공^^" : "실패ㅠㅠ";
	}
	
	//댓글목록조회 요청
	@RequestMapping("/board/comment/{sub_parent_no}")
	public String comment_list(@PathVariable int sub_parent_no, Model model) {
		model.addAttribute("list", service.board_comment_list(sub_parent_no));
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "board/comment/comment_list";
	}
	
	//댓글등록 처리 요청
	@ResponseBody @RequestMapping("/board/comment/insert")
	public boolean comment_insert(BoardCommentVO vo, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("loginInfo");
		vo.setUser_id( user.getUser_id() );
		return service.board_comment_insert(vo) > 0 ? true : false;
	}
	
	//첨부파일 다운로드 요청
	@ResponseBody @RequestMapping("/download.bo")
	public void download(int board_no, HttpSession session, HttpServletResponse response) {
		BoardVO vo = service.board_view(board_no);
		common.fileDownload( vo.getFilename(), vo.getFilepath(), session, response );
	}
	
	//게시판글 삭제처리
	@RequestMapping("/delete.bo")
	public String delete(int board_no) {
		service.board_delete(board_no);
		return "redirect:list.bo";
	}
	
	//게시판글 수정처리
	@RequestMapping("/update.bo")
	public String update(BoardVO vo, String attach, HttpSession session, MultipartFile file, Model model) {
		BoardVO board = service.board_view( vo.getBoard_no() );
		String uuid = session.getServletContext().getRealPath("resources") + "/" + board.getFilepath();
		
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
			if( attach.isEmpty() ) {
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
		session.setAttribute("category", "cu");
		page.setCurPage(curPage);
		model.addAttribute("page", service.board_list(page));

		return "board/list";
	}
}
