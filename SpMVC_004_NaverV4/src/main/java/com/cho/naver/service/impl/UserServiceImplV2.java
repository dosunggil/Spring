package com.cho.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cho.naver.config.QualifierConfig;
import com.cho.naver.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.USER_V2)
public class UserServiceImplV2 extends UserServiceImplV1 {

	@Autowired
	protected PasswordEncoder passwordEncoder;

	@Override
	public int join(UserVO vo) {

		List<UserVO> users = userDao.selectAll();
		if (users == null || users.size() <1) {
			vo.setRole("ADMIN");
		} else {
			vo.setRole("GUEST");
		}

		// password 를 암호화 하자
		String planPassword = vo.getPassword();
		String encPassword = passwordEncoder.encode(planPassword);

		// 암호화된 password 를 다시 vo에 setting
		vo.setPassword(encPassword);

		// user 정보를 insert
		userDao.insert(vo);
		return 0;
	}

	@Override
	public UserVO login(UserVO vo) {
		UserVO loginUser = userDao.findById(vo.getUsername());

		String encPassword = loginUser.getPassword();
		String planPassword = vo.getPassword();

		if (passwordEncoder.matches(planPassword, encPassword)) {
			return loginUser;
		} 

		return null;
	}

}
