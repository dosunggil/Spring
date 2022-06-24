package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.FileVO;
import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.FileDao;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.FileUpService;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemoServiceImplV1 implements MemoService{

	private final FileUpService fileService;
	private final FileDao fileDao;
	private final MemoDao memodao;
	public MemoServiceImplV1(MemoDao memodao, FileUpService fileService, FileDao fileDao) {
		this.memodao = memodao;
		this.fileService = fileService;
		this.fileDao = fileDao;
	}
	

	@Override
	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file) {
		int ret = memodao.insert(memoVO);
		log.debug("인써트 {}",ret);
		if(ret > 0) {
			try {
				String fileName = fileService.fileUp(file);
				FileVO fileVO = FileVO.builder()
						.f_originalName(fileName)
						.f_imageName(fileName)
						.f_mseq(memoVO.getM_seq())
						.build();
				fileDao.insert(fileVO);
				log.debug("시퀀스 확인하는 곳"+ memoVO.toString());
				return "OK";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.debug("FILE UP FAIL");
				return "FILE UP FAIL";
			}
		}
		return null;
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
		memodao.insert(vo);
		return 0;
	}

	@Override
	public int delete(Integer id) {
		fileDao.delete(id);
		memodao.delete(id);
		return 0;
	}

	@Override
	public int update(MemoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}



}
