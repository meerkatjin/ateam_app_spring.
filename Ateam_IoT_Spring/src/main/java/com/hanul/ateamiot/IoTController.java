package com.hanul.ateamiot;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import vision.VisionService;

@Controller
public class IoTController {
	
	@RequestMapping(value="/raspPic", method = {RequestMethod.GET, RequestMethod.POST}  )
	public String raspPic(HttpServletRequest req, Model model){
		System.out.println("raspPic()");
		
		VisionService vision = new VisionService();
		
		ArrayList<String> a = new ArrayList<String>();
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		MultipartRequest multi = (MultipartRequest)req;
		MultipartFile file = multi.getFile("media");
			
		if(file != null) {
			String fileName = file.getOriginalFilename();
			System.out.println(fileName);
			
			// 디렉토리 존재하지 않으면 생성
			makeDir(req);	
				
			if(file.getSize() > 0){			
				String realImgPath = req.getSession().getServletContext()						
						.getRealPath("/resources/");
				
				//System.out.println( fileName + " : " + realImgPath);
				System.out.println( "fileSize : " + file.getSize());					
												
			 	try {
			 		// 이미지파일 저장
					file.transferTo(new File(realImgPath, "capture.jpg"));										
				} catch (Exception e) {
					e.printStackTrace();
				}
			 	
			 	a = vision.vision(realImgPath+"/capture.jpg", req);
									
			}else{
				// 이미지파일 실패시
				fileName = "FileFail.jpg";
				String realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/" + fileName);
				System.out.println(fileName + " : " + realImgPath);		
			}
		}
		
		for (String string : a) {
			System.out.println("되라:" + string);
		}
		
		// 저장된 이미지 MyPicutr.jpg를 API에 보내서 인식하는가?

		return "raspPic";
	}
	
	public void makeDir(HttpServletRequest req){
		File f = new File(req.getSession().getServletContext()
				.getRealPath("/resources"));
		if(!f.isDirectory()){
			f.mkdir();
		}	
	}
}
