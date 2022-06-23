package com.cho.ems.service;

import com.cho.ems.model.UserVO;
import com.cho.ems.persistance.UserDao;

public interface UserService extends UserDao{

	public int join(UserVO userVO);
	public int join_next(UserVO userVO);
}
