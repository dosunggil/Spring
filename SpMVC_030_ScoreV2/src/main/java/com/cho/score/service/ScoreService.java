package com.cho.score.service;

import com.cho.score.model.ScoreUpdateVO;
import com.cho.score.persistence.ScoreDao;

public interface ScoreService extends ScoreDao{

	public int updateScore(String st_num, String[] sb_code, String[] sc_score);

	public int updateScore(ScoreUpdateVO score);
	
}
