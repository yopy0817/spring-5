package com.team404.frboard.service;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;
import com.team404.util.Criteria;

public interface FreeBoardService {

	public void regist(FreeBoardVO vo);//게시판 등록
	//public ArrayList<FreeBoardVO> getList();//게시글 조회
	
	//public ArrayList<FreeBoardVO> getList(Criteria cri);//페이징
	//public int getTotal(); //총게시글 수
	
	public ArrayList<FreeBoardVO> getList(Criteria cri);//페이징
	public int getTotal(Criteria cri); //총게시글 수
	
	public FreeBoardVO content(int bno); //상세화면 조회
	public boolean update(FreeBoardVO vo); //게시글 수정
	public boolean delete(int bno); //게시글 삭제
}
