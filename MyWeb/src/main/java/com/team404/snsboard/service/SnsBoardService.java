package com.team404.snsboard.service;

import java.util.ArrayList;

import com.team404.command.SnsBoardVO;

public interface SnsBoardService {

	public boolean insert(SnsBoardVO vo); //등록
	public ArrayList<SnsBoardVO> getList(); //목록
	public SnsBoardVO getDetail(int bno);//상세
	public boolean delete(int bno);//삭제
}
