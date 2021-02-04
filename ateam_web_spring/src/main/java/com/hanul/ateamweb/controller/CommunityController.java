package com.hanul.ateamweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommunityController {
	//커뮤니티 게시판 이동
	@RequestMapping("/commu")
	public String commu() {
		return "community/commu";
	}
	
	//커뮤니티 글쓰기 이동
	@RequestMapping("/commu_write")
	public String commu_write() {
		return "community/commu_write";
	}
	
	//커뮤니티 게시판 이동
	@RequestMapping("/commu_read")
	public String commu_read() {
		return "community/commu_read";
	}
}
