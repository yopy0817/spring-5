package com.team404.lecture.mapper;

import com.team404.command.LectureListVO;
import com.team404.command.LectureVO;

public interface LectureMapper {
	
	public LectureVO getLectureList(int lecNo); //강의목록
	public LectureListVO getDetail(int lecListNo); //강의내용
}
