package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import notice.NoticePage;
import notice.NoticeServiceImpl;

@Controller
public class NoticeController {
	@Autowired private NoticeServiceImpl service;
	@Autowired private NoticePage page;

	@RequestMapping("/list.no")
	public String noticeView(Model model) {
		model.addAttribute("page", service.notice_list(page));
		return "notice/list";
	}
}
