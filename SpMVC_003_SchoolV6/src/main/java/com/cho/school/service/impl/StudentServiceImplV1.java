package com.cho.school.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cho.school.dao.StudentDao;
import com.cho.school.model.StudentVO;
import com.cho.school.service.StudentService;

import lombok.extern.slf4j.Slf4j;

/*
 * StudentService stService = new StudetServiceImplV1
 */
@Slf4j
@Service("stServiceV1")
public class StudentServiceImplV1 implements StudentService{

	
	
	/*
	 * 생성자 주입
	 */
	private final StudentDao stDao;
	public StudentServiceImplV1(StudentDao stDao) {
		this.stDao = stDao;
	}
	
	@Override
	public List<StudentVO> selecAll() {
		return stDao.selecAll();
	}

	@Override
	public StudentVO findByNum(String st_num) {
		return stDao.findByNum(st_num);
	}

	@Override
	public int insert(StudentVO stVO) {
		int count = stDao.insert(stVO);
		return count;
	}

	@Override
	public int update(StudentVO stVO) {
		int count = stDao.update(stVO);
		return count;
	}

	@Override
	public int delete(String st_num) {
		int count = stDao.delete(st_num);
		return count;
	}
}