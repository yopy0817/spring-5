package com.team404.frboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.frboard.mapper.FreeBoardMapper;
import com.team404.util.Criteria;

//설정파일에 컴포넌트 스캔 추가
//마이바티스 매핑명령 반드시 추가
@Service("freeBoard")
public class FreeBoardServiceImpl implements FreeBoardService{
	
	//롬복꺼 ( _를 써야함)
	//@Setter(onMethod_ = @Autowired)
	@Autowired
	private FreeBoardMapper mapper;
	
	
	@Override
	public void regist(FreeBoardVO vo) {
		
		mapper.regist(vo);
	}
 
	//게시글 조회
//	@Override
//	public ArrayList<FreeBoardVO> getList() {
//		return mapper.getList();
//	}
	
	@Override
	public FreeBoardVO content(int bno) {
		
		return mapper.content(bno);
	}

	@Override
	public boolean update(FreeBoardVO vo) {
			
		boolean bool = mapper.update(vo);
		System.out.println("성공실패:" + bool);
		
		return bool;
	}

	@Override
	public boolean delete(int bno) {
		
		
		
		return mapper.delete(bno);
	}
	
	//페이징
	@Override
	public ArrayList<FreeBoardVO> getList(Criteria cri) {
		
		//반드시 찍어서 로그를 확인한다
		System.out.println(cri.toString());
		
		return mapper.getList(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotal(cri);
	}


}
