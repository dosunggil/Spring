package com.cho.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cho.todo.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	// localhost:8080/context/user/login 
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("error",error);
		return null;
	}
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		
		return null;
	}
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVO username) {
		log.debug("여기입니다"+ username);
		return "redirect:/";
	}
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage() {
		
		return null;
	}
}
