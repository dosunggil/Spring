package com.cho.app.service;

import com.cho.app.domain.StudentVO;

public interface StudentService {

	public int insert(StudentVO studentVO);
	public StudentVO[] selectAll();
	public StudentVO findById(String stNum);
}
