package com.cho.app.service;

import java.util.List;

import com.cho.app.domain.StudentVO;

public interface StudentService {

	public int insert(StudentVO studentVO);

	public List<StudentVO> selectAll();

	// public StudentVO[] selectAll();
	public StudentVO findById(String stNum);
}
