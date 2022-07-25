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
		return studentDao.findById(id);
	}

	@Override
	public int insert(StudentVO vo) {
		return studentDao.insert(vo);
	}

	@Override
	public int delete(String id) {
		studentDao.delete(id);
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		int ret = studentDao.update(vo);
		return ret;
	}

}
