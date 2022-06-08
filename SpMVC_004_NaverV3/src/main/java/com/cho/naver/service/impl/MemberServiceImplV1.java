package com.cho.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cho.naver.model.MemberVO;
import com.cho.naver.service.MemberService;
@Service("memberServiceV1")
public class MemberServiceImplV1 implements MemberService{

	@Override
	public List<MemberVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findByEmailAndTel(String email, String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
