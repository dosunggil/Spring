package com.cho.naver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookVO {

	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String price;
	private String discount;
	private String description;
	private String pubdate;
	private String link;
	private String image;
	
}
