package com.cho.naver.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cho.naver.model.BookVO;
import com.cho.naver.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/books")
public class BookController {

	private final BookService bookService;
	public BookController(BookService book) {
		this.bookService = book;
	}
	
	@RequestMapping(value= {"/",""})
	public String home() {
		
		/*
		 * return 문자열 형식은
		 * 명시적으로 어떤 jsp 파일을 rendering 할 것인지
		 * 알려주는 것이다.
		 * 현재 method 를 요청한 URL 에 대하여 jsp 파일을 명시적으로 전달한다.
		 */
		return "books/list";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		/*
		 * return null 형식은
		 * 암시적으로 어떤 jsp 파일을 rendering 할 것인지
		 * 알려주는 것이다.
		 * 현재 method를 요청한 URL 이 명시적으로 명확할 경우
		 * null 을 return 하면 Spring 에서 자체적으로 구성해준다.
		 */
		
		List<BookVO> bookList = bookService.selectAll();
		
		/*
		 * bookList 에 담긴 데이터를 BOOKS 이름으로 변수에 담아
		 * jsp 파일로 보내겠다.
		 */
		log.debug(bookList.toString());
		model.addAttribute("BOOKS",bookList);
		return null;
	}
	
	/*
	 * RequestMethod 가 없는 Mapping 은
	 * GET 요청이나 POST 요청을 모두 처리하는 method 가 되어버린다.
	 * 
	 * method=RequestMethod.GET 로 지정을 하면
	 * a tag link 를 눌렀을때의 요청만 처리하도록 역할을 제한한다.
	 */
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		
		return null;
	}
	
	/*
	 * method=POST 가 부착된 form 으로 감싼 데이터들이 전송되었을때
	 * 요청을 받아 처리할 method
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BookVO vo) {
		log.debug("도서정보 : "+ vo.toString());
		bookService.insert(vo);
		
		return null;
	}
	@RequestMapping(value="/insert2",method=RequestMethod.GET)
	public String insert2() {
		
		
		return null;
	}
	
	/*
	 * method=POST 가 부착된 form 으로 감싼 데이터들이 전송되었을때
	 * 요청을 받아 처리할 method
	 */
	@RequestMapping(value="/insert2",method=RequestMethod.POST)
	public String insert2(BookVO vo) {
		log.debug("도서정보 : "+ vo.toString());
		bookService.insert(vo);
		
		return null;
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail() {
		
		return null;
	}
}
