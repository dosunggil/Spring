package com.cho.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cho.todo.persistence.UserDao;

@Service
public class BeanServiceImpl {
	
	@Autowired
	private UserDao userDao;
	
	/*
	 * xml 이 아닌 java class 에서 bean 생성하기
	 */
	@Bean("passwordEncoder")
	public PasswordEncoder getPassword() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * UserServiceImpl 에서 table 을 생성하는 SQL 호출하면
	 * @Transactional 과 충돌하는 현상이 발생하여
	 * 별도 클래스로 method 를 분리했다.
	 */
	// 프로젝트가 시작될 때 테이블 생성하기
	@Bean
	public void create_table() {
		userDao.create_user_table();
		userDao.create_auth_table();
	}
}
