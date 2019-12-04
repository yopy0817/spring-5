<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>인덱스를 만들어 보자</title>

    <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
	
	
</head>
<body>

	<%@ include file="../include/header.jsp" %>
   	<!--게시판-->
    <section>
        <div class="container">
            <div class="row">
                <!--lg에서 9그리드, xs에서 전체그리드-->   
                <div class="col-lg-9 col-xs-12 board-table">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    <hr>
                    
                    <!--form select를 가져온다 -->
                    <!-- 검색의 name, value추가, form의 id추가 -->
                    <form action="freeList" method="get" name="searchForm" id="searchForm">
                    <div class="search-wrap" >
                       <span>총 ${pageVO.total }게시글</span>
                       <button type="button" class="btn btn-info search-btn" id="searchBtn">검색</button>
                       <input type="text" class="form-control search-input" value="${pageVO.cri.searchName }" name="searchName" id="searchName">
                       <select class="form-control search-select" name="searchType">
                            <option value="title" ${pageVO.cri.searchType eq 'title' ? 'selected' : '' }>제목</option>
                            <option value="content" ${pageVO.cri.searchType eq 'content' ? 'selected' : '' }>내용</option>
                            <option value="writer" ${pageVO.cri.searchType eq 'writer' ? 'selected' : '' }>작성자</option>
                            <option value="titcont" ${pageVO.cri.searchType eq 'titcont' ? 'selected' : '' }>제목+내용</option>
                       </select>
                    </div>
                    <!-- 검색의 클릭시 pageNum은 1부터 시작하게 함 -->
                    <input type="hidden" name="pageNum" id="pageNum" value="1">
                    <input type="hidden" name="amount" id="amount" value="${pageVO.cri.amount }">
                    </form>
                    
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th class="board-title">제목</th>
                                <th>작성자</th>
                                <th>등록일</th>
                                <th>수정일</th>
                            </tr>
                        </thead>
                        <c:forEach var="vo" items="${boardList }">
                        <tbody>
                            <tr>
                                <td>${vo.bno }</td>
                                <td>
                                <a href="freeDetail?bno=${vo.bno }">${vo.title }<span class="badge">${vo.total }</span></a>
                                </td>
                                <td>${vo.writer }</td>
                                <td>${vo.regdate }</td>
                                <td>${vo.updatedate }</td>
                            </tr>
                        </tbody>
                        </c:forEach>
                        
                    </table>
                    
                    
                    <!--새로운 div를 잡는데 text-center는 가운대 정렬-->
                    <!--페이지 네이션을 가져옴-->
                    <form action="freeList" method="get" name="pageForm" id="pageForm">
                    <div class="text-center">
                    <hr>
                    <%-- 
                    <ul class="pagination pagination-sm">
                    	<!-- 3.이전 활성화 여부 -->
                    	<c:if test="${pageVO.prev }">
                        <li><a href="freeList?pageNum=${pageVO.startPage-1 }">이전</a></li>
                        </c:if>
                        <!-- 1.페이지넘처리 -->
                        <c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
                        <li class="${pageVO.pageNum eq num ? 'active':'' }">
                        	<a href="freeList?pageNum=${num }">${num }</a>
                        </li>
                        </c:forEach>
                        <!-- 2.다음 활성화 여부 -->
                        <c:if test="${pageVO.next }">
                        <li><a href="freeList?pageNum=${pageVO.endPage+1}">다음</a></li>
                        </c:if>
                    </ul>
                    --%>
                    <ul class="pagination pagination-sm" id="page">
                    	<c:if test="${pageVO.prev }">
                        	<li><a href="${pageVO.startPage-1 }">이전</a></li> <!-- onclick="page(${pageVO.startPage-1})" -->
                        </c:if>
                        <c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
	                        <li class="${pageVO.pageNum eq num ? 'active':'' }"> 
	                        	<a href="${num }">${num }</a> <!-- onclick="page(${num})" -->
	                        </li>
                        </c:forEach>
                        <c:if test="${pageVO.next }">
                        	<li><a href="${pageVO.endPage+1}">다음</a></li> <!-- onclick="page(${pageVO.endPage+1})" -->
                        </c:if>
                    </ul>
                    
                    <input type="hidden" name="pageNum" id="pageNum" value="${pageVO.cri.pageNum }">
                    <input type="hidden" name="amount" id="amount" value="${pageVO.cri.amount }">
                    <input type="hidden" name="searchType" value="${pageVO.cri.searchType }">
                    <input type="hidden" name="searchName" value="${pageVO.cri.searchName }">
                    <button type="button" class="btn btn-info" id="freeRegist">글쓰기</button>
                    </div>
                    </form>
                    
                    
                </div>
            </div>
        </div>
	</section>
</body>
<%@ include file="../include/footer.jsp" %>
	
	<script>
		//게시글 등록후 생성
		//다음은 화면 로딩시 무조건 실행되는 스크립트 메서드 입니다.
		//컨트롤러에서 전달된 msg를 받아온다
		//공백이 아니라면 msg를 출력한다
		window.onload = function() {
			
			//뒤로가기 문제에 대한 처리?
			//history.replaceState('', null, null);		
			//alert(history.state)
			if(history.state == '') {
				return;
			}
			var msg = '${msg}';
			if(msg != '') {
				alert(msg);
				history.replaceState('', null, null); //history기록을 하나 더 쌓아서 뒤로가기 문제해결 
			}
			
			
			
		}
		//등록처리
		var freeRegist = document.getElementById("freeRegist");
		freeRegist.onclick = function() {
			location.href = "freeRegist";
		}

		//1. 페이징 처리를 a태그에서 -> 폼전송으로
		//2. Criteria에 폼변수 추가
		//3. 페이징 쿼리를 동적쿼리로, 전체게시글 수 또한 동적쿼리로
		//4. search폼 과 page폼을 나눈다 
		//5. 두 Form에서 pageNum, amountm searchTypem searchName을 동시에 넘겨줘야함(hidden을 이용한다!!)
		//6. 3페이지에서 검색하면 3페이지로 이동하는 문제 해결
		//7. select박스에 키워드처리, 검색input 키워드 처리
		//검색처리(버튼 클릭시 폼전송)
		var searchBtn = document.getElementById("searchBtn");
		searchBtn.onclick = function() {
			//3페이지에서 검색하면 3페이지로 이동하는 문제 해결
			document.getElementById("pageNum").setAttribute("value", 1);
			
			document.getElementById("searchForm").submit();
		}
		//검색처리(페이징 클릭시 폼전송) 1st
		/* 
		function page(num) {
			event.preventDefault(); //이벤트의 실행을 막는다

			document.querySelector("#pageForm #pageNum").setAttribute("value", num)	//페이지 폼의 값을 value를 세팅한다
			document.getElementById("pageForm").submit(); //폼 서브밋
		}
		*/
		//이벤트 위임방식 2nd - 부모에 이벤트를 걸어놓고 자식태그 클릭시 이벤트를 위임하여 적용하는 방법
		var page = document.getElementById("page");
		page.onclick = function(event) {
			event.preventDefault();
			console.log(event.target);
			console.log(event.target.innerHTML);
			console.log(event.target.getAttribute("href"));
			
			var value = event.target.getAttribute("href");
			document.querySelector("#pageForm #pageNum").setAttribute("value", value) //페이지 폼의 값을 value를 세팅한다
			document.getElementById("pageForm").submit();
		}
		
		

		//페이징 클릭시 폼전송(제이쿼리)
		/* 
		$(".text-center li a").click(function(){
			console.log( $(this).attr("href") );
		});
		 */ 
		
	</script>









</html>

