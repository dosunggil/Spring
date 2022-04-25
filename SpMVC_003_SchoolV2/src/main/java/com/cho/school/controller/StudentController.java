package com.cho.school.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cho.school.domain.StudentVO;
import com.cho.school.service.StudentService;

/*
 *  Controller level 에 @RequestMapping 을 설정하면
 *  Controller 의 mapping 과 method 의 mapping 이 서로 연결되어
 *  RequestMapping 을 구성한다.
 *  localhost:8080/school/student : controller 의 mapping이 연결
 *  localhost:8080/school/student/list : StudentController#list() 의 mapping 이 연결
 */
@Controller
public class StudentController {

	
	/*
	 * Dependency inject 중에서
	 * 생성자 injection
	 */
	private final StudentService stService;
	public StudentController(StudentService stService) {
		this.stService = stService;
		
	}
	/*
	 * return type 이 String type 인 method 의 경우
	 * null 값을 return 하면, Request Path 와 같은 jsp 파일을 찾아서
	 * rendering 을 수행한다.
	 * 단, @Responsebody 설정이 없어야한다.
	 */

	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String list(Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STUDENTS", stList);
		return "student/list_view";
	}
	
	@RequestMapping(value="/student/detail", method=RequestMethod.GET)
	public String detail(String stNum, Model model) {
		
		StudentVO stVO = stService.findByStNum(stNum);
		model.addAttribute("STUDENTS",stVO);
		return "student/detail_"+stNum;
	}
	
	
	
	@RequestMapping(value="/student/insert",method=RequestMethod.GET)
	public String insert() {
		return "student/insert";
	}
	
}
	

