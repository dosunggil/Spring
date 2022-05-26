package com.cho.school.service;

import com.cho.school.model.UserVO;
import com.cho.school.pesistance.GenericDao;

public interface UserService extends GenericDao<UserVO, String>{

	public UserVO login(UserVO userVO) ;
	public UserVO join(UserVO userVO);
	
}
