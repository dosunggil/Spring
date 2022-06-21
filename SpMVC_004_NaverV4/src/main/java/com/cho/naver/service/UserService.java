package com.cho.naver.service;

import com.cho.naver.model.UserVO;
import com.cho.naver.persistance.UserDao;

public interface UserService extends UserDao{
	
	public UserVO login(UserVO vo);
	public int join(UserVO vo);

}