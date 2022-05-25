package com.cho.school.service.impl;

import org.springframework.stereotype.Service;

import com.cho.school.model.UserVO;
import com.cho.school.service.UserService;

/*
 * UserServiceImplV1 클래스를 Component(bean) 로 등록하기
 */
@Service
public class UserServiceImplV1 implements UserService {

	@Override
	public UserVO login(UserVO userVO) {

		String username = userVO.getUsername();
		String password = userVO.getPassword();

		if (username.equalsIgnoreCase("dosunggil") && password.equals("12341234")) {
			userVO.setName("조도성");
			userVO.setRole("ADMIN");
			userVO.setEmail("chothegenius@gmail.com");

		} else {
			userVO = null;
		}
		return userVO;
	}

	@Override
	public UserVO join(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
