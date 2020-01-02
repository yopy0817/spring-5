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
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/css/lecture.css" rel="stylesheet">
    
	<style type="text/css">
        section {
            margin-top: 70px;
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
        .title > a {
        	float: right;
        }
        
        /*내용*/
        .content-inner {
            padding:10px 0;
        }
        /* 이미지영역  */
        .image-inner img {
			width:100%;
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
        .link-inner a {
            float: left;
            width: 33.3333%;
            text-align: center;
            text-decoration: none;
            color: #333333;
        }
        .link-inner i {
            margin: 0 5px;
        }
        
        /*767미만 사이즈에서 해당 css가 적용됨*/
        /*xs가 767사이즈   */
        @media (max-width:767px){
            /* aside {display: none;} */
        }
	</style>
	
</head>
<body>
	<%@ include file="../../include/header.jsp" %>
	<section>
		<div class="container">
			<div class="row">
				<!-- 목록영역 -->
				<%@ include file="../../include/aside.jsp" %>
				<div class="col-xs-12 col-sm-9 col-md-9 section-inner">
					<!-- 강의영역 -->
					<div class="contentDiv" id="contentDiv">
	                    <div class="titlebox">
	                    	<p>${lecListVO.lecListName }</p>
	                    	<small>${lecListVO.regdate }</small>                    
	                    </div>
						<div class="content-inner">
							<p>삶이 우리를 끝없이 시험하기에 고어텍스는 한계를 테스트합니다</p>
						</div>
						<div class="image-inner">
							<!-- 이미지영역 -->
							<img src="../../resources/img2/img_ready.png">
							<!-- <img src="display?fileLoca=20191129&fileName=9f08b55b36724aa7895d60f5e5f716e2.jpg"> -->
						</div>
						<div class="like-inner">
							<!--좋아요-->
							<img src="../../resources/img2/icon.jpg"><span>522</span>
							<img src="../../resources/img2/icon2.png"><span>5명이 수업참여중</span>
						</div>
					</div>
					<!-- 강의영역 끝 -->
					<!-- 댓글영역 -->
					<div class="write-wrap">
					<form class="reply-wrap">
						<div class="reply-image">
							<img src="../../resources/img/profile.png">
						</div>
						<div class="reply-content">
							<textarea class="form-control" rows="3" name="reply" id="reply"></textarea>
							<!--여기에-->
							<div class="reply-group">
								<div class="reply-input">
									<input type="text" class="form-control" placeholder="이름" name="replyId" id="replyId"> 
									<input type="password" class="form-control" placeholder="비밀번호" name="replyPw"	id="replyPw">
								</div>
								<button type="button" class="right btn btn-info" id="replyRegist">등록하기</button>
							</div>
						</div>
					</form>
					<div id="replyList">
						<div class='reply-wrap'>
							<div class='reply-image'>
								<img src='../../resources/img/profile.png'>
							</div>
							<div class='reply-content'>
								<div class='reply-group'>
									<strong class='left'>honggildong</strong> <small class='left'>2019/12/10</small>
									<a href='#' class='right' id="replyModify">
									<span class='glyphicon glyphicon-pencil'></span>수정</a> 
									<a href='#'	class='right' id="replyDelete">
									<span class='glyphicon glyphicon-remove'></span>삭제</a>
								</div>
								<p class='clearfix'>여기는 댓글영역</p>
							</div>
						</div>
					</div>
					<button type="button" class="form-control" id="moreList">더보기</button>
				</div>
					
				</div>
			</div>
		</div>
	</section>

	<%@ include file="../../include/footer.jsp" %>

	<!-- 모달 -->
	<div class="modal fade" id="replyModal" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="btn btn-default pull-right"
						data-dismiss="modal">닫기</button>
					<h4 class="modal-title">댓글수정</h4>
				</div>
				<div class="modal-body">
					<!-- 수정폼 id값을 확인하세요-->
					<div class="reply-content">
						<textarea class="form-control" rows="4" id="modalReply"
							placeholder="내용입력"></textarea>
						<div class="reply-group">
							<div class="reply-input">
								<input type="hidden" id="modalRno"> <input
									type="password" class="form-control" placeholder="비밀번호"
									id="modalPw">
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
	
	<script>

		let replyRegist = document.querySelector("#replyModify");
		replyRegist.addEventListener("click", modalOpen);
		
		function modalOpen() {
			event.preventDefault();
			$("#replyModal").modal("show");	
		}
		
		(function() {
			
			
		})();
	</script>
	
</body>
</html>