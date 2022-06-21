package com.cho.naver.persistance;

import java.util.List;

import com.cho.naver.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String> {
	public List<UserVO> findByName(String name);
	public List<UserVO> findByNickName(String name);
	
	/*
	 * email 항목을 unique 로 한다면
	 * return type 을 List 가 아닌 VO 로 하면 된다.
	 */
	public UserVO findByEmail(String email);
	
	public void create_user_table();

}
