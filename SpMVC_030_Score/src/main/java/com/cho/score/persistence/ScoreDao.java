package com.cho.score.persistence;

import java.util.List;

import com.cho.score.model.ScoreVO;

public interface ScoreDao extends GenericDao<ScoreVO, Long>{
	public List<ScoreVO> findByStNum(String sc_stnum);
	
}
