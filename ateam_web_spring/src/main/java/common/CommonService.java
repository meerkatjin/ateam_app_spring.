package common;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import recipe.RecipeDAO;

@Service
public class CommonService {
//	@Scheduled( cron="0 0 0 0 01 * ?") //매월 1일 12시 0분 0 0초 
	
	//매 분마다 작동
	@Scheduled( cron="0 * * * * *") //초 분 시 일 월 요일 년
	public void process() {
		System.out.println("테스트");
	}
	
	//파일다운로드
	public File fileDownload(String filename, String filepath
							, HttpSession session
							, HttpServletResponse response) {
		//다운로드할 파일객체를 생성
		File file = new File( session.getServletContext().getRealPath("resources")
					+ "/" + filepath );
		//content type 지정을 위한 파일의 마임타입
		String mime = session.getServletContext().getMimeType(filename);
		
		response.setContentType(mime);
		try {
			filename = URLEncoder.encode(filename, "utf-8")
							.replaceAll("\\+", "%20");
			
			response.setHeader("content-disposition"
							, "attachment; filename=" + filename);
			
			ServletOutputStream out = response.getOutputStream();
			FileCopyUtils.copy( new FileInputStream(file), out);
			out.flush();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return file;
	}
	
	
	//파일업로드
	public String fileUpload(HttpSession session
							, MultipartFile file, String category) {
		//서버의 물리적위치 
		String resources 
			= session.getServletContext().getRealPath("resources");
		//D://Study_Spring/...... /iot/resources
		//  /upload/notice/2021/02/03/erf32e33_abc.txt
		String upload = resources + "/upload";
		String folder = upload + "/" + category + "/" 
						+ new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		
		File f = new File( folder );
		if( ! f.exists() ) f.mkdirs();
		
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		try {
			file.transferTo( new File(folder, uuid) );
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return folder.substring(resources.length()+1) + "/" + uuid;
	}
	
	
}
