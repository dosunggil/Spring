package com.cho.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cho.score.model.ScoreVO;
import com.cho.score.persistence.ScoreDao;
import com.cho.score.service.ScoreService;

@Service
public class ScoreServiceImplV1 implements ScoreService {

	private ScoreDao scoreDao;
	public ScoreServiceImplV1(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	public List<ScoreVO> findByStNum(String sc_stnum) {
		return scoreDao.findByStNum(sc_stnum);
	}
	
	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateScore(String st_num, String sb_code, String sc_score) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateScore(String st_num, String[] sb_code, String[] sc_score) {
		int ret = 0;
		for(int i = 0 ; i < sb_code.length ; i++) {
			ret += scoreDao.updateScore(st_num, sb_code[i], sc_score[i]);
		}
		return ret;
	}

}
