package com.cho.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cho.todo.model.UserVO;

@Service("authenticationProvider")
public class AuthorProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		if (username.equals("dosunggil") == false) {
			throw new UsernameNotFoundException("username 오류");
		}
		if (password.equals("!aa1234") == false) {
			throw new BadCredentialsException("비밀번호 오류");
		}
		
		UserVO userVO = UserVO.builder()
						.username(username)
						.password(password)
						.email("email")
						.realname("조도성")
						.nickname("도성길").build();
		List<GrantedAuthority> grantList = new ArrayList<>();
		grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));

		// 사용자 이름과 비번, 권한 리스트로 Token 발행
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userVO, null,
				grantList);
		return token;
	}

	/*
	 * security 에서 인증절차를 수행하기 위하여 AuthenticationProvider 를 상속받으면 반드시 supports 를
	 * true로 설정해야 한다.
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
