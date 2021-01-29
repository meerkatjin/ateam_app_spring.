package com.hanul.ateamappspring.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import user.dto.AppUserDTO;
import user.service.AppUserService;

@Controller
public class AppUserController {
	@Autowired
	private AppUserService service;
	
	//유저 리스트 가져오기
	@RequestMapping(value = "/getUserList")
	public String getUserList(Model model) {
		model.addAttribute("getUserList", service.getUserList());
		return "getUserList";
	}

	//회원가입
	@RequestMapping(value = "/appJoin")
	public String appJoin(Model model, AppUserDTO dto) {
		//먼저 중복가입인지 확인한다.
		AppUserDTO chaeck = service.appUserCheck(dto);
		
		int succ = 0;
		if(chaeck == null) {	//중복가입이 아니면 회원가입진행
			succ = service.appJoin(dto);
		}else {					//중복가입이면 실패 리턴
			succ = -100;
		}
		
		model.addAttribute("requestSuccess", String.valueOf(succ));

		return "requestSuccess";
	}

	//로그인
	@RequestMapping(value = "/appLogin")
	public String appLogin(Model model, AppUserDTO dto) {
			model.addAttribute("appLogin", service.appLogin(dto));			
		return "appLogin";
	}
	
	//카카오 로그인
	@RequestMapping(value = "/appKakaoLogin")
	public String appKakaoLogin(Model model, AppUserDTO dto) {
		//회원에 등록되어있는 카카오 유저인지 확인
		AppUserDTO chaeck = service.appUserCheck(dto);
		
		int succ = 0;
		if(chaeck == null) {	//회원 등록이 안되어있으면 db에 회원 정보 저장 진행
				service.appJoin(dto);
		}
		
		model.addAttribute("appLogin", service.appLogin(dto));		
		
		return "appLogin";
	}
	
	//회원정보수정
	@RequestMapping(value = "/userInfoChange")
	public String userInfoModify(Model model, AppUserDTO dto, HttpServletRequest req) {

		MultipartRequest multi = (MultipartRequest)req;
		MultipartFile file = multi.getFile("image");
		
		if(file != null) {
			String fileName = file.getOriginalFilename();
			System.out.println(fileName);
			
			// 디렉토리 존재하지 않으면 생성
			makeDir(req);	
				
			if(file.getSize() > 0){			
				String realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/");
				
				System.out.println( fileName + " : " + realImgPath);
				System.out.println( "fileSize : " + file.getSize());					
												
			 	try {
			 		// 이미지파일 저장
					file.transferTo(new File(realImgPath, fileName));										
				} catch (Exception e) {
					e.printStackTrace();
				} 
									
			}else{
				// 이미지파일 실패시
				fileName = "FileFail.jpg";
				String realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/" + fileName);
				System.out.println(fileName + " : " + realImgPath);
						
			}
		}

		model.addAttribute("requestSuccess", String.valueOf(service.userInfoModify(dto)));
		return "requestSuccess";
	}
	
	//회원탈퇴
	@RequestMapping(value = "/appUserDelete")
	public String appUserDelete(Model model, AppUserDTO dto) {
		System.out.println(dto.getUser_id() + ", " + dto.getUser_type());
		if(dto.getUser_type().equals("nomal")) {
			model.addAttribute("requestSuccess", 
					String.valueOf(service.appUserDelete(dto.getUser_id(), dto.getUser_pw(), dto.getUser_type())));			
		}else {
			model.addAttribute("requestSuccess", 
					String.valueOf(service.appUserDelete(dto.getUser_id(), dto.getUser_type())));
		}
		return "requestSuccess";
	}
	
	public void makeDir(HttpServletRequest req){
		File f = new File(req.getSession().getServletContext()
				.getRealPath("/resources"));
		if(!f.isDirectory()){
		f.mkdir();
		}	
	}
}

