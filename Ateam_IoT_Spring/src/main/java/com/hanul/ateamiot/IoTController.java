package com.hanul.ateamiot;

import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import common.FcmUtill;
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
	
	@ResponseBody @RequestMapping(value="/raspCall", produces="application/text; charset=utf-8")
	public void raspCall(String product_id) {
		int num = service.checkCount(product_id);
		//String tokenID = service.searchToken(product_id);
		
		System.out.println(num);
//		if(num > 0) {			
//			String title = "새 내용물 알림";
//			String content = "새로 등록된 내용물이" + num + "개 있습니다!";
//			FcmUtill fcmUtill = new FcmUtill();
//			fcmUtill.send_FCM(tokenID, title, content);
//		}
	}
}
