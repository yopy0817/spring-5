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
    <script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
	<style type="text/css">
        section {
            margin-top: 70px;
        }
  
        /*부트스트랩 li의 drophover클래스 호버시에 드롭다운 적용코드*/
        ul.nav li.drophover:hover > ul.dropdown-menu {
            display: block; 
            margin: 0;
        }
        .aside-inner {
            position:fixed;
            top:70px;
            width: 180px;
        }
        .section-inner {
        	border-right: 1px solid #ddd;
            border-left: 1px solid #ddd;
            background-color: white;
        }
		.section-inner p,
		.aside-inner p {
		    margin:0;
		}
        
        .title-inner {
            position: relative;
            padding: 15px 0;
        }
        
        .title-inner .profile{
            position: absolute;/*부모기준으로 위치지정 릴레이티브*/
            top:15px;
            left: 0;
            
        }
        .title-inner .title {
            padding-left: 50px;
        }
        /*내용*/
        .content-inner {
            padding:10px 0;
        }
        /*좋아요*/
        .like-inner {
            padding:10px 0;
            border-bottom: 1px solid #ddd;
            border-top: 1px solid #ddd;
            margin-top: 10px;
        }
        
        .like-inner img {
            width:20px;
            height: 20px;
        }
        
        .link-inner {
            overflow: hidden;
            padding:10px 0;
        }
        
        .link-inner span {
            float: left;
            width: 33.3333%;
            text-align: center;
        }
        
        .link-inner i {
            margin: 0 5px;
        }
        
        /*767미만 사이즈에서 해당 css가 적용됨*/
        /*xs가 767사이즈   */
        @media (max-width:767px){
            aside {
                display: none;
            }
        }
        
 		/* 파일업로드 버튼 바꾸기 */
 		
 		.filebox label {
		  display: inline-block;
		  padding: 6px 10px;
		  color: #fff;
		  font-size: inherit;
		  line-height: normal;
		  vertical-align: middle;
		  background-color: #5cb85c;
		  cursor: pointer;
		  border: 1px solid #4cae4c;
		  border-radius: none;
		  -webkit-transition: background-color 0.2s;
		  transition: background-color 0.2s;
		}
		.filebox label:hover {
		  background-color: #6ed36e;
		}
		.filebox label:active {
		  background-color: #367c36;
		}
		.filebox input[type="file"] {
		  position: absolute;
		  width: 1px;
		  height: 1px;
		  padding: 0;
		  margin: -1px;
		  overflow: hidden;
		  clip: rect(0, 0, 0, 0);
		  border: 0;
		}
		
		/* sns파일 업로드시 미리보기  */
		.fileDiv {
			height: 100px;
			width: 200px;
			display: none;
			margin-bottom: 10px;
		}
		.fileDiv img {
			width: 100%;
			height: 100%;
		}
		
	</style>
	
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<section>
		<div class="container">
			<div class="row">
				<aside class="col-sm-2">
					<div class="aside-inner">
						<div class="menu1">
							<c:choose>
							<c:when test="${sessionScope.user_id != null }">	
							<p>
								<img src="../resources/img/profile.png">${userVO.userName }
							</p>
							<ul>
								<li>내정보</li>
								<li>내쿠폰</li>
								<li>내좋아요게시물</li>
							</ul>
							</c:when>
							<c:otherwise>
								<button type="button" class="btn btn-info" onclick="location.href='../user/userLogin'">로그인</button>
							</c:otherwise>
							</c:choose>
						</div>
						<div class="menu2">
							<p>둘러보기</p>
							<ul>
								<li>기부 캠페인</li>
								<li>페이지</li>
								<li>그룹</li>
								<li>이벤트</li>
								<li>친구리스트</li>
							</ul>
						</div>
					</div>
				</aside>
				<div class="col-xs-12 col-sm-8 section-inner">
					<h4>게시글을 등록하세요</h4>
					<!-- 파일 업로드 폼입니다 -->
					<div class="fileDiv">
						<img id="fileImg" src="../resources/img/img_ready.png">
					</div>
					<div class="reply-content">
						<textarea class="form-control" rows="3" name="content" id="content"></textarea>
						<div class="reply-group">
							<div class="filebox pull-left">
								<label for="file">이미지업로드</label> 
								<input type="file" name="file" id="file">
							</div>
							<button type="button" class="right btn btn-info" id="uploadBtn">등록하기</button>
						</div>
					</div>
					
					
					<!-- 파일 업로드 폼 끝 -->
					<div id="contentDiv">
					<div class="title-inner">
						<!--제목영역-->
						<div class="profile">
							<img src="../resources/img/profile.png">
						</div>
						<div class="title">
							<p>테스트</p>
							<small>21시간</small>
						</div>
					</div>
					<div class="content-inner">
						<!--내용영역-->
						<p>삶이 우리를 끝없이 시험하기에 고어텍스는 한계를 테스트합니다</p>
					</div>
					<div class="image-inner">
						<!-- 이미지영역 -->
						<!-- <img src="../resources/img/facebook.jpg"> -->
						<img src="display?fileLoca=20191129&fileName=9f08b55b36724aa7895d60f5e5f716e2.jpg" alt="">
					</div>
					<div class="like-inner">
						<!--좋아요-->
						<img src="../resources/img/icon.jpg"><span>522</span>
					</div>
					<div class="link-inner">
						<span><i class="glyphicon glyphicon-thumbs-up"></i>좋아요</span> <span><i
							class="glyphicon glyphicon-comment"></i>댓글달기</span> <span><i
							class="glyphicon glyphicon-share-alt"></i>공유하기</span>
					</div>
					</div>
				</div>
				<!--우측 어사이드-->
				<aside class="col-sm-2">
					<div class="aside-inner">
						<div class="menu1">
							<p>목록</p>
							<ul>
								<li>목록1</li>
								<li>목록2</li>
								<li>목록3</li>
								<li>목록4</li>
								<li>목록5</li>
							</ul>
						</div>
					</div>
				</aside>
			</div>
		</div>
	</section>
	
	
	<%@ include file="../include/footer.jsp" %>
	
	<script>
		$(document).ready(function(){
			
			$("#uploadBtn").click(function() {
				regist();	
			});
			function regist() {
				//세션값
				var user_id = '${sessionScope.user_id}';
				//자바스크립트 파일확장자 체크 검색
				var file = $("#file").val(); //var fileSize = $("#file")[0].files[0].size);
				file = file.slice(file.indexOf(".") + 1).toLowerCase();
				if(file != "jpg" && file != "png" && file != "bmp") {
					alert("이미지 파일(jpg, pmp, bmp)만 등록 가능합니다");
					$("#file").val("");
					return; //종료
				} else if( user_id == '' /* false */ ) { //세션이 없다면
					alert("로그인이 필요한 서비스 입니다");
					return;
				}
				
				//ajax폼전송의 핵심 FormData객체
				var formData = new FormData();
				var data = $("#file")
				console.log("폼데이터:" + formData);
				console.log(data);
				console.log(data[0]); 
				console.log(data[0].files); //파일태그의 담긴 파일을 확인하는 키값
				console.log(data[0].files[0]);
				formData.append("file", data[0].files[0]); //폼데이터에 추가
				console.log("폼데이터:" + formData);
				//content값을 얻어옴 폼데이터에 추가
				var content = $("#content").val();
				formData.append("content", content);

				$.ajax({
					url: "upload",
					processData: false, //폼을 &변수=값 형식으로 자동으로 변경되는 것을 막는 요소
					contentType: false, //ajax방식에서는 반드시 false로 처리  "multipart/form-data"로 선언됨
					data: formData, //폼데이터객체를 넘깁니다
					type: "POST",
					success: function(result) {
						if(result == 'success') {
							getList(true); //리스트 호출(str초기화 여부)
						} else {
							alert("업로드에 실패했습니다. 관리자에게 문의해주세요");
						}
					},
            		error: function(status, er) {
            			alert("업로드에 실패했습니다. 관리자에게 문의해주세요");
            		}
				}) 
			} //등록작업끝
			
			//리스트 작업(화면에서 src에 display를 걸고 화면에서 확인후 실행)
			getList();
			var str='';
			function getList(reset) {
				if(reset == true) {
					str = ''; //리셋여부 true라면 str초기화
				}
				
				$.getJSON(
					"getList",
					function(list) {
						console.log( JSON.stringify(list) );
						
						for(var i = 0; i < list.length; i++) {
							str += "<div class='title-inner'>";
							str += "<div class='profile'>";
							str += "<img src='../resources/img/profile.png' >"; 	
							str += "</div>";
							str += "<div class='title'>";
							str += "<p>"+ list[i].writer +"</p>";
							str += "<small>"+ timeStamp(list[i].regdate) +"</small>";
							str += "</div>";
							str += "<div class='content-inner'>"
							str += "<p>"+ list[i].content +"</p>";
							str += "</div>";
							/* 이미지 영역 */
							str += "<div class='image-inner'>";
							str += "<img src='display?fileLoca="+list[i].fileLoca +"&fileName="+list[i].fileName +"'>";
							str += "</div>";
							str += "<div class='like-inner'>"; 						
							str += "<img src='../resources/img/icon.jpg'><span>522</span>";						
							str += "</div>";
							str += "<div class='link-inner'>";							
							str += "<span><i class='glyphicon glyphicon-thumbs-up'></i>좋아요</span>";
							str += "<span><i class='glyphicon glyphicon-comment'></i>댓글달기</span>";
							str += "<span><i class='glyphicon glyphicon-share-alt'></i>공유하기</span>";
							str += "</div>";
							$("#contentDiv").html(str);
						}
					}
				)
			} //리스트 가져오기 끝
			
    		//날짜 처리
    		function timeStamp(millis) {
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
		})
	</script>
	<script>
		
		//자바 스크립트 파일 미리보기 기능
		function readURL(input) {
        	if (input.files && input.files[0]) {
        		
            	var reader = new FileReader(); //비동기처리를 위한 파읽을 읽는 자바스크립트 객체
            	//readAsDataURL 메서드는 컨텐츠를 특정 Blob 이나 File에서 읽어 오는 역할 (MDN참조)
	        	reader.readAsDataURL(input.files[0]); 
            	//파일업로드시 화면에 숨겨져있는 클래스fileDiv를 보이게한다
	            $(".fileDiv").css("display", "block");
            	
            	reader.onload = function(event) { //읽기 동작이 성공적으로 완료 되었을 때 실행되는 익명함수
                	event.preventDefault();
            		$('#fileImg').attr("src", event.target.result); 
                	//console.log(event.target)//event.target은 이벤트로 선택된 요소를 의미
	        	}
        	}
	    }
		$("#file").change(function() {
	        readURL(this); //this는 #file자신 태그를 의미
	    })
	    
	    //이거무한스크롤
	    var page = 1;
		$(window).scroll(function() {
		    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
		      console.log(++page);
		      $("#contentDiv").append("<h1>Page " + page + "</h1><BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~<BR/>So<BR/>MANY<BR/>BRS<BR/>YEAHHH~");
		      
		}
});
	</script>
	
	
	
</body>
</html>