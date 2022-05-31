package com.cho.school.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cho.school.model.UserVO;
import com.cho.school.pesistance.UserDao;

@Service("userServiceV2")
public class UserServiceImplV2 extends UserServiceImplV1 {

	// V1 의 생성자 호출하기
	public UserServiceImplV2(UserDao userDao, PasswordEncoder pass) {
		super(userDao, pass);
	}

	@Override
	public UserVO login(UserVO userVO) {
		// Controller 에서 전달받은 로그인정보에서
		// username 과 password 를 추출.
		String username = userVO.getUsername();
		String password = userVO.getPassword();

		// username 으로 회원 DB 에서 데이터 Select
		UserVO joinUserVO = userDao.findById(username);

		// Select 한 데이터가 null 이면 username 이 없다.
		// 잘못입력했거나 아직 회원가입하지 않은 상태.
		// Select 한 데이터가 null 이 아니면 username 이 있다.
		
		if (joinUserVO != null) {
			// username 으로 조회한 데이터가 있으면
			// DB 에 저장된 password 와 입력한 password 와 비교.
			boolean bYes = pass.matches(password, joinUserVO.getPassword());
			
			// 비밀번호가 일치하지 않으면 null 값을 리턴.
			// if (!bYes)
			if (bYes == false)
				return null;
	}
		// 정상 로그인되면 joinUserVO 에는 사용자 정보데이터가 담기고
		// 그렇지 않으면 null 이 담겨있다.
		return joinUserVO;

}
}
