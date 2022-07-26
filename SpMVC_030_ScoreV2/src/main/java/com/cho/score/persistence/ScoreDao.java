package com.cho.score.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cho.score.model.ScoreVO;

public interface ScoreDao extends GenericDao<ScoreVO, Long>{
	public List<ScoreVO> findByStNum(String sc_stnum);
	public int updateScore(
			@Param("st_num") String st_num,
			@Param("sb_code") String sb_code,
			@Param("sc_score") String sc_score);
	
}
