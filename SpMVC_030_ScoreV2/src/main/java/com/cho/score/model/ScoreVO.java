package com.cho.score.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ScoreVO {
	private long sc_seq;//	BIGINT PRIMARY KEY auto_increment,
	private String sc_stnum;//	VARCHAR(5)	NOT NULL	,
	private String sc_sbcode;//	VARCHAR(5)	NOT NULL	,
	private int sc_score;//	int,
	
	private String sb_code;//	VARCHAR(5)	NOT NULL	PRIMARY KEY,
	private String sb_name;//	VARCHAR(25)	NOT NULL
	
}
