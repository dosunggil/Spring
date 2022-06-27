package com.callor.memo.persistance;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;

public interface MemoDao extends GenericDao<MemoVO, Integer> {

	public void create_memo_table();
	public int insertAndUpdate(MemoVO memo, MultipartFile file) ;

}
