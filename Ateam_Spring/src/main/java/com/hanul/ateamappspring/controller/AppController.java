package com.hanul.ateamappspring.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanul.ateamappspring.command.AppCommand;
import com.hanul.ateamappspring.command.AppJoinCommand;
import com.hanul.ateamappspring.command.AppLoginCommand;

@Controller
public class AppController {
	AppCommand command;
	
	@RequestMapping(value = "/appJoin", method = {RequestMethod.GET, RequestMethod.POST})
	public String appJoin(HttpServletRequest req, Model model) {
		System.out.println("appJoin()");
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String email = (String) req.getParameter("email");
		String pw = (String) req.getParameter("pw");
		String name = (String) req.getParameter("name");
		String addr = (String) req.getParameter("addr");
		String phone_no = (String) req.getParameter("phone_no");
		
		System.out.println(email);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(addr);
		System.out.println(phone_no);
		
		model.addAttribute("email", email);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		model.addAttribute("phone_no", phone_no);
		
		command = new AppJoinCommand();
		command.execute(model);
		
		return "appJoin";
	}
	
	@RequestMapping(value="/appLogin", method = {RequestMethod.GET, RequestMethod.POST})
	public String appLogin(HttpServletRequest req, Model model) {
		System.out.println("appLogin()");
		
		String email = (String) req.getParameter("email");
		String pw = (String) req.getParameter("pw");
		
		System.out.println(email);
		System.out.println(pw);
		
		model.addAttribute("email", email);
		model.addAttribute("pw", pw);
		
		command = new AppLoginCommand();
		command.execute(model);
		
		return "appLogin";
	}
}
