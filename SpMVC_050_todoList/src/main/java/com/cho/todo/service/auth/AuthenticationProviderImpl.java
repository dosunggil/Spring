package com.cho.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cho.todo.model.UserVO;

@Service("authenticationProvider")
public class AuthenticationProviderImpl implements AuthenticationProvider{

	
	@Qualifier("uds")
	private UserDetailsService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public AuthenticationProviderImpl(@Qualifier("uds") UserDetailsService userService) {
		this.userService = userService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		// UserDetailsServce 에서 username 을 조회를 하여
		// DB table 로 부터 가져온 user 정보를 user 객체에 받기
		// 만약 username 에 해당하는 데이터가 없으면
		// UserDetailsService 에서 exception 이 발생하므로
		// 더 이상의 절차없이 다시 로그인 화면으로 돌아간다.
		UserVO user = (UserVO) userService.loadUserByUsername(username);
		
		/*
		 * 입력된 비밀번호와 DB 로부터 select 한 비밀번호를 
		 * passwordEncoder 를 사용하여 비교
		 */
		if(passwordEncoder.matches(password, user.getPassword()) == false) {
			throw new BadCredentialsException("비밀번호가 잘못되었습니다.");
			
		}
		if(user.isEnabled() == false) {
			throw new BadCredentialsException(username + "은 회원가입 절차가 완료되지 않음.");
		}
		
		// 정상적으로 사용자가 로그인하면
		// 인증 token 
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password,user.getAuthorities());
		
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
