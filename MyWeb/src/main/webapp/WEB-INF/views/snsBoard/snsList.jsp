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
	    body {
            background-color: white;
        }
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
            position: absolute;/*부모기준으로 위치지정(릴레이티브 줘야함)*/
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
		  padding: .5em .75em;
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
							<p>
								<img src="../resources/img/profile.png">박인욱
							</p>
							<ul>
								<li>뉴스피드</li>
								<li>메신저</li>
								<li>watch동영상</li>
							</ul>
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
					<h3>생각대로 이루어 지리라</h3>
					<div class="reply-content">
						<textarea class="form-control" rows="3"></textarea>
						<div class="reply-group">
							<div class="filebox pull-left">
							  <label for="ex_file">업로드</label>
							  <input type="file" id="ex_file">
							</div>
							<button class="right btn btn-info">등록하기</button>
						</div>
						<div></div>
					</div>

					<div class="title-inner">
						<!--제목영역-->
						<div class="profile">
							<img src="../resources/img/profile.png" alt="">
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
						<img src="../resources/img/facebook.jpg" alt="">
						
					</div>
					<div class="like-inner">
						<!--좋아요-->
						<img src="../resources/img/icon.jpg" alt=""> <span>522</span>
					</div>
					<div class="link-inner">
						<span><i class="glyphicon glyphicon-thumbs-up"></i>좋아요</span> <span><i
							class="glyphicon glyphicon-comment"></i>댓글달기</span> <span><i
							class="glyphicon glyphicon-share-alt"></i>공유하기</span>
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
</body>
</html>