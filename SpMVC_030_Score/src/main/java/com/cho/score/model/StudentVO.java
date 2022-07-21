package com.cho.score.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVO {
	private String st_num;//	VARCHAR(5)		PRIMARY KEY,
	private String st_name;//	VARCHAR(20)	NOT NULL	,
	private String st_dept;//	VARCHAR(20)		,
	private int st_grade;//	INT		,
	private String st_tel;//	VARCHAR(15)	NOT NULL,	
	private String st_addr;//	VARCHAR(125)
	
	/*
	 * 학생정보와 성적정보를 같이 묶어서 처리할 경우
	 * 한 학생의 여러 성적을 한꺼번에 관리하기 위하여
	 * 학생정보에 성적리스트 칼럼을 추가한다.
	 */
	private List<ScoreVO> scoreList;

}
