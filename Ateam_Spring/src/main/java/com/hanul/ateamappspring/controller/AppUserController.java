package com.hanul.ateamappspring.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import user.dto.AppUserDTO;
import user.service.AppUserService;

@Controller
public class AppUserController {
	@Autowired
	private AppUserService service;

	@RequestMapping(value = "/appJoin", method = { RequestMethod.GET, RequestMethod.POST })
	public String appJoin(Model model, AppUserDTO dto) {
		System.out.println("appJoin()");

		model.addAttribute("appJoin", String.valueOf(service.appJoin(dto)));

		return "appJoin";
	}

	@RequestMapping(value = "/appLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String appLogin(Model model, String email, String pw) {
		System.out.println("appLogin()");

		

		model.addAttribute("email", email);
		model.addAttribute("pw", pw);

		return "appLogin";
	}

}
