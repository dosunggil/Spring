package com.cho.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cho.score.model.ScoreVO;
import com.cho.score.model.StudentVO;
import com.cho.score.service.ScoreService;
import com.cho.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/student")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@ResponseBody
	@RequestMapping(value = "json", method = RequestMethod.GET)
	public List<StudentVO> home() {
		return studentService.selectAll();
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<StudentVO> stList = studentService.selectAll();
		model.addAttribute("STLIST", stList);
		return "student/list";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(String st_num, Model model) {
		StudentVO stvo = studentService.findById(st_num);
		model.addAttribute("ST", stvo);
		log.debug("여기입니다2" + stvo.toString());
		return "student/detail";
	}
	@RequestMapping(value="/update/{st_num}",method=RequestMethod.GET)
	public String update(@PathVariable("st_num") String st_num, Model model) {
		StudentVO stvo = studentService.findById(st_num);
		model.addAttribute("ST", stvo);
		return "student/update";
	}
	@RequestMapping(value="/update/{st_num}",method=RequestMethod.POST)
	public String update(StudentVO vo,  Model model) {
		log.debug("여기보소"+vo.toString());
		studentService.update(vo);
		model.addAttribute("ST", vo);
		return "student/detail";
	}
}
