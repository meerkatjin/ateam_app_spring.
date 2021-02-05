package com.hanul.ateamappspring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import commons.FcmUtill;

@Controller
public class BackServiceController {

	@ResponseBody @RequestMapping("/alarmRequest")
	public void alarmRequest(String tokenID, HttpServletRequest request) {
		String title = "알람메세지";
		String content = "내용";
		//long user_id, String user_type, 
		FcmUtill fcmUtill = new FcmUtill();
		fcmUtill.send_FCM(tokenID, title, content, request);
	}
}
