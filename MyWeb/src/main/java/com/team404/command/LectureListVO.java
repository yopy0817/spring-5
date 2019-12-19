package com.team404.command;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LectureListVO {
	
	private int lecNo;
	private int lecListNo;
	private String lecListName;
	private String lecListComment;
	private int likes;
	private int bookMark;
	private Timestamp regdate;
}
