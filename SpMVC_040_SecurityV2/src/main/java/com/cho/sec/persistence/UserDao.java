package com.cho.sec.persistence;

import java.util.List;

import com.cho.sec.model.AuthorityVO;
import com.cho.sec.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String> {
	public void create_user_table();
	public void create_author_table();
	public int roleInsert(List<AuthorityVO> authList);
	public List<AuthorityVO> roleSelect(String username);
}
