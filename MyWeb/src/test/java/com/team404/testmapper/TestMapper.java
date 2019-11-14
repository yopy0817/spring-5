package com.team404.testmapper;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;
import com.team404.util.Criteria;

public interface TestMapper {

	public String getTime(); //테스트
	public ArrayList<FreeBoardVO> getPaging(); //페이징
	public ArrayList<FreeBoardVO> getList(Criteria cri); //페이징 쿼리
}
