package com.cho.naver.service.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.cho.naver.config.NaverConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NaverBookServiceEx {

	/*
	 * 카테고리와 search 에 담긴 값을 전달받아서
	 * Naver 에 요청할 QueryString 을 생성하는 method
	 */
	public String queryString(String cat, String search) {

		// https://open.../book.json
		String querySting = NaverConfig.NAVER_BOOK_URL;
		
		String encodeSearch = null;
		try {
			encodeSearch = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("URL Encoding 오류 발생");
			return null;
		}
		querySting += String.format("?query=%s", encodeSearch);
		log.debug("Query : " + querySting);
		
		querySting += String.format("&display=%d", 10);
		return querySting;
	} //queryString() end
	
	// queryString 을 전달받아 Naver 에 데이터를 요청하고
	// 응답받은 Json String 을 return 하기
	public String getJsonString(String queryString) {
		
		// java.net.URL 을 import
		URL url = null;
		HttpURLConnection httpCon = null;
		
		// queryString(URL, 요청정보) 를 사용하여 
		// Network 통해서 보낼 데이터로 생성하기
		try {
			url = new URL(queryString);
			httpCon = (HttpURLConnection) url.openConnection();
			
			// GET 방식으로 요청한다.
			httpCon.setRequestMethod("GET");
			
			httpCon.setRequestProperty(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
			httpCon.setRequestProperty(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);
			
			// Naver 에게 queryString 정보를 보내고
			// response 해줄 데이터가 있는지 먼저 확인한다.
			int resCode = httpCon.getResponseCode();
			
			BufferedReader buffer = null;
			InputStreamReader is = null;
			
			// Naver 가 200 코드를 보내면
			if (resCode == 200) {
				// 데이터를 받아올 통로를 연결하기
				is = new InputStreamReader(httpCon.getInputStream());
			} else {
				// 200 코드가 아니면 오류메세지를 받을 통로를 연결
				is = new InputStreamReader(httpCon.getErrorStream());
			}
			buffer = new BufferedReader(is);
			
			String retString = "";
			while(true) {
				String line = buffer.readLine();
				if(line == null) break;
				
				retString += line;
			}
			return retString;
			
		} catch (MalformedURLException e) {
			log.debug("Query String 문자열 오류");
			return null;
		} catch (IOException e) {
			log.debug("네트워크 연결을 할 수 없음");
			return null;
		}
		
	}
}
