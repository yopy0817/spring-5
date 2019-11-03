package com.zerock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zerock.command.ScoreVO;

@Repository
public class ScoreDAOImpl implements ScoreDAO{

	//DB라 가정
//	ArrayList<ScoreVO> DB = new ArrayList<>();
//
//	@Override //점수 입력 메서드
//	public void scoreInsert(ScoreVO vo) {
//		System.out.println("---DAO 계층---");
//		System.out.println(vo.getName());
//		System.out.println(vo.getEng());
//		System.out.println(vo.getKor());
//		System.out.println(vo.getMath());
//		
//		DB.add(vo); //DB 삽입
//		System.out.println("현재 게시물 수:" + DB.size());
//	}
//
//	@Override //점수 저장 결과 보기
//	public ArrayList<ScoreVO> scoreSelect() {
//		
//		return DB;
//	}
//
//	@Override //점수 삭제 메서드
//	public void scoreDelete(String num) {
//		
//		int index = Integer.parseInt(num);
//		DB.remove(index); //DB삭제
//	}
	
	//-------------------row mapper-------------------------
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void scoreInsert(ScoreVO vo) {
		
		String sql = "insert into score01(num, name, kor, eng, math) values(score01_seq.nextval ,?,?,?,?)";
		int result = jdbcTemplate.update(sql, new Object[] {vo.getName(), vo.getKor(),  vo.getEng(), vo.getMath() });
		System.out.println(result);
	}

	@Override
	public ArrayList<ScoreVO> scoreSelect() {
		
		String sql = "select * from score01";
		
		List<ScoreVO> list  = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<ScoreVO>() {

			@Override
			public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				//rowNum의 개수 만큼 반복
				ScoreVO vo = new ScoreVO();
				vo.setNum( rs.getInt("num"));
				vo.setName( rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng( rs.getString("eng"));
				vo.setMath(rs.getString("math"));
				
				return vo;
			}
		});

		return (ArrayList<ScoreVO>)list;
	}

	@Override
	public void scoreDelete(String num) {
		
		String sql = "delete from score01 where num = ?";
		jdbcTemplate.update(sql, new Object[] {num});
	}
}
