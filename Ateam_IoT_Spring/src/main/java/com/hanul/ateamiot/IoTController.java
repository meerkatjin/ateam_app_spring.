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
import vision.VisionServiceImp;
import vision.VisionVO;

@Controller
public class IoTController {
	@Autowired private VisionAPI vision;
	@Autowired private CommonService common;
	@Autowired private VisionServiceImp service;
	
	@RequestMapping(value="/raspPic", produces="application/text; charset=utf-8" )
	public String raspPic(HttpServletRequest req, Model model, MultipartFile file, String product_id){
		ArrayList<VisionVO> vos = new ArrayList<VisionVO>();
		if( ! file.isEmpty() ) {
			ArrayList<String> datas = new ArrayList<String>();
			
			String uuid = UUID.randomUUID().toString() + ".jpg";	//파일 이름이 될 uuid
			String filePath = common.fileUpload(req, file, uuid, "board");	//실제 저장경로 저장
			datas = vision.vision(req, filePath);	//visionAPI 결과 저장
			
			for (String nm : datas) {
				VisionVO vo = new VisionVO();
				vo.setImage_name(uuid);
				vo.setImage_path(filePath);
				vo.setProduct_id(product_id);
				vo.setContent_nm(nm);
				vos.add(vo);
			}
			
			service.inputData(vos);
		}else {
			System.out.println("실패");
		}
		

		return "raspPic";
	}
}
