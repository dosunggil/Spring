package com.cho.school.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cho.school.model.StudentVO;
import com.cho.school.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	/*
	 * 생성자 주입 방식
	 * HomeController homeController = new HomeController(stService)
	 */
	
	private final StudentService stService;
	public HomeController(StudentService stService) {
		this.stService = stService;
	}
	
	// 클래스에 @Slf4j Annotation 을 부착하면 다음 코드를 lombok이 대신 만들어준다.
//	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("ST_LIST",stList);
		
		return "home";
	}

}
