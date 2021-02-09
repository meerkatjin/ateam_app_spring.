package commons;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.google.api.client.http.HttpRequest;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

@Component
public class FcmUtill {
	public void send_FCM(String tokenid, String title, String content, HttpServletRequest request) {
		try {
			FileInputStream refreshToken = 
					new FileInputStream(request.getSession().getServletContext()
							.getRealPath("/resources/fcm")
							+ "/refrigerator-eaa72-firebase-adminsdk-6ah28-14a21639c6.json");
			
			FirebaseOptions options = FirebaseOptions.builder()
				    .setCredentials(GoogleCredentials.fromStream(refreshToken))
				    .setDatabaseUrl("https://refrigerator-eaa72-default-rtdb.firebaseio.com")
				    .build();
			
			//Firebase 처음 호출시에만 initializing 처리
			if(FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}
			
			//메세지 작성
			Message msg = Message.builder()
					.putData("title", title)
					.putData("body", content)
					.putData("color", "#f45342")
					.setToken(tokenid)
					.build();
			
			//메세지를 FirebaseMessaging에 보내기
			String response = FirebaseMessaging.getInstance().send(msg);
			//결과출력
			System.out.println("Successfully sent message: " + response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
