package com.cho.score.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SubjectVO {
	private String sb_code;//	VARCHAR(5)	NOT NULL	PRIMARY KEY,
	private String sb_name;//	VARCHAR(25)	NOT NULL
}
