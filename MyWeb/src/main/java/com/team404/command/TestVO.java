package com.team404.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //모든값 초기화 생성자
@NoArgsConstructor //기본생성자
public class TestVO {

	private int num;
	private String name;
	private String id;
}
