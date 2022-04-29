package com.cho.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cho.school.dao.StudentDao;
import com.cho.school.domain.StudentVO;
import com.cho.school.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService {

	private final StudentDao stDao;

	public StudentServiceImplV1(StudentDao stDao) {
		this.stDao = stDao;
	}

	// TODO Auto-generated method stub
	@Override
	public List<StudentVO> selectAll() {

		return stDao.selectAll();
	}

	@Override
	public StudentVO findByStNum(String stNum) {
		// TODO Auto-generated method stub
		System.out.println(stDao.findByNum(stNum));
		return stDao.findByNum(stNum);
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
