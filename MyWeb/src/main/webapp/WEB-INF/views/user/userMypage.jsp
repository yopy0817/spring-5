<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>인덱스를 만들어 보자</title>
	
	<!-- 제이쿼리 추가(가장먼저 로딩 되어야 하기때문에 첫째줄에 선언) -->
	<script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>
	
	
    <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
	

	
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<section>
        <!--Toggleable / Dynamic Tabs긁어옴-->
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-10 col-lg-9 myInfo">
                    <div class="titlebox">
                        MEMBER INFO                    
                    </div>
                    
                    <ul class="nav nav-tabs tabs-style">
                        <li class="active"><a data-toggle="tab" href="#info">내정보</a></li>
                        <li><a data-toggle="tab" href="#myBoard">내글</a></li>
                        <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="info" class="tab-pane fade in active">
 
                            <p>*표시는 필수 입력 표시입니다</p>
                            <form>
                            <table class="table">
                                <tbody class="m-control">
                                    <tr>
                                        <td class="m-title">*ID</td>
                                        <td><input class="form-control input-sm" name="userId" id="userId" value="${userVO.userId }" readonly></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*이름</td>
                                        <td><input class="form-control input-sm" name="userName" id="userName" value=${userVO.userName }></td>
                                    </tr>
                                    <%-- 
                                    <tr>
                                        <td class="m-title">*닉네임</td>
                                        <td>
                                        <input class="form-control input-sm" name="userNick" id="userNick" value=${userVO.userNick }>
                                        <span id="msgNick"></span>
                                        </td>
                                    </tr>
                                     --%>
                                    <tr>
                                        <td class="m-title">*비밀번호</td>
                                        <td><input type="password" class="form-control input-sm" name="userPw" id="userPw" placeholder="변경할 비밀번호를 입력하세요"></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*비밀번호확인</td>
                                        <td><input type="password" class="form-control input-sm" name="pwConfirm" id="pwConfirm" placeholder="변경할 비밀번호를 입력하세요"></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*E-mail</td>
                                        <td>
                                            <input class="form-control input-sm" name="userEmail1" id="userEmail1" value="${userVO.userEmail1 }">@
                                            <select class="form-control input-sm sel" name="userEmail2" id="userEmail2" >
                                                <option ${userVO.userEmail2 == 'naver.com' ? 'selected' : '' }>naver.com</option>
                                                <option ${userVO.userEmail2 == 'gmail.com' ? 'selected' : '' }>gmail.com</option>
                                                <option ${userVO.userEmail2 == 'daum.net' ? 'selected' : '' }>daum.net</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*휴대폰</td>
                                        <td>
                                            <select class="form-control input-sm sel" name="userPhone1" id="userPhone1">
                                                <option>010</option>
                                                <option>011</option>
                                                <option>017</option>
                                                <option>018</option>
                                            </select>
                                            <input class="form-control input-sm" name="userPhone2" id="userPhone2" value="${userVO.userPhone2 }">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*우편번호</td>
                                        <td><input class="form-control input-sm" id="addrZipNum" value="${userVO.addrZipNum }" readonly>
                                        	<button type="button" class="btn btn-primary" id="addBtn">주소찾기</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*주소</td>
                                        <td><input class="form-control input-sm add" id="addrBasic" value="${userVO.addrBasic }"></td>
                                    </tr>
                                    <tr>
                                        <td class="m-title">*상세주소</td>
                                        <td><input class="form-control input-sm add" id="addrDetail" value="${userVO.addrDetail }"></td>
                                    </tr>
                                </tbody>
                            </table>
                            </form>

                            <div class="titlefoot">
                                <button type="button" class="btn" id="updateBtn">수정</button>
                            </div>
                        </div>
                        <!-- 첫번째 토글 끝 -->
                        <div id="myBoard" class="tab-pane fade">
                            <p>*내 게시글 관리</p>
                            <form>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td>번호</td>
                                        <td>제목</td>
                                        <td>작성일</td>
                                    </tr>
                                </thead>
                                <c:forEach var="vo" items="${userVO.userBoardList }">
                                <tbody>
                                    <tr>
                                        <td>${vo.bno }</td>
                                        <td><a href="../freeBoard/freeDetail?bno=${vo.bno }">${vo.title }</a></td>
                                        <td><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/></td>
                                    </tr>
                                </tbody>
                                </c:forEach>
                            </table>
                            </form>
                        </div>
                        <!-- 두번째 토글 끝 -->
                        <div id="menu2" class="tab-pane fade">
                            <h3>Menu 2</h3>
                            <p>Some content in menu 2.</p>
                        </div>
                    </div>
                </div>
            </div>

        </div>


    </section>
    
    <%@ include file="../include/footer.jsp" %>
    
	<script>
		$("#updateBtn").click(function() {
			var userId = $("#userId").val();
			var userPw = $("#userPw").val();
			var pwConfirm = $("#pwConfirm").val();
			var userName = $("#userName").val();
			var userPhone1 = $("#userPhone1").val();
			var userPhone2 = $("#userPhone2").val(); 
			var userEmail1 = $("#userEmail1").val();
			var userEmail2 = $("#userEmail2").val();
			var addrZipNum = $("#addrZipNum").val();
			var addrBasic = $("#addrBasic").val();
			var addrDetail = $("#addrDetail").val();
			if(userPw.length < 8 || userPw.length > 16 ) {
				alert("비밀번호는 8자리이상 16자리 이하로 입력하세요");
			} else if( userPw != pwConfirm ) {
				alert("비밀번호 확인란을 확인하세요");
			} else if( userName == '') {
				alert("이름은 필수사항입니다");
			} else if( userPhone2 == '') {
				alert("연락처는 필수사항입니다");
			} else if( userEmail1 == '') {	
				alert("이메일은 필수사항입니다");
			} else if( addrZipNum == '') {
				alert("주소는 필수사항입니다");
			} else if( addrBasic == '') {
				alert("주소는 필수사항입니다");
			} else if( confirm("수정하시겠습니까?")){
				var jsonData = { //비동기보낼 제이슨 데이터
						"userId": userId, 
						"userPw": userPw,
						"userName": userName,
						"userPhone1": userPhone1,
						"userPhone2": userPhone2,
						"userEmail1": userEmail1,
						"userEmail2": userEmail2,
						"addrZipNum": addrZipNum,
						"addrBasic": addrBasic,
						"addrDetail": addrDetail
				}
				$.ajax({
					type: "post",
					url: "updateUser",
					data: JSON.stringify(jsonData),
					contentType: "application/json; charset=utf-8",
					success: function(result) {
						if(result == 1) {
							alert("정보가 수정되었습니다");
							$("#userPw").val("");
							$("#pwConfirm").val("");
						} else {
							alert("정보 수정에 실패했습니다");
						}
					},
					error: function(status) {
						alert("잠시후에 다시 시도하세요");
					}
				})
			}
		})

	</script>

    <!-- 주소API -->
    <script>
    var addBtn = document.getElementById("addBtn");
    addBtn.onclick = function() { 
   		goPopup();
   	} 

    function goPopup(){
    	// 주소검색을 수행할 팝업 페이지를 호출합니다.
    	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
    	var pop = window.open("${pageContext.request.contextPath }/resources/pop/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    	
    	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
        //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
    }

    function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
    		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
    		
    		document.getElementById("addrBasic").value = roadAddrPart1;
    		document.getElementById("addrDetail").value = addrDetail + roadAddrPart2;
    		document.getElementById("addrZipNum").value = zipNo;

    }
    
    </script>
</body>
</html>