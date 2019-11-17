package com.team404.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.ReplyPageVO;
import com.team404.command.ReplyVO;
import com.team404.reply.service.FreeReplyService;
import com.team404.util.Criteria;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired(required = false)
	@Qualifier("freeReply")
	private FreeReplyService freeReply;
	
	//등록작업(제이슨데이터로 처리하기 위해 RequestBody
	@RequestMapping("/new")
	@ResponseBody
	public int regist(@RequestBody ReplyVO vo) {
		
		int result = freeReply.regist(vo);
		System.out.println("댓글등록성공실패:" + result);
		
		return result;
	}
	
	//게시물 목록(URL의 형태로 매개값을 받기위해 PathVariable)
	/*
	@RequestMapping("/getReply/{bno}/{pageNum}")
	public ArrayList<ReplyVO> getList(
			@PathVariable("bno") int bno,
			@PathVariable("pageNum") int pageNum
			) {
		
		System.out.println(bno);
		System.out.println(pageNum);
		
		ArrayList<ReplyVO> list = freeReply.getList(bno);
		System.out.println(list.toString());
		
		return list;
	}
	*/
	@RequestMapping("/getReply/{bno}/{pageNum}")
	@ResponseBody
	public ReplyPageVO getList(
			@PathVariable("bno") int bno,
			@PathVariable("pageNum") int pageNum
			) {
		//ArrayList<ReplyVO> list = freeReply.getList(bno);
		//System.out.println(list.toString());
		
		//0. getList메서드는(cri, 게시글번호)매개변수로 받는다
		//1. getCount함수를 만든다
		//2. 2개의 데이터를 전달하기 위해 @Page어노테이션 사용
		//3. 댓글쿼리로 변경
		//3. ReplyPageVO 생성
		//2. 화면getList함수의 더보기 보이기 조건처리
		//3. 화면getList함수의 str을 전역변수로 선언
		//4. 더보기 클릭시 page번호를 getList함수로 전달
		Criteria cri = new Criteria(pageNum, 20);//pageNum전달, 20개씩처리
		ReplyPageVO vo = freeReply.getList(cri, bno); //더보기 리스트
		System.out.println(vo.toString());
		
		
		return vo;
	}
	
	
	//게시물 삭제
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(@RequestBody ReplyVO vo) {
		System.out.println(vo.toString());//확인
		
		int result = freeReply.pwCheck(vo);//비밀번호가 맞다면 1, 같지 않다면 0이 리턴된다
		System.out.println("성공실패:" + result);
		
		if(result == 1) {
			return freeReply.delete(vo);
		} else {
			return 0;
		}

	}
	//수정처리
	@RequestMapping("/update")
	@ResponseBody
	public int update(@RequestBody ReplyVO vo) {
		System.out.println(vo.toString());//확인
		
		int result = freeReply.pwCheck(vo);
		System.out.println("성공실패:" + result);
		
		if(result == 1) {
			return freeReply.update(vo);
		} else {
			return 0;
		}
	}
	
	
	
	
	
	
	
	
}
