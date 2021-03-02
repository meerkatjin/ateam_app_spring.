package com.hanul.ateamiot;

import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import vision.VisionAPI;

@Controller
public class IoTController {
	@Autowired private VisionAPI vision;
	@Autowired private CommonService common;
	
	@RequestMapping(value="/raspPic", produces="application/text; charset=utf-8" )
	public String raspPic(HttpServletRequest req, Model model, MultipartFile file){
		ArrayList<String> aho = new ArrayList<String>();
		
		if( ! file.isEmpty() ) {
			String uuid = UUID.randomUUID().toString() + ".jpg";
			String filePath = common.fileUpload(req, file, uuid, "board");
			aho = vision.vision(req, filePath);
		}
		
		for (String string : aho) {
			System.out.println(string);
		}

		return "raspPic";
	}
}
