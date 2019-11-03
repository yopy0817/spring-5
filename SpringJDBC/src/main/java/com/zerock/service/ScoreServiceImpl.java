package com.zerock.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zerock.command.ScoreVO;
import com.zerock.dao.ScoreDAO;
import com.zerock.mapper.ScoreMapper;

//@Component
//@Component("scoreService")
//@Repository

//@Service
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
	
//	//----------------------DAO들어가기(quiz:DAO로 변경해보세요)-----------------------------

//	@Autowired
//	private ScoreDAO scoreDAO;
//	
//	@Override
//	public void scoreRegist(ScoreVO vo) {
//		System.out.println("---서비스 계층---");
//		System.out.println(vo.getName());
//		System.out.println(vo.getEng());
//		System.out.println(vo.getKor());
//		System.out.println(vo.getMath());
//		
//		scoreDAO.scoreInsert(vo); //점수 입력메서드 호출
//	}
//	
//	//점수 저장 결과 보기
//	@Override
//	public ArrayList<ScoreVO> scoreReesult() {
//		
//		ArrayList<ScoreVO> DB = scoreDAO.scoreSelect(); //점수 결과 메서드 호출
//		return DB;
//	}
//
//	//점수 삭제 메서드
//	@Override
//	public void scoreDelete(String num) {
//		
//		scoreDAO.scoreDelete(num); //점수 삭제 메서드 호출
//	}
	
	//-----------------------마이 바티스---------------------------
	//DAO클래스를 mybatis의 xml로 대신합니다
	
	//mapper인터페이스의 선언과 자동객체 주입
	@Autowired
	private ScoreMapper mapper;
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		//BoardMapper.java의 있는 추상 메서드와 맵핑됩니다.
		//매개 값을 여러개 전달할때 사용하는방법은 2가지 입니다.
		
		//1st(커맨드 이용)
		boolean result = mapper.insert(vo);
		System.out.println("insert결과" + result);
		
		//2nd(Map타입을 이용)
		//여러개의 값을 전달할 때는 Map에 사용할 key값이 마이바티스 전달에 사용할 값이 됩니다.
//		Map<String, String> map = new HashMap<>();
//		map.put("name", vo.getName());
//		map.put("kor", vo.getKor());
//		map.put("eng", vo.getEng());
//		map.put("math", vo.getMath());
//		mapper.insert(map);
	}

	//점수 저장 결과 보기
	@Override
	public ArrayList<ScoreVO> scoreReesult() {
		ArrayList<ScoreVO> list = mapper.select();
		
		return list;
	}

	//점수 삭제 메서드
	@Override
	public void scoreDelete(String num) {
		
		mapper.delete(num);
	}

}
