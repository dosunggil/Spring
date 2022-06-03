package com.cho.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cho.naver.model.BookVO;
import com.cho.naver.persistance.BookDao;
import com.cho.naver.service.BookService;

/*
 * bookServiceV1
 * BookService interface 를 상속받은 클래스가 다수 있을 때
 * Controller 에서 어떤 클래스를 지금 연결하여 사용할 것인가의 문제가 발생한다.
 * 
 * 그럴때 식별자를 부착하여 두고
 * 클래스 중에서 필요한 부분을 선택할 수 있도록 하기위하여 부착하는것.
 */
@Service
public class BookServiceImplV1 implements BookService{

	private final BookDao bookDao;
	
	public BookServiceImplV1(BookDao book) {
		this.bookDao = book;
	}
	
	

	@Override
	public List<BookVO> selectAll() {
		List<BookVO> bookList = bookDao.selectAll();
		return bookList;
		
	}

	@Override
	public BookVO findById(String id) {
		return bookDao.findById(id);
	}

	@Override
	public int insert(BookVO vo) {
		bookDao.insert(vo);
	return 0;
	}

	@Override
	public int update(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
