package com.cho.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cho.todo.model.AuthorVO;
import com.cho.todo.model.UserVO;
import com.cho.todo.persistence.UserDao;


/*
 * Spring security 에서 지원하는 UserDetailsService 를 상속받아
 * 클래스를 작성한다.
 */
@Service("uds")
public class UserDetailsServiceImplV1 implements UserDetailsService{

	private final UserDao userDao;
	


	public UserDetailsServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}



	/*
	 * DB 로부터 사용자 정보를 select 하여 사용자 정보가 있는지 검사
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDao.findById(username);
		/*
		 * 사용자 정보가 DB 에 없으면 exception 을 발생시켜서 Security 에게 알리기
		 */
		if(userVO == null) {
			throw new UsernameNotFoundException(username + " : 회원가입을 하세요.");
		};
		
		
		List<AuthorVO> authos = userDao.select_auths(username);
		if(authos.size() < 1) {
			throw new UsernameNotFoundException(String.format("[ %s ] 아무런 권한이 없습니다.", username));
		}
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		// 사용자의 권한 정보를 문자열에서 GrantedAuthority 객체로 변환하기
		for(AuthorVO authVO : authos) {
			grantList.add(new SimpleGrantedAuthority(authVO.getAuthority()));
		}
		
		//GrantedAuthoruty 객체로 변환된 ROLE 정보를 사용자 정보에 set
		userVO.setAuthorities(grantList);
		
		return userVO;
	}


}
