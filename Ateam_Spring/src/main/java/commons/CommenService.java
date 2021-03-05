package commons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import frigecontents.dto.FrigeContentsDTO;
import frigecontents.service.FrigeContentsService;

@Service
public class CommenService {
	@Autowired private FrigeContentsService service;

	//매 시간마다 작동
	@Scheduled( cron="0 5 * * * *") //초 분 시 일 월 요일 년
	public void process() {
		List<FrigeContentsDTO> list = service.getLifeEndUsers();
		
		for (FrigeContentsDTO dto : list) {
			if(dto.getNum() > 0) {
				String title = "유통기한 알림";
				String content = "유통기한이 임박한 내용물이" + dto.getNum() + "개 있습니다!";
				//long user_id, String user_type, 
				FcmUtill fcmUtill = new FcmUtill();
				fcmUtill.send_FCM(dto.getDevice_token(), title, content);
			}
			
			System.out.println("유통기한 넘은 숫자 : " + dto.getNum());
			System.out.println("디바이스 토큰 : " + dto.getDevice_token());
		}
	}
}
