package com.cho.naver.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cho.naver.model.BookVO;
import com.cho.naver.model.BuyBookVO;
import com.cho.naver.model.UserVO;
import com.cho.naver.persistance.BookDao;
import com.cho.naver.persistance.BuyBookDao;
import com.cho.naver.service.BuyBooksService;

@Service
public class BuyBooksServiceImplV1 implements BuyBooksService {

	@Autowired
	protected BookDao bookDao;
	@Autowired
	protected BuyBookDao buyDao;
	@Override
	public List<BuyBookVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuyBookVO findByIsbnAndUserName(String isbn, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyBookVO> findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyBookVO> findByUserName(String username) {
		return buyDao.findByUserName(username);
	}

	// 사용하지 않을 insert
	@Override
	public int insert(BuyBookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * userVO 와 bookVo 에 담긴 데이터를 기준으로
	 * tbl_books 데이터와 tbl_buybooks 데이터를 추가하기
	 * 만약 tbl_books table 에 이미 같은 isn 이 있으면 update 수행
	 */
	@Override
	@Transactional
	public int insert(UserVO userVO, BookVO bookVO) {
		//isbn 에 해당하는 도서가 있냐?
		BookVO resultBook = bookDao.findById(bookVO.getIsbn());
		if(resultBook ==null) {
			
			//없으면 insert
			bookDao.insert(bookVO);
		} else {
			// 있으면 update
			bookDao.update(bookVO);
		}
		
		// 구입한 도서정보를 tbl_buybooks 에 추가하기
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		BuyBookVO buyBooksVO = BuyBookVO.builder()
				.b_date(dateFormat.format(date))
				.b_isbn(bookVO.getIsbn())
				.b_username(userVO.getUsername())
				.build();
		buyDao.insert(buyBooksVO);
		return 0;
	}

}
