package com.cho.naver.service;

import com.cho.naver.model.BookVO;
import com.cho.naver.model.UserVO;
import com.cho.naver.persistance.BuyBookDao;

public interface BuyBooksService extends BuyBookDao {
	
	public int insert(UserVO userVO, BookVO bookVO);

}
