package com.team404.command;

import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.Data;

@Data
public class LectureVO {

	private int lecNo;
	private String lecName;
	private Timestamp lecRegdate;
	
	//하위목록
	private ArrayList<LectureListVO> lectureListVO;
}
