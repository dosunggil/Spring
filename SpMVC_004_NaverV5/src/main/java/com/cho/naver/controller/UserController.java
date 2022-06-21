package com.cho.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cho.naver.config.QualifierConfig;
import com.cho.naver.model.BookVO;
import com.cho.naver.model.BuyBookVO;
import com.cho.naver.model.UserVO;
import com.cho.naver.service.BookService;
import com.cho.naver.service.BuyBooksService;
import com.cho.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	@Qualifier(QualifierConfig.SERVICE.USER_V2)
	private UserService userService;
	@Autowired
	private BookService bookService;
	@Autowired
	private BuyBooksService buyService;
	
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join( Model model) {
		
		model.addAttribute("LAYOUT","JOIN");
		return "home";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVO vo) {
		
		log.debug("회원정보 : " + vo.toString());
		userService.join(vo);
		
		return "redirect:/user/login";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(String error, Model model) {
		
		model.addAttribute("error",error);
		model.addAttribute("LAYOUT","LOGIN");
		return "home";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(UserVO vo, Model model, HttpSession session) {
		UserVO loginUser = userService.findById(vo.getUsername());
		if(loginUser ==null) {
			model.addAttribute("error","USERNAME_FAIL");
			return "redirect:/user/login";
		}
		loginUser = userService.login(vo);
		if(loginUser ==null) {
			model.addAttribute("error","PASSWORD_FAIL");
			return "redirect:/user/login";
		}
		session.setAttribute("USER", loginUser);
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USER");
		
		return "redirect:/";
	}
	
	/*
	 * 매개변수로 설정한 HttpSession
	 * Controller 의 각 method 는 Spring 으로 부터 HttpSession 객체를
	 * 주입받을 수 있다.
	 * 
	 * HttpSession 객체에는 client 와 server 간에 상태(status)를 
	 * 유지하는 정보를 담을 수 있다.
	 * 
	 * 여기에 담긴 데이터는 서버가 run 하는 동안, 일정 조건을 만족하는 동안
	 * Session 을 제거하지 않는 한 계속 메모리에 값이 남아있다.
	 * 
	 * 큰 데이터를 HttpSession에 담는것은 썩 좋지 않다.
	 * 최소환으로 status 를 유지할 수 있는 데이터만 담는 것이 좋다.
	 * 필요가 없어지면 반드시 remove 해주는 것이 좋다.
	 * 
	 * 프로젝트의 어떤 method 에서든지 한번 담은 Session 정보는
	 * 전체 프로젝트의 Controller method 에서 값을 참조할 수 있다.
	 * 
	 */
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage(Model model, HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("USER");
		if(loginUser ==null) {
			model.addAttribute("error","LOGIN_NEED");
			return "redirect:/user/login";
		}
		
		// 로그인한 사용자의 도서 구입 리스트 가져오기
		/*
		 * buyBooks 리스트에는 b_isbn, b_username, b_date 값만 담긴 상태다
		 * 왜, tbl_buybooks 에 3개의 칼럼만 있기 때문에
		 * 이 데이터만 가지고는 구체적인 도서 정보를 알 수 없다.
		 */
		List<BuyBookVO> buyBooks = buyService.findByUserName(loginUser.getUsername());
		
		// 도서 구입리스트의 ISBN 을 도서리스트에서 조회하여 가져오기.
		for(BuyBookVO buyVO : buyBooks) {
			
			String isbn = buyVO.getB_isbn();
			BookVO book = bookService.findById(isbn);
			
			buyVO.setBook(book);
		}
		
		model.addAttribute("BUY_BOOKS",buyBooks);
		model.addAttribute("LAYOUT","MYPAGE");
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck/{username}",method=RequestMethod.GET)
	public String idCheck(@PathVariable("username") String username) {
		
		UserVO userVO = userService.findById(username);
		if(userVO == null) {
			return "OK";
		}
		return "FAIL";
	}
	@ResponseBody
	@RequestMapping(value="/emailcheck",method=RequestMethod.GET)
	public String emailCheck(String email) {
		
		UserVO userVO = userService.findByEmail(email);
		if(userVO == null) {
			return "OK";
		}
		return "FAIL";
	}
		
}
