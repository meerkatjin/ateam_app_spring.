package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import notice.NoticePage;
import notice.NoticeServiceImpl;

@Controller
public class NoticeController {
	@Autowired private NoticeServiceImpl service;
	@Autowired private NoticePage page;

	//공지사항 화면 요청
	@RequestMapping("/list.no")
	public String noticeView(HttpSession session, Model model, @RequestParam(defaultValue = "1") int curPage) {
		session.setAttribute("category", "no");
		page.setCurPage(curPage);
		model.addAttribute("page", service.notice_list(page));
		return "notice/list";
	}
}
