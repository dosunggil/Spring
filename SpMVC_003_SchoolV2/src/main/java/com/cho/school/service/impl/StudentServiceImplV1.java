package com.cho.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cho.school.domain.StudentVO;
import com.cho.school.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService {

	// TODO Auto-generated method stub
	@Override
	public List<StudentVO> selectAll() {
List<StudentVO> stList = new ArrayList<>() ;
		
		StudentVO stVO = new StudentVO();
		
		stVO.setStNum("00001");
		stVO.setStName("도성길");
		stVO.setStDept("수학과");
		stVO.setIntGrade(3);
		stVO.setStAddr("광주광역시");
		stList.add(stVO);
		
		stVO = new StudentVO();
		
		stVO.setStNum("00002");
		stVO.setStName("박종훈");
		stVO.setStDept("토목공학과");
		stVO.setIntGrade(4);
		stVO.setStAddr("경기 화성시");
		stList.add(stVO);
		
		
		stVO = new StudentVO();
		
		stVO.setStNum("00003");
		stVO.setStName("장태근");
		stVO.setStDept("토목공학과");
		stVO.setIntGrade(4);
		stVO.setStAddr("전라남도 순천시");
		stList.add(stVO);
		
		stVO = new StudentVO();
		
		stVO.setStNum("00004");
		stVO.setStName("김남현");
		stVO.setStDept("경영학과");
		stVO.setIntGrade(4);
		stVO.setStAddr("서울특별시");
		stList.add(stVO);
		
		
		return stList;
	}

	@Override
	public StudentVO findByStNum(String stNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(StudentVO stVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(StudentVO stVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(String stNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentVO> findByStTel(String stTel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentVO> findByStName(String stName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentVO> findByStAddr(String stAddr) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
