package com.cho.score.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cho.score.model.StudentVO;
import com.cho.score.service.ScoreService;
import com.cho.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/score")
public class ScoreController {
	private final StudentService stService;
	private final ScoreService scService;
	public ScoreController(StudentService stService, ScoreService scService) {
		this.stService = stService;
		this.scService = scService;
	}


	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String st_num, Model model ) {
		StudentVO student = stService.findById(st_num);
		model.addAttribute("ST",student);
		return "score/input";
	}
	
	
	/*
	 * 한 개의 form 에 다수의 input 박스가 동일한 name 으로 존재할 경우
	 * Controller 에서 데이터를 받을 때 문자열 배열로 데이터를 받는다.
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(String st_num, String[] sb_code, String[] sc_score) {
		for(int i = 0 ; i < sb_code.length; i ++) {
			log.debug("받은 데이터 {} {} {}" , st_num, sb_code[i], sc_score[i]);
		}
		scService.updateScore(st_num, sb_code, sc_score);
		
		/* Map<String, List<String>> scoreList = new HashMap<>(); */
		return "redirect:/student/detail?st_num="+ st_num;
	}
	
}
