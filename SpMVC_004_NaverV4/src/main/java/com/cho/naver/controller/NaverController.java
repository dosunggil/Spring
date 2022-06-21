package com.cho.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cho.naver.config.NaverConfig;
import com.cho.naver.config.QualifierConfig;
import com.cho.naver.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/naver")
@Controller
public class NaverController {

	private final NaverService naver;

	public NaverController(@Qualifier(QualifierConfig.SERVICE.NAVER_V1) NaverService naver) {

		this.naver = naver;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home() {

		return "naver/search";
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST, produces = NaverConfig.APP_JSON)
	public String home(String cat, String search, Model model) {
		log.debug("카테고리 : " + cat);
		log.debug("검색어 : {} ", search);
		String queString = naver.queryString(cat, search);
		List<Object> bookList = naver.getNaver(queString);

		model.addAttribute("BOOKS", bookList);
		return "naver/book_search";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String book_search(String title, Model model) {

		String queryString = naver.queryString("BOOK", title);
		List<Object> bookList = naver.getNaver(queryString);
		model.addAttribute("BOOKS", bookList);
		return "naver/book_search";
	}

	/*
	 * ISBN 코드를 전달받아 Naver 에 검색한 후 한개의 도서 정보만 JSON type 으로 보내기
	 */
	@ResponseBody
	@RequestMapping(value = "/{isbn}/book", method = RequestMethod.GET, produces = NaverConfig.APP_JSON)
	public Object book(@PathVariable("isbn") String isbn) {

		String queryString = naver.queryString("BOOK", isbn);
		List<Object> bookList = naver.getNaver(queryString);

		return bookList.get(0);

	}
//	@RequestMapping(value = "/books", method = RequestMethod.GET)
//	public String getBooks(String title, Model model) {
//
//		String queryString = naver.queryString("BOOK", title);
//		List<BookVO> bookList = naver.getNaverBook(queryString);
//
//		model.addAttribute("BOOKS", bookList);
//
//		return "naver/book_search";
//	}

}
