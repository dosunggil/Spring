package com.callor.memo.model;

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
public class MemoVO {
	private int m_seq 	;   //자동
	private String m_author;  // 자동 
	private String 	m_date 	; //체크
	private String m_time	; //체크
	private String m_title; // 입력
	private String m_memo	; // 입력
	private String m_image;	
	private String m_up_image;
	
}
