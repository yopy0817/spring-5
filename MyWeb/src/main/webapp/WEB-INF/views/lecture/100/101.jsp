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
		/* 모달창 조절 */
		.modal-body {
			padding: 0px;
		}
		.modal-content > .row {
			margin: 0px;
		}
		.modal-body > .modal-img {
			padding: 0px;
		}
		.modal-body > .modal-con {
			padding: 15px;
		}
		.modal-inner {
            position: relative;
        }
        .modal-inner .profile{
            position: absolute;/*부모기준으로 위치지정 릴레이티브*/
            top: 0px;
            left: 0px;
        }
        .modal-inner .title {
            padding-left: 50px;
        }
		.modal-inner p {
			margin: 0px;
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
									<a href='#' class='right' id="replyModify"><span
										class='glyphicon glyphicon-pencil'></span>수정</a> <a href='#'
										class='right' id="replyDelete"><span
										class='glyphicon glyphicon-remove'></span>삭제</a>
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
	<div class="modal fade" id="snsModal" role="dialog">
			<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body row">
					<div class="modal-img col-sm-8 col-xs-6" >
						<img src="../../resources/img2/img_ready.png" id="snsImg" width="100%">
					</div>
					<div class="modal-con col-sm-4 col-xs-6">
						<div class="modal-inner">
						<div class="profile">
							<img src="../../resources/img/profile.png">
						</div>
						<div class="title">
							<p id="snsWriter">테스트</p>
							<small id="snsRegdate">21시간전</small>
						</div>
						<div class="content-inner">
							<p id="snsContent">삶이 우리를 끝없이 시험하기에 고어텍스는 한계를 테스트합니다</p>
						</div>
						<div class="link-inner">
							<a href="##"><i class="glyphicon glyphicon-thumbs-up"></i>좋아요</a>
							<a href="##"><i class="glyphicon glyphicon-comment"></i>댓글달기</a> 
							<a href="##"><i class="glyphicon glyphicon-share-alt"></i>공유하기</a>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>