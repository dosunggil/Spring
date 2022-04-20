package com.cho.app;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 여기는 Controller
 * @Controller 클래스에 부착하는 Annotation 
 */
@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		/*
		 * model 객체에 변수명="데이터" 속성을 추가하여
		 * jsp 에 rendering 할 데이터를 준비하기
		 * model.addAttribute("변수명","데이터"); 
		 * 변수의 타입은 상관없다. 어떤 변수든지 담을 수 있다. 변수의 선언 또한 안해도 된다.
		 */
		model.addAttribute("my_name","조도성");
		
		String[] st = {"홍씨","이씨","성씨","박씨","강씨"};
		model.addAttribute("ST",st);
		return "home";
	}
	
	
}
