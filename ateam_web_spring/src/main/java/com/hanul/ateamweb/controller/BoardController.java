package com.hanul.ateamweb.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String update(BoardVO vo, String filename, HttpSession session, MultipartFile file, Model model) {
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
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
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
	public String board(HttpSession session, Model model, @RequestParam(defaultValue = "1") int curPage, String search, String keyword) {
		session.setAttribute("category", "bo");
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		model.addAttribute("page", service.board_list(page));

		return "board/list";
	}
	
	   //summernote 파일 업로드
	   @PostMapping(value="/boardUploadSummernoteImageFile")
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
