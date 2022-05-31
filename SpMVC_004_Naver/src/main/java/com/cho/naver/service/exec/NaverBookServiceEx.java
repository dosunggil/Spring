package com.cho.naver.service.exec;

import com.cho.naver.config.NaverConfig;

public class NaverBookServiceEx {

	/*
	 * 카테고리와 search 에 담긴 값을 전달받아서
	 * Naver 에 요청할 QueryString 을 생성하는 method
	 */
	public String queryString(String cat, String search) {
		String querySting = NaverConfig.NAVER_BOOK_URL;
		
		
		return querySting;
		
	}
}
