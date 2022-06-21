package com.cho.naver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BuyBookVO {
	private String b_isbn;
	private String b_username;
	private String b_date;
	
	
	/*
	 * recipeVO 에서 manualVO 를 담는 것도 이렇게한다.
	 * mapper 에서는 manual_num 순으로 order by 해서 저장하자
	 * 그 후에 보여주기 하면 리스트가 순서대로 저장되기때문에 씨된다.
	 * 
	 */
	private BookVO book;
	private UserVO user;
}
