package com.cho.ems.service;

import com.cho.ems.model.EmsVO;
import com.cho.ems.model.UserVO;

public interface SendMailService {

	public void sendMail(EmsVO emsVO);
	public void sendMail(EmsVO emsVO, UserVO userVO);
	
}
