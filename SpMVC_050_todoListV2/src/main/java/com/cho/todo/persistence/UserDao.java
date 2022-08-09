package com.cho.todo.persistence;

import java.util.List;

import com.cho.todo.model.AuthorityVO;
import com.cho.todo.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String>{
	
	/*
	 * tbl_authorities 테이블에서
	 * username 에 해당하는 ROLE 리스트를 select 하기
	 */
	public List<AuthorityVO> select_role(String username);

}
