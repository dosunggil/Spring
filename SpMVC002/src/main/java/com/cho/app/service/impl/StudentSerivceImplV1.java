package com.cho.app.service.impl;

import org.springframework.stereotype.Service;

import com.cho.app.domain.StudentVO;
import com.cho.app.service.StudentService;

@Service
public class StudentSerivceImplV1 implements StudentService {

	//TODO 학생 데이터를 추가하기
	@Override
	public int insert(StudentVO studentVO) {
		return 0;
	}

	//TODO 전체 데이터 가져오기
	@Override
	public StudentVO[] selectAll() {
		return null;
	}

	//TODO 학생 데이터 ID 로 조회하기
	@Override
	public StudentVO findById(String stNum) {
		return null;
	}
		
}
