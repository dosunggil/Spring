package com.cho.ems.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmsVO {

	private long e_seq;
	private String e_from_email;

	@NotEmpty(message = "받는 사람 Email 은 반드시 입력하세요")
	private String e_to_email;
	
	@NotNull(message = "보내는 사람 이름은 NULL 일 수 없습니다")
	private String e_from_name;
	
	@Length(min = 1, max = 100, message = " 받는 사람 이름은 1 ~ 100 글자")
	@NotEmpty(message = "받는 사람 이름은 반드시 입력하세요")
	private String e_to_name;
	
	@NotEmpty(message = "제목을 입력해야 합니다.")
	private String e_subject;
	private String e_content;
	
	
	//@Size(min=1, max=10, message = "num 는 1 부터 10 사이의 정수이어야 합니다.")
	private String e_send_date;
	private String e_send_time;
	
	//@Min(value=1, message= "num 는 1 보다 커야합니다.")
	//@Max(value=10, message= "num 는 10 보다 작아야합니다.")
	private int num;
	
	//@DecimalMin(value="1" , message = "decimal 은 십진수 1보다 커야합니다.")
	//@DecimalMax(value="10" , message = "decimal 은 십진수 10보다 작아야합니다.")
	private int decimal;
	
	//@Pattern(regexp = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$")
	private String password;
	
}
