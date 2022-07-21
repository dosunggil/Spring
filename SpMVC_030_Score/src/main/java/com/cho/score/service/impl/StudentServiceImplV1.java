package com.cho.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cho.score.model.StudentVO;
import com.cho.score.persistence.StudentDao;
import com.cho.score.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService {

	private StudentDao studentDao;

	public StudentServiceImplV1(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<StudentVO> selectAll() {
		return studentDao.selectAll();
	}

	@Override
	public StudentVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
