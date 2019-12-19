package com.team404.lecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.LectureListVO;
import com.team404.command.LectureVO;
import com.team404.lecture.mapper.LectureMapper;

@Service("lectureService")
public class LectureServcieImpl implements LectureService{

	@Autowired
	private LectureMapper lectureMapper;

	@Override
	public LectureVO getLectureList(int lecNo) {
				
		return lectureMapper.getLectureList(lecNo);
	}

	@Override
	public LectureListVO getDetail(int lecListNo) {
		
		return lectureMapper.getDetail(lecListNo);
	}

	
	
}
