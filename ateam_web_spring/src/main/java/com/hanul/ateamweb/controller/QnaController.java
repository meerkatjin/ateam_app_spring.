package com.hanul.ateamweb.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
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
	public String qna(HttpSession session, Model model, @RequestParam(defaultValue = "1") int curPage, String search, String keyword) {
		session.setAttribute("category", "qa");
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		model.addAttribute("page", service.qna_list(page));
		return "qna/list";
	}
	
	   //summernote 파일 업로드
	   @PostMapping(value="/qnaUploadSummernoteImageFile")
	//   @PostMapping(value="/uploadSummernoteImageFile", produces = "application/json; charset=utf-8")
	    @ResponseBody
	    public HashMap<String, Object> uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, @RequestParam("category") String category) {
	      HashMap<String, Object> jsonObject = new HashMap<String, Object>();
//	      JSONObject jsonObject = new JSONObject();
	      String fileRoot="";
	      if(category.contains("no")) {
	         fileRoot = "D:\\ateam_app_springs\\ateam_web_spring\\resources\\notice\\";   //저장될 파일 경로
	      } else if (category.contains("qa")){
	         fileRoot = "D:\\ateam_app_springs\\ateam_web_spring\\resources\\qna\\";   //저장될 파일 경로
	      } else if (category.contains("bo")){
	         fileRoot = "D:\\ateam_app_springs\\ateam_web_spring\\resources\\board\\";   //저장될 파일 경로
	      }
	        String originalFileName = multipartFile.getOriginalFilename();   //오리지날 파일명
	        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));   //파일 확장자

	        // 랜덤 UUID+확장자로 저장될 savedFileName
	        String savedFileName = UUID.randomUUID() + extension;   
	        
	        File targetFile = new File(fileRoot + savedFileName);

	        try {
	            InputStream fileStream = multipartFile.getInputStream();
	            FileUtils.copyInputStreamToFile(fileStream, targetFile);   //파일 저장
	            if(category.contains("no")) {
	               jsonObject.put("url", "summernoteNotice/"+savedFileName);
	            } else if (category.contains("qa")) {
	               jsonObject.put("url", "summernoteQna/"+savedFileName);
	            } else if (category.contains("bo")) {
	               jsonObject.put("url", "summernoteBoard/"+savedFileName);
	            }
	            jsonObject.put("responseCode", "success");

	        } catch (IOException e) {
	            FileUtils.deleteQuietly(targetFile);   // 실패시 저장된 파일 삭제
	            jsonObject.put("responseCode", "error");
	            e.printStackTrace();
	        }
	        return jsonObject;
	    }
	
	
}
