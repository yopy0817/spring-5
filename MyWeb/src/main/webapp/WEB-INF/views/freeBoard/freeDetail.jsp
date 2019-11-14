<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>상세보기</p>
                        </div>
                        
                        <form>
                            <div>
                                <label>DATE</label>
                                <p>${boardVO.updatedate }</p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" value="${boardVO.bno }" name='##' readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" value="${boardVO.writer }" name='##' readonly>
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" value="${boardVO.title }"name='##' readonly>
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='##' readonly>${boardVO.content }</textarea>
                            </div>
							
							<!-- 반드시 타입-버튼 id추가 -->
                            <button type="button" class="btn btn-primary" id="freeModify">변경</button>
                            <button type="button" class="btn btn-dark" id="freeList">목록</button>
                    </form>
                </div>
            </div>
        </div>
        </section>
        
        <section style="margin-top: 80px;">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-md-9 write-wrap">
                        <form class="reply-wrap">
                            <div class="reply-image">
                                <img src="../resources/img/profile.png">
                            </div>
	                        <!--form-control은 부트스트랩의 클래스입니다-->
	                        <div class="reply-content">
	                            <textarea class="form-control" rows="3" name="reply" id="reply"></textarea>
	                            <!--여기에-->
	                            <div class="reply-group">
	                                  <div class="reply-input">
	                                  <input type="text" class="form-control" placeholder="이름" name="replyId" id="replyId">
	                                  <input type="password" class="form-control" placeholder="비밀번호" name="replyPw" id="replyPw">
	                                  </div>
	                                  
	                                  <button type="button" class="right btn btn-info" id="replyRegist">등록하기</button>
	                            </div>
	                        </div>
                        </form>

                        <!--여기에접근 반복-->
                        <div id="replyList">
                        	<!-- 
	                        <div class='reply-wrap'>
	                            <div class='reply-image'>
	                                <img src='../resources/img/profile.png'>
	                            </div>
	                            <div class='reply-content'>
	                                <div class='reply-group'>
	                                    <strong class='left'>honggildong</strong> 
	                                    <small class='left'>2019/12/10</small>
	                                    <a href='#' class='right' id="replyModify"><span class='glyphicon glyphicon-pencil'></span>수정</a>
	                                    <a href='#' class='right' id="replyDelete"><span class='glyphicon glyphicon-remove'></span>삭제</a>
	                                </div>
	                                
	                                <p class='clearfix'>여기는 댓글영역</p>
	                            </div>
	                        </div>
	                         -->
                        </div>
                        
	                    <button type="button" class="form-control" id="moreList">더보기</button>

                    </div>
                </div>
            </div>
        </section>

        <%@ include file="../include/footer.jsp" %>

        <script>
        	var freeModify = document.getElementById("freeModify");
        	freeModify.onclick = function() {
        		location.href = "freeModify?bno=${boardVO.bno} ";
        	}
        	
        	var freeList = document.getElementById("freeList");
        	freeList.onclick = function() {
        		location.href = "freeList";
        	}
        </script>	
        
        <script>

			//다음은 페이지가 로딩되자마자 실행되는 제이쿼리 함수
        	$(document).ready(function(){
        		
        		//댓글 등록
            	$("#replyRegist").click(function(){
            		add();
            	})
            	function add(reply, callback, error) {
            		
            		var bno = "${boardVO.bno}";
            		var reply = $("#reply").val();
            		var replyId = $("#replyId").val();
            		var replyPw = $("#replyPw").val();
            		//공백 확인            		
            		if(reply == 0 || replyId == 0 || replyPw == 0) {
            			alert("이름 비밀번호 내용을 입력하세요");
            			return;
            		}
            		//에이잭스 요청
            		$.ajax({
                		type:"post",
                		url:"../reply/new",
                		data: JSON.stringify({"bno": bno, "reply": reply, "replyId": replyId, "replyPw": replyPw}),
                		contentType : "application/json; charset=utf-8",
                		success : function(result, status) {
    	           			if(result == 1) {
    	           				//게시글 작성후에 공백처리
								$("#reply").val("");
								$("#replyId").val("");
								$("#replyPw").val("");
								//게시글등록후에는 목록메서드 호출  (1, reset)
    	           				getList(1, true);
                			}
                		},
                		error: function(status, er) {
                			alert("다시 시도하세요:" + status);
                		}
                	})
            	} //등록 끝

        		//더보기 처리
        		$("#moreList").click(function() {
        			
        			getList(page + 1, false); //str을 리셋하지 않기위해 false전달
        			
        		}); //더보기 처리 끝
        		
            	//게시물 목록처리
            	getList(1, true);//목록처리 호출
        		var page = 1; //페이지번호
            	var str = ""; //화면에 뿌려줄 태그를 문자열로 저장하는 변수(전역변수)
        		function getList(pageNum, reset) {
        			
        			var bno = "${boardVO.bno}";
        			page = pageNum;//전달받은 페이지넘으로 페이지값을 초기화(요청에 page전달)    				
    				$.getJSON(
                		"../reply/getReply/" + bno + "/" + page,
                		function(data) {//응답 함수
                			var count = data.replyCount; //컨트롤러에서 넘어온 토탈카운트
                			var list = data.list; //컨트롤러에서 넘어온 댓글목록
                			
                			if(page * 20 >= count) {//페이지에따라 보여지는 게수가 전체게시글보다 작은경우 더보기 삭제
                				$("#moreList").attr("style", "display:none;");
                			} else {
                				$("#moreList").attr("style", "display:inline;");
                			}
                			if(reset == true) { //reset값은 str초기화 여부
                				str = "";
                				
                			}
                			if(list.length <= 0) {//응답 데이터의 길이가 0이면 종료
                   				$("#replyList").html("");
                   				return;//함수종료
                   			}
                   			
                   			for(var i = 0; i < list.length; i++) {
                   				console.log(list[i]);
								
								
                   				str +=
                   				"<div class='reply-wrap'>" +
                            		"<div class='reply-image'>" +
                                		"<img src='../resources/img/profile.png'>" +
                            		"</div>" +
                            			"<div class='reply-content'>" +
                                		"<div class='reply-group'>" +
                                			"<strong class='left'>"+ list[i].replyId +"</strong> " +
                                    		"<small class='left'>"+ timeStamp(list[i].replydate) +"</small>" +
                                    		"<a href='"+ list[i].rno+"' class='right' id='replyModify'><span class='glyphicon glyphicon-pencil'></span>수정</a>"+
                                    		"<a href='"+ list[i].rno+"' class='right' id='replyDelete'><span class='glyphicon glyphicon-remove'></span>삭제</a>"+
                                    	"</div>" +
                                		"<p class='clearfix'>"+list[i].reply +"</p>"+
                            		"</div>" +
                        		"</div>";
                   			}
                   			$("#replyList").html(str); //문자열을 통째로 추가한다
                   			
                		}
                	)
        		} //게시물 목록처리 끝
        		
        		//삭제 수정클릭시 이벤트 동작 처리
        		//반드시 on함수로 처리를 합니다
        		//에이잭스의 실행이 더 늦게 완료가 되므로 실제, 이벤트의 선언이 먼저일어나게 됩니다.
        		//그렇다면 화면에는 댓글에 관련된 이벤트는 아무것도 등록되지 않은 형태이므로, 클릭이벤트가 동작되지 않습니다
        		//이때 이미 존재하는 요소(#replyList)에 이벤트를 등록 하고, 해당 태그의 내부요소를 클릭 동작되는이벤트 위임방식을 사용합니다. 
        		$("#replyList").on("click", "a", function(event) {
        			event.preventDefault(); //막는다
        			
        			//console.log($(this)); //console.log($(this).attr("href")) ;
         			var num = $(this).attr("id"); 
        			if(num == "replyModify" ) {
        				var rno = $(this).attr("href");//클릭요소의 href값을 가져온다
        				$("#modalRno").val(rno);//모달 modalRno에 값을 세팅한다
        				$(".modal-title").html("댓글수정");//타이틀에 접근해서 글자 변경 
       				    $("#modalReply").attr("style", "display:inline;");//태그에 접근해서 inline
       				    $("#modalModBtn").attr("style", "display:inline;"); //수정버튼 inline
       				 	$("#modalDelBtn").attr("style", "display:none;"); //삭제버튼 none
        				$("#replyModal").modal("show"); //모달띄우기
        				
        			} else if(num == "replyDelete") {
        				var rno = $(this).attr("href");//클릭요소의 href값을 가져온다
        				$("#modalRno").val(rno);//모달 modalRno에 값을 세팅한다
        				$(".modal-title").html("댓글삭제");//타이틀에 접근해서 글자 변경 
       				    $("#modalReply").attr("style", "display:none;");//태그에 접근해서 none
       				    $("#modalModBtn").attr("style", "display:none;"); //수정버튼 none
       				    $("#modalDelBtn").attr("style", "display:inline"); //삭제버튼 inline
    					$("#replyModal").modal("show"); //모달띄우기
        			}
        		}); //삭제 수정클릭시 이벤트 동작 처리 끝
            	
        		//삭제처리
        		$("#modalDelBtn").click(function() {

        			var rno = $("#modalRno").val();
        			var replyPw = $("#modalPw").val();
      			
        			$.ajax({
        				type: "delete",
                		url:"../reply/delete",
                		data: JSON.stringify({"rno": rno, "replyPw": replyPw}),
                		contentType : "application/json; charset=utf-8",
                		success : function(result, status) {
                			if(result == 1) {//삭제 성공
                				alert("게시물이 삭제되었습니다");
                				$("#modalPw").val(""); //비밀번호창 값 비우기
                				$("#replyModal").modal("hide"); //모달내리기
                				getList(1, true); //게시글목록 호출(1, reset)
                			} else {
                				$("#modalPw").val(""); //비밀번호창 값 비우기
                				alert("비밀번호가 틀렸습니다");
                			}
                			
                		},
                		error: function(status, er) {
                			alert("다시 시도하세요:" + status);
                		}
        			})
        			
        		}); //삭제처리 끝
        		//수정처리
        		$("#modalModBtn").click(function() {
        			
        			var rno = $("#modalRno").val();
        			var reply = $("#modalReply").val();
        			var replyPw = $("#modalPw").val();

        			$.ajax({
        				type: "put",
        				url: "../reply/update",
        				data: JSON.stringify({"rno": rno, "reply": reply, "replyPw": replyPw }),
        				contentType : "application/json; charset=utf-8",
        				success: function(result, status) {
        					if(result == 1) {//업데이트 성공
                				alert("정상 수정되었습니다");
                				$("#modalPw").val(""); //비밀번호창 값 비우기
                				$("#modalReply").val(""); //수정창 비우기
                				$("#replyModal").modal("hide"); //모달내리기
                				getList(1, true); //게시글목록 호출(1, reset)
                			} else { //업데이트 실패
                				$("#modalPw").val(""); //비밀번호창 값 비우기
                				$("#modalReply").val(""); //수정창 비우기
                				alert("비밀번호가 틀렸습니다");
                			}
        				},
                		error: function(status, er) {
                			alert("다시 시도하세요:" + status);
                		}
        			})
        		}); //수정 완료
        		
        		//날짜 처리
        		function timeStamp(millis) {
        	        /*
        			var millis = 1573735023000;
        	        var date = new Date();//오늘날짜
        	        console.log(date.getTime() );//날짜를 밀리초구함
        	        var today = new Date(millis);//등록날짜
        	        console.log(today.getTime() );//등록날짜 밀리초구함
        	        console.log(today); //표준시
        	        console.log(today.getFullYear());//년
        	        console.log(today.getMonth() + 1);//월
        	        console.log(today.getDate());//일
        	        console.log(today.getHours());//시
        	        console.log(today.getMinutes());//분
        	        console.log(today.getSeconds());//초
        			*/
        	        var date = new Date();//오늘날짜
        			var gap = date.getTime() - millis; //시간차이
        	        console.log("경과밀리초:" + gap);

        	        var time; //리턴할 시간
        	        if(gap < 1000 * 60 * 60 * 24) {  //1일 이하인 경우
        	            if(gap < 1000 * 60 * 60) { //1시간 이하인 경우
        	                time = "방금전";
        	            } else {
        	                time = parseInt( gap / (1000 * 60 * 60) ) + "시간전";
        	            }
        	        } else { //1일 이상인 경우
        	            
        	            var today = new Date(millis);
        	            var year  = today.getFullYear();//년
        	            var month = today.getMonth() + 1;//월
        	            var day = today.getDate();//일
        	            var hour = today.getHours();//시
        	            var minute = today.getMinutes();//분
        	            var second = today.getSeconds();//초
        	            time = year +"년"+month+"월"+day+"일" +hour+":"+minute+":"+second;
        	        }
        	        console.log(time);
        	        return time;
        		}
        		
        		

         	}); 
        	</script>

			<!-- 모달 -->
			<div class="modal fade" id="replyModal" role="dialog">
				<div class="modal-dialog modal-md">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="btn btn-default pull-right" data-dismiss="modal">닫기</button>
							<h4 class="modal-title">댓글수정</h4>
						</div>
						<div class="modal-body">
							<!-- 수정폼 id값을 확인하세요-->
							<div class="reply-content">
							<textarea class="form-control" rows="4" id="modalReply" placeholder="내용입력" ></textarea>
							<div class="reply-group">
								<div class="reply-input">
								    <input type="hidden" id="modalRno">
									<input type="password" class="form-control" placeholder="비밀번호" id="modalPw">
								</div>
								<button class="right btn btn-info" id="modalModBtn">수정하기</button>
								<button class="right btn btn-info" id="modalDelBtn">삭제하기</button>
							</div>
							</div>
							<!-- 수정폼끝 -->
						</div>
					</div>
				</div>
			</div>
			
        
        
</body>
</html>