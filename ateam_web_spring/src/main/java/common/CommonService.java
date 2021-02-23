package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONTokener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import recipe.RecipeDAO;

@Service
public class CommonService {
//	@Scheduled( cron="0 0 0 0 01 * ?") //매월 1일 12시 0분 0 0초 
	
	//매 분마다 작동
	@Scheduled( cron="0 * * * * *") //초 분 시 일 월 요일 년
	public void process() {
		System.out.println("테스트");
	}

	public String requestAPI(StringBuffer url, String property) {
		String result = url.toString();
		try {
			HttpURLConnection conn 
			= (HttpURLConnection)new URL( result ).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			conn.setRequestProperty("Authorization", property);
			
			BufferedReader reader;
			if( conn.getResponseCode()>=200 && conn.getResponseCode()<=300 ) {
				reader = new BufferedReader( new InputStreamReader(
										conn.getInputStream(), "utf-8" ) );
			}else {
				reader = new BufferedReader( new InputStreamReader(
										conn.getErrorStream(), "utf-8" ) );
			}
			url = new StringBuffer();
			while( (result = reader.readLine())!=null ) {
				url.append(result);
			}
			reader.close();
			conn.disconnect();
			result = url.toString();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public String requestAPI(StringBuffer url) {
		String result = url.toString();
		try {
			HttpURLConnection conn 
			= (HttpURLConnection)new URL( result ).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			BufferedReader reader;
			if( conn.getResponseCode()>=200 && conn.getResponseCode()<=300 ) {
				reader = new BufferedReader( new InputStreamReader(
										conn.getInputStream(), "utf-8" ) );
			}else {
				reader = new BufferedReader( new InputStreamReader(
										conn.getErrorStream(), "utf-8" ) );
			}
			url = new StringBuffer();
			while( (result = reader.readLine())!=null ) {
				url.append(result);
			}
			reader.close();
			conn.disconnect();
			result = url.toString();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
