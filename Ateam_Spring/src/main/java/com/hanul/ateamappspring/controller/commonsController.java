package com.hanul.ateamappspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import commons.FcmUtill;
import frigecontents.service.FrigeContentsService;

@Controller
public class commonsController {
	@Autowired private FrigeContentsService service;

	@ResponseBody @RequestMapping("/alarmRequest")
	public void alarmRequest(long user_id, String tokenID) {
		int num = service.getLifeEndNum(user_id);
		if(num > 0) {			
			String title = "유통기한 알림";
			String content = "유통기한이 임박한 내용물이" + num + "개 있습니다!";
			//long user_id, String user_type, 
			FcmUtill fcmUtill = new FcmUtill();
			fcmUtill.send_FCM(tokenID, title, content);
		}
	}
}
