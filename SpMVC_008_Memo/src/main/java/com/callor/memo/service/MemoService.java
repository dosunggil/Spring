package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;

public interface MemoService extends MemoDao {
	
	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file);
	public String updateMemoAndFile(MemoVO memoVO, MultipartFile file);

	public String fileUp(MultipartFile file);
	public void fileDelete(String filename) ;
}
