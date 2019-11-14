package com.team404.reply.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.ReplyPageVO;
import com.team404.command.ReplyVO;
import com.team404.reply.mapper.FreeReplyMapper;
import com.team404.util.Criteria;

@Service("freeReply")
public class FreeReplyServiceImpl implements FreeReplyService {
	
	@Autowired
	private FreeReplyMapper mapper;
	
	
	@Override
	public int regist(ReplyVO vo) {
		
		return mapper.regist(vo);
	}

	//댓글 가져오기
	/*
	@Override
	public ArrayList<ReplyVO> getList(int bno) {
				
		return mapper.getList(bno);
	}
	*/
	//더보기
	@Override
	public ReplyPageVO getList(Criteria cri, int bno) {
		/*
		HashMap<String, Integer> maps = new HashMap<>();
		maps.put("bno", bno);
		maps.put("pageNum", cri.getPageNum());
		maps.put("amount", cri.getAmount());
		*/
		int replyCount = mapper.getCount(bno);
		ArrayList<ReplyVO> list = mapper.getList(cri, bno);
		
		//댓글개수와, 목록을 담을 VO생성
		ReplyPageVO vo = new ReplyPageVO(replyCount, list);
		
		return vo;
	}
	
	//비밀번호 체크
	@Override
	public int pwCheck(ReplyVO vo) {
		
		return mapper.pwCheck(vo);
	}
	//댓글삭제
	@Override
	public int delete(ReplyVO vo) {
		
		return mapper.delete(vo);
	}

	//댓글수정
	@Override
	public int update(ReplyVO vo) {

		return mapper.update(vo);
	}


	

}
