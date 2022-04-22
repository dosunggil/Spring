package com.cho.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cho.app.domain.StudentVO;
import com.cho.app.service.StudentService;

@Service
public class StudentSerivceImplV1 implements StudentService {
	// web application 에서는 Service 클래스의 클래스 영역에 변수를 선언하지 않는다.
	
	
	//TODO 학생 데이터를 추가하기
	@Override
	public int insert(StudentVO studentVO) {
		return 0;
	}

		
	//TODO 학생 데이터 ID 로 조회하기
	@Override
	public StudentVO findById(String stNum) {
		return null;
	}

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
		
		/*
		 * vo 데이터를 사용하여 새로운 학생정보를 list 에 추가하기 위해서는 
		 * stVO 변수를 다시 초기화해서 새로운 주소로 저장을 해야하는 작업.
		 */
		stVO = new StudentVO();
		
		stVO.setStNum("00002");
		stVO.setStName("박종훈");
		stVO.setStDept("수학과");
		stVO.setIntGrade(4);
		stVO.setStAddr("경기 화성시");
		stList.add(stVO);
		
		
		stVO = new StudentVO();
		
		stVO.setStNum("00003");
		stVO.setStName("장태근");
		stVO.setStDept("수학과");
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
		
}
