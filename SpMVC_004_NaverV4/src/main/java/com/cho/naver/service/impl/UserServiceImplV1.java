package com.cho.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cho.naver.config.QualifierConfig;
import com.cho.naver.model.UserVO;
import com.cho.naver.persistance.UserDao;
import com.cho.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.USER_V1)
public class UserServiceImplV1 implements UserService{

	@Autowired
	protected UserDao userDao;
	
	@Autowired
	@Override
	public void create_user_table() {
		try {
			userDao.create_user_table();
			log.debug("USER TABLE OK!!");
		} catch (Exception e) {
			log.debug("USER TABLE CREATE ERROR");
		}
		
	}
	
	@Override
	public List<UserVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> findByNickName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO login(UserVO vo) {
		UserVO loginUser = userDao.findById(vo.getUsername());
		if(loginUser != null &&
			loginUser.getPassword().equals(vo.getPassword())) {
				return loginUser;
			}
				
		return null;		
	}

	/*
	 * 최초로 회원 가입을 하는 유저는 ADMIN 권한을 부여하고
	 * 그 외는 USER 권한을 부여하겠다.
	 */
	@Override
	public int join(UserVO vo) {
		/*
		 * 가입요청한 정보가 최초인지 검사하여
		 * 최초이면 현재 사용자의 role 정보를 ADMIN 으로 설정한다.
		 */
		List<UserVO> users = userDao.selectAll();
		if(users ==null || users.size() <1) {
			vo.setRole("ADMIN");
		} else {
			vo.setRole("GUEST");
		}
		int ret = userDao.insert(vo);
		
		return ret;
	}

}
