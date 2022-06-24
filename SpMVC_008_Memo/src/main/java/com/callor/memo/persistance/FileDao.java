package com.callor.memo.persistance;

import com.callor.memo.model.FileVO;

public interface FileDao extends GenericDao<FileVO, Integer> {

	public void create_file_table();
	
	public FileVO findByMemoSeq(int m_seq);
	
}
