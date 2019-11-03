package com.zerock.mapper;

import java.util.*;

import com.zerock.command.BoardVO;

public interface BoardMapper {

	public void insert(BoardVO vo);
	//public void insert(Map<String, String> map);
	public ArrayList<BoardVO> select();
	public void delete(String num);
}
