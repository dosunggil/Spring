package com.cho.naver.service;

import java.util.List;

import com.cho.naver.model.BookVO;

public interface NaverService {

	public String queryString(String cat, String search);
	public List<Object> getNaver(String queryString);
}
