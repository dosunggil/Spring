package com.callor.memo.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.FileVO;
import com.callor.memo.persistance.FileDao;
import com.callor.memo.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileUpServiceImplV1 implements FileUpService {

	private final FileDao filedao;
	private final ResourceLoader resourceLoader;

	public FileUpServiceImplV1(ResourceLoader resourceLoader, FileDao filedao) {
		this.resourceLoader = resourceLoader;
		this.filedao = filedao;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		// 파일이 없으면 그냥 끝내기
		if (file == null) {
			log.debug("파일이 없어서 그냥 끝냈음");
			return null;
		}

		String upLoadPath = resourceLoader
				.getResource("/static/upload")
				.getURI().getPath();
		log.debug("업로드 패쓰" + upLoadPath);

		// 업로드한 파일 이름 추출
		String fileName = file.getOriginalFilename();

		// java.io.File
		File dir = new File(upLoadPath);

		// 만약에 서버에 /uplaod 폴더가 없으면
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

	@Autowired
	@Override
	public void create_file_table() {
		filedao.create_file_table();
		
	}

	@Override
	public List<FileVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileVO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(FileVO vo) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(FileVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FileVO findByMemoSeq(int m_seq) {
		filedao.findByMemoSeq(m_seq);
return null;
	}

}
