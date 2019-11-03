package com.zerock.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.command.BoardVO;
import com.zerock.dao.BoardDAO;
import com.zerock.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	//-----------------------로우 매퍼------------------------
//	@Autowired
//	BoardDAO boardDAO;
//	//게시글 등록 메서드
//	public void register(String name, String title, String content) {
//		System.out.println("---service계층---");
//		System.out.println(name);
//		System.out.println(title);
//		System.out.println(content);
//		
//		boardDAO.boardInsert(name, title, content);
//		
//		
//	}
//	//게시물 List보기 메서드
//	@Override
//	public ArrayList<BoardVO> getList() {
//		
//		ArrayList<BoardVO> DB = boardDAO.boardSelect();
//		
//		return DB;
//	}
	
	//------------------마이 바티스-------------------------------
	
	@Autowired
	private BoardMapper mapper;
	
	
	public void register(String name, String title, String content) {
		//BoardMapper.java의 있는 추상 메서드와 맵핑됩니다.
		//매개 값을 여러개 전달할때 사용하는방법은 2가지 입니다.
		
		//1st 
		//커맨드객체 vo타입으로 전달
		//vo의변수명이 마이바티스 전달에 사용할 값이 됩니다 
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		mapper.insert(vo);
		
		//2st
		//Map타입을 이용
		//여러개의 값을 전달할 때는 Map에 사용할 key값이 마이바티스 전달에 사용할 값이 됩니다.
//		Map<String, String> map = new HashMap<>();
//		map.put("p1", name);
//		map.put("p2", title);
//		map.put("p3", content);
//		mapper.insert(map);
	}
	//게시물 List보기 메서드
	@Override
	public ArrayList<BoardVO> getList() {
		
		ArrayList<BoardVO> list = mapper.select();
		
		return list;
	}
	@Override
	public void delete(String num) {
		
		mapper.delete(num);
		
	}
}
