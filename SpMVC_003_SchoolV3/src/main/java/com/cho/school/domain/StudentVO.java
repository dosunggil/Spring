package com.cho.school.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor; //기본생성
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StudentVO {

	// 추상화
	private String stNum; // 학번
	private String stName; // 이름
	private int intGrade; // 학년
	private String stTel; // 전화번호
	private String stAddr; // 주소
	private String stDept; // 전공

	
}
