package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonService {
	//파일업로드
		public String fileUpload(HttpServletRequest req
								, MultipartFile file, String uuid, String category) {
			//서버의 물리적위치 
			String resources 
				= req.getSession().getServletContext().getRealPath("resources");
			//D://..../...... /프로젝트명/resources
			//  2021/02/03/erf32e33_abc.txt
			String folder = resources + "/"
							+ new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			
			//폴더가 없으면 폴더 만들어줌
			File f = new File( folder );
			if( ! f.exists() ) f.mkdirs();
			
			try {
				file.transferTo( new File(folder, uuid) );
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			return folder.substring(resources.length()+1) + "/" + uuid;
		}
}
