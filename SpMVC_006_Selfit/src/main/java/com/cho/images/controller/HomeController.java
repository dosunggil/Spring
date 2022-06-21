package com.cho.images.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cho.images.config.QualifierConfig;
import com.cho.images.service.SelfitService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	
	private final SelfitService selfitService;
	public HomeController(@Qualifier(QualifierConfig.SERVICE.SELFIT_V2) SelfitService sel) {
		this.selfitService = sel;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		selfitService.startPage(model);
		//log.debug(model.getAttribute("BEGIN_MENU").toString());
		return "home";
	}
	
	
}
