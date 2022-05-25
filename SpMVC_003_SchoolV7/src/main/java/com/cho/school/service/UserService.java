package com.cho.school.service;

import com.cho.school.model.UserVO;

public interface UserService {

	public UserVO login(UserVO userVO) ;
	public UserVO join(UserVO userVO);
	
}
