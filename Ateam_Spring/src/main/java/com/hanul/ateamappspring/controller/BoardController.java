package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import board.service.BoardService;

@Controller
public class BoardController {
	@Autowired private BoardService service;

	@RequestMapping("/list.no")
	public String noticeView(Model model) {
		model.addAttribute("boardList", service.notice_list());
		return "board/board";
	}
}
