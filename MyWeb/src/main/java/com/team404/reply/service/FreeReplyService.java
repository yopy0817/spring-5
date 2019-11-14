package com.team404.reply.service;


import com.team404.command.ReplyPageVO;
import com.team404.command.ReplyVO;
import com.team404.util.Criteria;

public interface FreeReplyService {

	public int regist(ReplyVO vo); //댓글등록
	//public ArrayList<ReplyVO> getList(int bno); //댓글 목록
	public ReplyPageVO getList(Criteria cri, int bno); //더보기
	
	public int pwCheck(ReplyVO vo); //비밀번호체크
	public int delete(ReplyVO vo); //댓글삭제
	public int update(ReplyVO vo); //댓글수정
}
