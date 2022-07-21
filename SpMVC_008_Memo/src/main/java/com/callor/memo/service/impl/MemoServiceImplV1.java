package com.callor.memo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
	private final String upPath;

	public MemoServiceImplV1(String upPath, MemoDao memodao) {
		this.memodao = memodao;
		this.upPath = upPath;
	}

	// insert 와 update 를 동시에 처리
	@Override
	public int insertAndUpdate(MemoVO memo, MultipartFile file)   {
		int m_seq = memo.getM_seq();
		
		// update 일 경우
		if(m_seq != 0 ) {
			
			MemoVO updateMemo = memodao.findById(m_seq);
			String fileName = updateMemo.getM_image();
			
			// 저장된 파일 이름과 새롭게 업로드된 파일 이름이 다르면
			// 첫 번째는 업로드한 파일이 있으면
			if(!( file.getOriginalFilename().equals("") || (fileName.equals(file.getOriginalFilename() ) ) ) ){
				//기존의 파일을 삭제하고
				fileDelete(updateMemo.getM_up_image());
			}
			
			/*
			 * 업로드하는 파일이 없으면 기존 파일 계승
			 */
			if(file.getOriginalFilename().equals("")) {
				String file1 = updateMemo.getM_image();
				String file2 = updateMemo.getM_up_image();
				
				memo.setM_image(file1);
				memo.setM_up_image(file2);
				return memodao.update(memo);
			}
		
			
			
			// 파일을 업로드하고
			// 업로드된 파일 이름 가져오기
			String upLoadFileName = fileUp(file);
			
			// table 에 저장하기 위하여
			// 원래 파일 이름과 UUID 가 부착된 파일 이름을 VO에 저장
			memo.setM_image(file.getOriginalFilename());
			memo.setM_up_image(upLoadFileName);
		
			return memodao.update(memo);
		}
		memo.setM_image(file.getOriginalFilename());
		memo.setM_up_image(fileUp(file));
	
		
		return memodao.insert(memo);
	
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
	public String fileUp(MultipartFile file) {
		if (file == null) {
			log.debug("파일이 없어서 그냥 끝냈음");
			return null;
		}
		File dir = new File(upPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String fileName = file.getOriginalFilename();
		String strUUID = UUID.randomUUID().toString();

		fileName = String.format("%s-%s", strUUID, fileName);
		File upLoadFile = new File(upPath,fileName);
		
		try {
			file.transferTo(upLoadFile);
			return fileName;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void  fileDelete(String fileName) {
		if(fileName == null) {
			return;
		}
		
		// 업로드 폴더와 파일이름묶어 파일 객체 생성
		File deleteFile = new File(upPath, fileName);
		
		// 실제 파일이 존재하는 확인하고
		if(deleteFile.exists()) {
			// 존재하면 파일을 삭제
			deleteFile.delete();
		}
	}

	

}
