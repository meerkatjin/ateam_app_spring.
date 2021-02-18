package com.hanul.ateamweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	//게시판화면 요청
	@RequestMapping("/list.bo")
	public String board() {
		return "board/list";
	}
}
