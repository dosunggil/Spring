package com.cho.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cho.score.model.StudentVO;
import com.cho.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	private StudentService studentService;
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	@ResponseBody
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET )
	public List<StudentVO> home() {
		return studentService.selectAll();
	}
}
