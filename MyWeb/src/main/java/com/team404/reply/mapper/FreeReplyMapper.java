package com.team404.reply.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.team404.command.ReplyVO;
import com.team404.util.Criteria;

public interface FreeReplyMapper {

	public int regist(ReplyVO vo);//등록
	//public ArrayList<ReplyVO> getList(int bno); //댓글목록
	public ArrayList<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") int bno); //더보기
	public int getCount(int bno); //게시판별 댓글수 확인
	
	public int pwCheck(ReplyVO vo); //비밀번호 확인
	public int delete(ReplyVO vo); //댓글 삭제
	public int update(ReplyVO vo); //댓글 수정
}
