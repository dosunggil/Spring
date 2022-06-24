package com.callor.memo.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemoServiceImplV1 implements MemoService {

	private final MemoDao memodao;
	private final ResourceLoader resourceLoader;

	public MemoServiceImplV1(MemoDao memodao, ResourceLoader resourceLoader) {
		this.memodao = memodao;
		this.resourceLoader = resourceLoader;
	}

	@Override
	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file) {

		try {
			String fileName = fileUp(file);
			memoVO.setM_image(fileName);
			memodao.insert(memoVO);
			log.debug("시퀀스 확인하는 곳" + memoVO.toString());
			return "OK";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("FILE UP FAIL");
			return "FILE UP FAIL";
		}

	}
	
	@Override
	public String updateMemoAndFile(MemoVO memoVO, MultipartFile file) {
		int seq = memoVO.getM_seq();
		try {
			String fileName = fileUp(file);
			memoVO.setM_image(fileName);
			memoVO.setM_seq(seq);
			memodao.update(memoVO);
			log.debug("업데이트 확인하는 곳" + memoVO.toString());
			return "OK";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("FILE UP FAIL");
			return "FILE UP FAIL";
		}
		
		
	}

	@Autowired
	@Override
	public void create_memo_table() {
		memodao.create_memo_table();
	}

	@Override
	public List<MemoVO> selectAll() {
		return memodao.selectAll();
	}

	@Override
	public MemoVO findById(Integer id) {

		return memodao.findById(id);
	}

	@Override
	public int insert(MemoVO vo) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		memodao.delete(id);
		return 0;
	}

	@Override
	public int update(MemoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		if (file == null) {
			log.debug("파일이 없어서 그냥 끝냈음");
			return null;
		}
		String upLoadPath = resourceLoader.getResource("/static/upload").getURI().getPath();
		log.debug("업로드 패쓰" + upLoadPath);

		String fileName = file.getOriginalFilename();

		File dir = new File(upLoadPath);

		if (!dir.exists()) {
			dir.mkdirs();
		}

		File upLoadFile = new File(upLoadPath, fileName);
		file.transferTo(upLoadFile);
		return fileName;
	}

	@Override
	public boolean fileDelete(String filename) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	

}
