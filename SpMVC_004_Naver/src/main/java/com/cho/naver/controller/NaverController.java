package com.cho.naver.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cho.naver.model.NaverBookVO;
import com.cho.naver.service.NaverService;

@RequestMapping(value="/naver")
@Controller
public class NaverController {
	
	private final NaverService naver ;

	public NaverController(NaverService naver) {
	
		this.naver = naver;
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public String getBooks(String title, Model model){
		
		String queryString = naver.queryString("BOOK", title);
		List<NaverBookVO> bookList = naver.getNaverBook(queryString);
		
		model.addAttribute("BOOKS",bookList);
		
		return "naver/book_search";
	}
	
	
}
