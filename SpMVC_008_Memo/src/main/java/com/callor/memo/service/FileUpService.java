package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.persistance.FileDao;

public interface FileUpService extends FileDao {

	public String fileUp(MultipartFile file) throws Exception;
	
	public boolean fileDelete(String filename) throws Exception;
}
