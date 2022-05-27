package com.cho.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cho.school.model.UserVO;
import com.cho.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userS) {
		this.userService = userS;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return null;
	}

	/*
	 * 1. login.form 에서 username 과 password 받기
	 * 2. userVO 에 담겨서 받게 된다.
	 * 3. userVO 를 UserService.login() 에 전달한다.
	 * 4. UserService.login() 는 username 과 password 를 검사한다.
	 * 5. 정상적인(username 과 password 가 일치 (유효)) 정보이면
	 * 		 나머지 user 정보를 userVO 에 담아서 return 한다.
	 * 		 만약 정상적인 사용자가 아니면 null 을 return 한다.
	 * 6. Controller.login.POST method 에는 HttpSession 클래스를 매개변수로 설정된다.
	 * 7. 정상 사용자 정보이면(userVO 가 null 이 아니면)
	 * 		setAttribute() 로 사용자 정보를 USER 변수에 setting 한다.
	 * 8. 정상 사용자 정보가 아니면 
	 * 		remove() 로 혹시 모를 USER 변수를 제거한다. 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpSession session, Model model) {
		// 로그인 폼에서 입력한 username, password 는 userVO 에 담겨
		// 이곳에 도착한다.
		log.debug(userVO.toString());
		
		
		// Server 와 view 사이에서 약속된 Protocol 을 사용하기 위하여
		// 변수를 선언하고
		String loginMessage = null;
		// 로그인 폼에서 전송된 데이터 중 username 으로
		// findById() 즉 SelectOne(username) 을 실행한다.
		// 그리고 결과를 loginUserVO 에 담는다.
		// 만약 username 정보가 user table 에 없으면 결과는 null 이고,
		// 정보가 있으면 관련 데이터가 포홤된 vo 가 만들어진다.
		UserVO loginUserVO = userService.findById(userVO.getUsername());
		
		// username 이 가입된적 없을때
		if(loginUserVO == null) {
			// 가입된 적이 없다는 Keyword 를 생성하고,
			loginMessage = "USERNAME FAIL";
		} else
		// username 은 있는데 password 가 다를 경우
		if(!loginUserVO.getPassword().equals(userVO.getPassword())) {
			// 비밀번호가 잘못 됐다는 Keyword 를 생성하고
			loginMessage = "PASSWORD FAIL";
		}


		if (loginMessage == null){
			session.setAttribute("USER", loginUserVO);
		} else {
			session.removeAttribute("USER");
		}
		// view 로 보낼 message Protocol 을 setting 하기
		model.addAttribute("LOGIN_MESSAGE",loginMessage);
			return "user/login_ok";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("USER");
		
		/*
		 * redirect : 
		 * 로그아웃이 끝나면 
		 * web browser 의 주소창에 localhost:8080/user/login 을 입력하고
		 * Enter 를 눌러라
		 */
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		
		/*
		 * 이 method 를 요청하는 url 은
		 * /user/join 이다.
		 * 
		 * return null 을 실행하면
		 * return user/join 을 실행한 것과 같다.
		 * views/user/join.jsp 를 rendering 하라는 의미.
		 */
		return null;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		log.debug(userVO.toString());
		userService.join(userVO);		
		
		/*
		 * return "문자열" : Forwarding
		 * => views/문자열.jsp 를 rendering 하라.
		 * 
		 * return "redirect:/url" : pass, toss, redirect
		 * => 서버의 localhost:8080/url 을 다시 request 하라.
		 */
		return "redirect:/user/login";
	}
	
	/*
	 * username 중복검사를 하기 위하여 보통 다음같은 요청을 수행한다.
	 *  /user/idcheck?username=callor
	 *  
	 *  
	 *  fetch(`${rootPath}/user/idcheck/${username.value}`)
	 *  만약 username 에 callor 를 입력했으면
	 *  /user/idcheck/callor 처럼 요청 url 을 만들어서 요청을 수행하라
	 *  
	 *  id 를 email 주소로 사용할 때 PathVarriable 로 받을 경우
	 *  dot(.) 이후의 문자열을 잘라버리는 현상이 있다.
	 *  
	 *  이때는 정규식(Rexp) 을 사용하여 dot(.) 이후 문자열을 포함하여  변수에 저장하도록 변수를 수정
	 *  {username:.+} 형식으로 지정한다.
	 */
	@ResponseBody
	@RequestMapping(value="/idcheck/{username:.+}", method=RequestMethod.GET)
	public String idcheck(@PathVariable String username) {
		UserVO userVO1 = userService.findById(username);
		
//		if(userVO1.getUsername().equalsIgnoreCase(username))
//			return "FAIL";
//		else return "OK";
		if(userVO1 == null) {
			return "OK";
		}else {
			return "FAIL";}
	}
	
}
