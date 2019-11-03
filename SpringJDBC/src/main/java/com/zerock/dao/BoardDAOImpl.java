package com.zerock.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zerock.command.BoardVO;


//DAO의 객체주입은 일반적으로  Component나, Repository 어노테이션을 사용합니다
//해당 어노테이션은 컨테이너에 객체를 생성해 달라는 표시 입니다
//component-scan에 꼭 추가해줘야 합니다

//@Component 
@Repository
public class BoardDAOImpl implements BoardDAO{
	
	//component-scan 추가확인요망 (한글 필터 확인)
	/*
	create table board01(
	    num number(10,0) CONSTRAINT board01_pk PRIMARY key,
		name varchar(30),
	    title varchar(30),
	    content varchar(50)
	);
    create SEQUENCE board01_seq;
    
	*/
//	private String url = "jdbc:mysql://localhost:3306/spring?serverTimezone=UTC"; //6.x버전 이상부터 servertime설정
//	private String uid = "spring"; 
//	private String upw = "spring"; 
//	
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
//	
//	
//	@Override
//	public void boardInsert(String name, String title, String content) {
//		
//		String sql = "insert into board01(b_name, b_title, b_content) values(?,?,?)";
//	
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(url, uid, upw);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			pstmt.setString(2, title);
//			pstmt.setString(3, content);
//			pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(conn != null) conn.close();
//				if(pstmt != null) pstmt.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//	}
//
//	@Override
//	public ArrayList<BoardVO> boardSelect() {
//		ArrayList<BoardVO> list = new ArrayList<>();
//		
//		String sql = "select * from board01 order by b_num asc";
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(url, uid, upw);
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				int num= rs.getInt("b_num");
//				String name = rs.getString("b_name");
//				String title= rs.getString("b_title");
//				String content = rs.getString("b_content");
//				
//				BoardVO vo = new BoardVO(num, name, title, content);
//				list.add(vo);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(conn != null) conn.close();
//				if(pstmt != null) pstmt.close();
//				if(rs != null) rs.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return list;
//	}
	
	//------------Spring RowMapper를 이용하여 코드 변경해보기---------
	
//	빈설정없이 하는법
//	private DriverManagerDataSource dataSource;
//	private JdbcTemplate jdbcTemplate;
//	
//	public BoardDAOImpl() {
//		dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
//		dataSource.setUsername("spring");
//		dataSource.setPassword("spring");
//		
//		jdbcTemplate = new JdbcTemplate();
//		jdbcTemplate.setDataSource(dataSource);
//	}

	
//	root-context.xml에 설정후 주입
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public void boardInsert(String name, String title, String content) {
		//System.out.println(jdbcTemplate);
		
		String sql = "insert into board01(num ,name, title, content) values(board01_seq.nextval,?,?,?)";
		/*
		//1st
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
				ps.setString(2, title);
				ps.setString(3, content);
			}
		});
		System.out.println("결과조회(성공:1, 실패:0) :" + result);
		*/
		
		//2nd
		//update() 메서드의 파라미터 값으로 (sql문, ?표에 바인딩할 값)
		int result = jdbcTemplate.update(sql, new Object[] {name, title, content});
		System.out.println(result);
	}

	@Override
	public ArrayList<BoardVO> boardSelect() {
		/*
		 * query()의 파라미터의 의미
		 * sql : sql쿼리, ?를 사용하는 preparedStatement용 쿼리를 사용
		 * new Object[] {값,값} : sql물음표에 셋팅할 값을 저장한다(바인딩)
		 * new RowMapper<Type>() : 조회 결과 ResultSet으로 부터 데이터를 읽어와 Type데이터를 생성
		 *		-> 익명클래스로 사용합니다
		 *		-> mapRow() 메서드는 ResultSet에서 읽어온 값을 처리한후 리턴합니다
		 */	
		//2nd
		String sql = "select * from board01";
		
		
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				return vo;
			}

			
		});
		
		return (ArrayList<BoardVO>)list;
	}
}