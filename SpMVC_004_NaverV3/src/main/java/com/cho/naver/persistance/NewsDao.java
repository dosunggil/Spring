package com.cho.naver.persistance;

import java.util.List;

import com.cho.naver.model.NewsVO;

public interface NewsDao extends GenericDao<NewsVO, String>{

	
	// 기본 CRUD 외에 필요한 method 가 있을 경우 별도로 얼마든지 추가할 수 있다.
	
	public List<NewsVO> findByTitle(String title);
}
