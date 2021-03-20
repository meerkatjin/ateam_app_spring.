package com.hanul.ateamweb.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.BoardVO;
import common.CommonService;
import member.MemberServiceImpl;
import member.MemberVO;
import notice.NoticePage;
import webview.WebViewPage;
import webview.WebViewServiceImple;

@Controller
public class WebViewController {
	@Autowired private WebViewServiceImple service;
	@Autowired private MemberServiceImpl member;
	@Autowired private WebViewPage page;
	@Autowired private CommonService common;
	
	//앱 로그인 세션용
	@RequestMapping(value = "/appNomalLogin")
	public String appNomalLogin(Model model, String user_email, String user_pw, int board_no, HttpSession session) {
		//입력한 이메일과 비밀번호가 일치하는 회원정보 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_email", user_email);
		map.put("user_pw", user_pw);
		MemberVO vo = member.member_login(map);
		//로그인한 회원정보를 세션에 저장
		session.setAttribute("loginInfo", vo);
		
		if(board_no != 0) {
			return "redirect:view.ap?board_no="+board_no;
		}
		return "redirect:list.ap";
	}
	
	@RequestMapping(value = "/appKakaoLogin")
	public String appKakaoLogin(Model model, long user_id, String user_type, int board_no, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("user_type", user_type);
		MemberVO vo = member.member_login(map);
		//로그인한 회원정보를 세션에 저장
		session.setAttribute("loginInfo", vo);
		if(board_no != 0) {
			return "redirect:view.ap?board_no="+board_no;
		}
		return "redirect:list.ap";
	}
	
	@RequestMapping("/list.ap")
	public String appListView(HttpSession session, Model model, 
			@RequestParam(defaultValue="10") int pageList,
			@RequestParam(defaultValue = "1") int curPage, 
			@RequestParam(defaultValue = "1") String gp,
			String search, 
			String keyword) {
		page.setGp(gp);
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		page.setPageList(pageList);
		model.addAttribute("page",service.webview_list(page));
		return "webview/list";
	}
	
	@RequestMapping("/new.ap")
	public String webViewNew(Model model) {
		model.addAttribute("page", page);
		return "webview/new";
	}
	
	@RequestMapping("/insert.ap")
	public String insert(BoardVO vo, HttpSession session, MultipartFile file, Model model) {
		
		if( ! file.isEmpty() ) {
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload(session, file, "notice") );
		}
		
		MemberVO user = (MemberVO) session.getAttribute("loginInfo");
		vo.setUser_id(user.getUser_id());
		vo.setUser_type(user.getUser_type());
		
		service.webview_insert(vo);
		return "redirect:list.ap?gp="+vo.getBoard_gp();
	}
	
	@RequestMapping("/view.ap")
	public String view(Model model, int board_no) {
		service.webview_read(board_no);
		
		model.addAttribute("vo", service.webview_view(board_no));
		model.addAttribute("page", page);
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "webview/view";
	}
	
	@RequestMapping("/delete.ap")
	public String delete(int board_no, String gp, HttpSession session, Model model) {
		BoardVO vo = service.webview_view(board_no);
		if( vo.getFilename()!=null  ) {
			File file = new File( "D:\\ateam_app_springs\\ateam_web_spring\\resources" + "/" + vo.getFilepath() );
			if( file.exists() ) file.delete();
		}
		service.webview_delete(board_no);
		return "redirect:list.ap?gp="+gp;
	}
	
	@RequestMapping("/modify.ap")
	public String modify(Model model, int board_no, String gp) {
		BoardVO vo = service.webview_view(board_no);
		vo.setBoard_gp(gp);
		model.addAttribute("vo", vo);
		return "webview/modify";
	}
	
	@RequestMapping("/update.ap")
	public String update(BoardVO vo, String filename, HttpSession session, MultipartFile file) {
		BoardVO board = service.webview_view( vo.getBoard_no() );
		String uuid = "D:\\ateam_app_springs\\ateam_web_spring\\resources" + "/" + board.getFilepath();
		//첨부파일 관련처리
		try {
			if( file != null && !file.isEmpty() ) { //첨부파일 있는 경우
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
		} catch (NullPointerException e) {
			System.out.println("첨부파일 없음");
		}
		
		service.webview_update(vo);
		return "redirect:view.ap?board_no=" + vo.getBoard_no();
	}
}
