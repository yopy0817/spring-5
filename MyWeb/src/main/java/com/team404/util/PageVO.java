package com.team404.util;

import lombok.Data;

@Data //게터세터 자동생성
public class PageVO {
	/*
	//해당 쿼리 반드시 rn 엘리어스 써야함
	select * 
	from (select rownum as rn, bno, writer, title, content, regdate, updatedate
	      from (select * 
	            from freeboard 
	            order by bno desc
	            )
	) where rn > 0 and rn <= 10;
	*/
	private int startPage; //게시판 화면에 보여질 첫페이지 번호
	private int endPage; //게시판 화면에 보여질 끝페이지 번호
	private boolean prev; //다음 이전 활성화 여부
	private boolean next;
	
	private int pageNum; //현재 조회하는 페이지 번호
	private int amount; //한 페이지에서 몇개의 데이터를 보여줄건가
	private int total; //총 계시물 수
	
	private Criteria cri;
	
	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total; //전체게시글 수
		this.pageNum = cri.getPageNum(); //현재 조회하는 페이지 번호
		this.amount = cri.getAmount(); //한 페이지에서 몇개의 데이터를 보여줄건가
		
		//끝페이지 계산
		//현재 조회하고 있는 페이지가 11번이다 -> 화면에 보여질 끝 페이지 20
		//현재 조회하고 있는 페이지가 5번이다 -> 화면에 보여질 끝 페이지 10
		//공식: (int)Math.ceil( 페이지번호 / 10.0) * 10;
		//공식: (int)Math.ceil( 페이지번호 / (double)한번에 보여질 페이지 수) * 한번에 보여질 페이지 수
		this.endPage = (int)(Math.ceil(this.pageNum / 10.0)  ) * 10;

		//시작 페이지
		//공식: endPage - 한번에 보여질 페이지 개수  + 1
		this.startPage = endPage - 10 + 1; 

		//실제 마지막 페이지 번호.
		//만약 총 게시물이 52개 밖에 없다면? -> 페이지 번호는 6까지 표시 되어야 함
		//만약 총 게시물이 81개 밖에 없다면? -> 페이지번호는 9까지 표시 되어야함
		//만약 총 게시물이 105개 라면? -> 페이지 번호는 11까지 표시 되어야함
		//11번 클릭시 -> endPage에 공식으로 가면 -> 11,12,13,14...20 이 보이게됨

		//실제 보여져야 하는 끝번호를 구해서 비교
		//공식:실제끝번호 = 전체 게시글 수/페이지에 보여지는 데이터 수 (올림한다)
		int realEnd = (int)Math.ceil(total / (double)this.amount );

		
		//ex: 131개의 게시물
		//1번 페이지 클릭시 -> endPage의 공식은 = 10, realEnd = 14 
		//실제 화면에 보여져야하는 번호 = 10
		//11번페이지 클릭시 -> endPage의 공식은 = 20, realEnd = 14
		//실제 화면에 보여져야하는 번호 = 14 

		//ex: 51개의 게시물
		//실제 화면에 보여져야하는 번호 6
		//1번 페이지 클릭시 -> endPage의 공식은 = 10, realEnd = 6

		//결론: endPage > realEnd 라면 realEnd를 보여주면됨.
		if(this.endPage > realEnd ) {
			this.endPage = realEnd;
		}
		
		//startPage는 1, 11, 21... 101로 표시됨
		//이전 버튼 (startPage가 1보다 큰경우면 true) - 버튼 활성화
		this.prev = this.startPage > 1;
		
		//다음 버튼 (realEnd 가 endPage) 보다 큰 경우만 활성화(위에 참고)
		this.next = realEnd > this.endPage; //활성화
		
		System.out.println("[endPage]"+ endPage);
		System.out.println("[startPage]"+ startPage);
	}
	
	
	
}
