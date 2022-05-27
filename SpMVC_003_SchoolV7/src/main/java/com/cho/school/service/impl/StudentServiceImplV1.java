package com.cho.school.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cho.school.model.StudentVO;
import com.cho.school.pesistance.StudentDao;
import com.cho.school.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService{

	private final StudentDao stDao;
	public StudentServiceImplV1(StudentDao stdao) {
		this.stDao = stdao;
	}
	
	public List<StudentVO> selectAll() {
		List<StudentVO> stList = stDao.selectAll();
		
		return stList;
	}

	@Override
	public StudentVO findById(String id) {
		return stDao.findById(id);
		
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
