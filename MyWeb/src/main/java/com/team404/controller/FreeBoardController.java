package com.team404.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.FreeBoardVO;
import com.team404.frboard.service.FreeBoardService;
import com.team404.util.Criteria;
import com.team404.util.PageVO;

import lombok.Setter;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired(required = true)
	@Qualifier("freeBoard")
	private FreeBoardService freeBoard;
	
	
	
	//게시판 등록 요청
	@RequestMapping(value="/freeRegist" , method = RequestMethod.GET)
	public String freeRegist() {
		
		return "freeBoard/freeRegist";
	}
	//게시판 화면 요청
	@RequestMapping(value="/freeList" , method = RequestMethod.GET)
	public String freeList(Model model, Criteria cri) {
		//일반
		//ArrayList<FreeBoardVO> list = freeBoard.getList();
		//model.addAttribute("boardList", list);
		//기본페이징		
		//ArrayList<FreeBoardVO> list = freeBoard.getList(cri);
		//int total = freeBoard.getTotal(); //토탈 구함
		//PageVO page = new PageVO(cri, total); //페이징계산
		//검색페이징
		ArrayList<FreeBoardVO> list = freeBoard.getList(cri);
		int total = freeBoard.getTotal(cri); //토탈 구함
		PageVO page = new PageVO(cri, total); //페이징계산
		
		model.addAttribute("boardList", list);
		model.addAttribute("pageVO", page);
		
		return "freeBoard/freeList";
	}
	
	//게시글 등록 요청
	@RequestMapping("/registForm")
	public String registForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		freeBoard.regist(vo);
		
		//1회성 사용후 소멸데이터로 리다이렉트시 한번만 보내주고 싶을 때, RedirectAttributes전달자를 사용가능
		RA.addFlashAttribute("msg", "게시물이 정상적으로 등록 되었습니다");
		
		//다시 컨트롤러를 태우는 기능 redirect:/
		return "redirect:/freeBoard/freeList";
	}
	
//	//게시판 상세보기 요청
//	@RequestMapping(value="/freeDetail" , method = RequestMethod.GET)
//	public String freeDetail(@RequestParam("bno") int bno, Model model ) {
//		
//		FreeBoardVO vo = freeBoard.content(bno);
//		model.addAttribute("boardVO", vo);
//		
//		return "freeBoard/freeDetail";
//	}
//	//게시판 수정화면 요청
//	@RequestMapping(value="/freeModify" , method = RequestMethod.GET)
//	public String freeModify(@RequestParam("bno") int bno, Model model) {
//		
//		FreeBoardVO vo = freeBoard.content(bno);	
//		model.addAttribute("boardVO", vo);
//		
//		return "freeBoard/freeModify";
//	}
	
	//게시판 상세보기, 수정화면 요청 (동일한 기능이라면 이렇게 묶어서 사용할 수 있습니다)
	@RequestMapping(value = {"/freeDetail", "/freeModify" })
	public void contentModify(@RequestParam("bno") int bno, Model model) {
		
		FreeBoardVO vo = freeBoard.content(bno);	
		model.addAttribute("boardVO", vo);
		//void형 메서드는 요청받은 경로를 리졸버 뷰에 전달합니다.
	}
	
	//게시글 수정요청
	@RequestMapping(value = "/freeUpdate")
	public String freeUpdate(FreeBoardVO vo, RedirectAttributes RA) {
		
		boolean bool = freeBoard.update(vo);
		if(bool) {
			RA.addFlashAttribute("msg", "게시물 수정이 정상 처리되었습니다");
		} else {
			RA.addFlashAttribute("msg", "게시물 수정에 실패했습니다");
		}
				
		return "redirect:/freeBoard/freeList";
	}
	
	//게시글 삭제
	@RequestMapping(value = "/freeDelete")
	public String freeDelete(@RequestParam("bno") int bno, RedirectAttributes RA) {
		

		boolean bool = freeBoard.delete(bno);
		
		if(bool) {
			RA.addFlashAttribute("msg", "게시글이 삭제 되었습니다");
		} else {
			RA.addFlashAttribute("msg", "게시글 삭제에 실패했습니다");
		}
		return "redirect:/freeBoard/freeList";
	}
	
	
	
}
