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
	
	@RequestMapping(value="/updateScore",method=RequestMethod.GET)
	public String updateScore(String st_num, Model model) {
		StudentVO stvo = studentService.findById(st_num);
		model.addAttribute("ST", stvo);
		return "student/updateScore";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String st_num, Model model) {
		StudentVO stvo = studentService.findById(st_num);
		model.addAttribute("ST", stvo);
		return "student/update";
	}
	
	/*
	 * student/update?st_num=S001 로 input form 에서
	 * 저장버튼을 클릭햇을 때
	 * form 에 action 이 설정되어 있지 않기 때문에
	 * POST 전송도 같은 주소로 요청이 된다.
	 * 이때 주소창에 st_num=S001 이라는 변수가 설정되어 있기 때문에
	 * form 에 st_num 항목을 설정하지 않아도 자동으로 입력된다.
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(StudentVO vo) {
		studentService.update(vo);
		String retStr = String.format("redirect:/student/detail?st_num=%s", vo.getSt_num());
		return retStr;
	}
}
