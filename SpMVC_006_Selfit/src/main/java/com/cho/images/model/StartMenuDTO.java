package com.cho.images.model;

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
public class StartMenuDTO {
	
	private String sc_id;
	private String sc_num;
	private String sc_label;
	private String sc_division;
	
	private String sc_day;
	private String sc_part;
}
