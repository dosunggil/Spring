package com.cho.naver.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value="/news")
public class NewsController {

	@RequestMapping(value="/list")
	public String list() {
		
		return null;
	}
	
}
