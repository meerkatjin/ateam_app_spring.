package com.hanul.ateamweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.CommonService;
import notice.NoticePage;
import webview.WebViewPage;
import webview.WebViewServiceImple;

@Controller
public class WebViewController {
	@Autowired private WebViewServiceImple service;
	@Autowired private WebViewPage page;
	@Autowired private CommonService common;
	
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
	
	@RequestMapping("/view.ap")
	public String view(Model model, int board_no) {
		service.webview_read(board_no);
		
		model.addAttribute("vo", service.webview_view(board_no));
		model.addAttribute("page", page);
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "webview/view";
	}
}
