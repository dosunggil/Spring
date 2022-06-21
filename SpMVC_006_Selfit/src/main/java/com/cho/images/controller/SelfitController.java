package com.cho.images.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cho.images.config.QualifierConfig;
import com.cho.images.service.SelfitService;

@Controller
@RequestMapping(value="/workout")
public class SelfitController {

	private final SelfitService selfitService;
	
	public SelfitController(@Qualifier(QualifierConfig.SERVICE.SELFIT_V2) SelfitService sef) {
		this.selfitService = sef;
	}
	
	@RequestMapping(value="/dayset/{sc_num}",method=RequestMethod.GET)
	public String daySet(@PathVariable("sc_num") String sc_num, Model model) {
		
		selfitService.getDaySetList(model, sc_num);
		
		return "workout/dayset";
	}
	
	
}
