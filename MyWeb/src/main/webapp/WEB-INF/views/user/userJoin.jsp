<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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


	<!--폼 섹션-->
    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12 join-form">
                    <div class="titlebox">
                       	 회원가입
                    </div>
                    <form action="joinForm" id="regForm" method="post">
                        <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">아이디</label>
                            <div class="input-group"><!--input2탭의 input-addon을 가져온다 -->
                                <input type="text" class="form-control" name="userId" id="userId" placeholder="아이디를 (영문포함 4~12자 이상)">
                                <div class="input-group-addon">
                                    <button type="button" class="btn btn-primary" id="idConfirmBtn">아이디중복체크</button>
                                </div>
                            </div>
                            <span id="msgId"></span><!--자바스크립트에서 추가-->
                        </div>
                        <div class="form-group"><!--기본 폼그룹을 가져온다-->
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" name="userPw" id="userPw" placeholder="비밀번호 (영 대/소문자, 숫자 조합 8~16자 이상)">
                            <span id="msgPw"></span><!--자바스크립트에서 추가-->
                        </div>
                        <div class="form-group">
                            <label for="password-confrim">비밀번호 확인</label>
                            <input type="password" class="form-control" id="pwConfirm" placeholder="비밀번호를 확인해주세요.">
                             <span id="msgPw-c"></span><!--자바스크립트에서 추가-->
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" name="userName" id="userName" placeholder="이름을 입력하세요.">
                        </div>
                        <!-- 
                        <div class="form-group">
                            <label for="nick">닉네임</label>
                            <input type="text" class="form-control" name="userNick" id="userNick" placeholder="사용할 닉네임을 입력하세요(8글자 이하)">
                            <span id="msgNick"></span>
                        </div>
                         -->
                        <!--input2탭의 input-addon을 가져온다 -->
                        <div class="form-group">
                            <label for="hp">휴대폰번호</label>
                            <div class="input-group">
								<select class="form-control phone1" name="userPhone1" id="userPhone1">
									<option>010</option>
									<option>011</option>
									<option>017</option>
									<option>018</option>
								</select> 
								<input type="text" class="form-control phone2" name="userPhone2" id="userPhone2" placeholder="휴대폰번호를 입력하세요.">
                                <div class="input-group-addon">
                                    <button type="button" class="btn btn-primary">본인인증</button>
                                </div>
                            </div>
                        </div>
						<div class="form-group email-form">
						  <label for="email">이메일</label><br>
						  <input type="text" class="form-control" name="userEmail1" id="userEmail1" placeholder="이메일">
						  <select class="form-control" name="userEmail2" id="userEmail1">
						    <option>@naver.com</option>
						    <option>@daum.net</option>
						    <option>@gmail.com</option>
						    <option>@hanmail.com</option>
						    <option>@yahoo.co.kr</option>
						  </select>
						</div>
						<!--readonly 속성 추가시 자동으로 블락-->
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <div class="input-group">
                                <input type="text" class="form-control" name="addrZipNum" id="addrZipNum" placeholder="우편번호" readonly>
                                <div class="input-group-addon">
                                    <button type="button" class="btn btn-primary" id="addBtn">주소찾기</button>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="addrBasic" id="addrBasic" placeholder="기본주소">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="addrDetail" id="addrDetail" placeholder="상세주소">
                        </div>

                        <!--button탭에 들어가서 버튼종류를 확인한다-->
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" id="joinBtn">회원가입</button>
                        </div>

                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" id="loginBtn">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="../include/footer.jsp" %>

    <script>
        /*아이디 형식 검사 스크립트*/
        var id = document.getElementById("userId");
        id.onkeyup = function() {
            /*자바스크립트의 정규표현식 입니다*/
            /*test메서드를 통해 비교하며, 매칭되면 true, 아니면 false반*/
            var regex = /^[A-Za-z0-9+]{4,12}$/; 
            if(regex.test(document.getElementById("userId").value )) {
                document.getElementById("userId").style.borderColor = "green";
                document.getElementById("msgId").innerHTML = "아이디중복체크는 필수 입니다";
            } else {
                document.getElementById("userId").style.borderColor = "red";
                document.getElementById("msgId").innerHTML = "";
            }
        }
        /*비밀번호 형식 검사 스크립트*/
        var pw = document.getElementById("userPw");
        pw.onkeyup = function(){
            var regex = /^[A-Za-z0-9+]{8,16}$/;
             if(regex.test(document.getElementById("userPw").value )) {
                document.getElementById("userPw").style.borderColor = "green";
                document.getElementById("msgPw").innerHTML = "사용가능합니다";
            } else {
                document.getElementById("userPw").style.borderColor = "red";
                document.getElementById("msgPw").innerHTML = "";
            }
        }
        /*비밀번호 확인검사*/
        var pwConfirm = document.getElementById("pwConfirm");
        pwConfirm.onkeyup = function() {
            var regex = /^[A-Za-z0-9+]{8,16}$/;
            if(document.getElementById("pwConfirm").value == document.getElementById("userPw").value ) {
                document.getElementById("pwConfirm").style.borderColor = "green";
                document.getElementById("msgPw-c").innerHTML = "비밀번호가 일치합니다";
            } else {
                document.getElementById("pwConfirm").style.borderColor = "red";
                document.getElementById("msgPw-c").innerHTML = "비밀번호 확인란을 확인하세요";
            }
        }        
    </script>
    
    	<script>
		$("#idConfirmBtn").click(function(){

			if( $("#userId").val() == '' || $("#userId").css("border-color") == 'rgb(255, 0, 0)') {
				alert("아이디 규칙을 확인해주세요");
				return;
			} 
			
			var userId = $("#userId").val(); //아이디를 얻음
			$.ajax({
				type:"post",
				url:"idConfirm", //폴더명을이포함 user/idConfirm 요청
				data:JSON.stringify({"userId": userId }),
				contentType : "application/json; charset=utf-8",
				success: function(result) {
					if(result == 0) {
						alert("사용가능한 아이디 입니다");
						$("#userId").attr("readonly", true);//리드온리로 바꿈
						$("#msgId").html("사용가능한 아이디 입니다");//문자열로 집어넣음
					} else {
						alert("중복된 아이디 입니다");
						$("#userId").focus(); //포커스
					}
				},
        		error: function(status) {
        			alert("다시 시도하세요:" + status);
        		}
			})
		});
		//회원가입버튼
		$("#joinBtn").click(function(){
	  		//attr(속성, 변경할값) 함수는 선택자의 내부속성을 변경하는 함수 입니다.
			//attr(속성) 함수의 매개값이 하나라면 해당속성여부를확인합니다.
			//val() 함수는 선택자의 값을 확인합니다.
			//focus() 함수는 선택자의 마우스 커서를 위치시킵니다.
			//submit() 함수는 선택자의 form을 서브밋 시킵니다.
			console.log($("#userPw").css("border-color"))
			
			if( !$("#userId").attr("readonly") ) {
				alert("아이디 중복체크는 필수사항입니다");
			} else if( $("#userPw").val() == '') {
				alert("비밀번호 규칙을 확인하세요");				
			} else if( $("#userPw").css("border-color") == 'rgb(255, 0, 0)' ) {
				alert("비밀번호 규칙을 확인하세요");
			} else if( $("#userPw").val() != $("#pwConfirm").val() ) {
				alert("비밀번호 확인란을 확인하세요");
			} else if( $("#userName").val() == '') {
				alert("이름은 필수사항입니다");
			} else if( $("#userPhone2").val() == '') {
				alert("연락처는 필수사항입니다");
			} else if( $("#userEmail1").val() == '') {	
				alert("이메일은 필수사항입니다");
			} else if( $("#addrZipNum").val() == '') {
				alert("주소는 필수사항입니다");
			} else if( $("#addrBasic").val() == '') {
				alert("주소는 필수사항입니다");
			} else if( confirm("회원가입 하시겠습니까?")) {
				$("#regForm").submit();
			}
		})
		//회원가입페이지로 이동
		$("#loginBtn").click(function() {
			location.href = "userLogin";
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
    		/* 
    		document.form.roadFullAddr.value = roadFullAddr;
    		document.form.roadAddrPart1.value = roadAddrPart1;
    		document.form.roadAddrPart2.value = roadAddrPart2;
    		document.form.addrDetail.value = addrDetail;
    		document.form.engAddr.value = engAddr;
    		document.form.jibunAddr.value = jibunAddr;
    		document.form.zipNo.value = zipNo;
    		document.form.admCd.value = admCd;
    		document.form.rnMgtSn.value = rnMgtSn;
    		document.form.bdMgtSn.value = bdMgtSn;
    		document.form.detBdNmList.value = detBdNmList;
    		// 2017년 2월 추가제공 
    		document.form.bdNm.value = bdNm;
    		document.form.bdKdcd.value = bdKdcd;
    		document.form.siNm.value = siNm;
    		document.form.sggNm.value = sggNm;
    		document.form.emdNm.value = emdNm;
    		document.form.liNm.value = liNm;
    		document.form.rn.value = rn;
    		document.form.udrtYn.value = udrtYn;
    		document.form.buldMnnm.value = buldMnnm;
    		document.form.buldSlno.value = buldSlno;
    		document.form.mtYn.value = mtYn;
    		document.form.lnbrMnnm.value = lnbrMnnm;
    		document.form.lnbrSlno.value = lnbrSlno;
    		// 2017년 3월 추가제공/
    		document.form.emdNo.value = emdNo;
    		*/
    }
    
    </script>
    
    
    <script>
	/* 
	//닉네임 중복체크
	//1. blur제이쿼리를 이용해서 nickConfirm으로 에이잭스 요청을 보내 중복여부를 확인합니다.
	//2. nickConfirm에서는 idConfirm메서드를 재활용하여 처리합니다
	//3. 맵퍼에서는 idConfrim의 동적쿼리를 이용해서 처리합니다
	//4. 중복이라면 border색상을 빨강색 msgNick에 "중복된닉네임입니다"
	//	 중복이 아니라면 border색상을 그린, msgNick에 "사용가능합니다" 출력
	$("#userNick").blur(function() {
		
		if( $("#userNick").val() == '') { //공백이라면 종료
			return;
		}
		var userNick = $("#userNick").val();
		$.ajax({
			type:"post",
			url:"nickConfirm",
			data: JSON.stringify({"userNick": userNick}),
			contentType : "application/json; charset=utf-8",
			success: function(result) {
				if(result == 0) { //중복된 닉네임이 없음
					$("#userNick").css("border-color", "green");
					$("#msgNick").html("사용 가능한 닉네임입니다");
				} else {
					$("#userNick").css("border-color", "red");
					$("#msgNick").html("중복된 닉네임입니다");
				}
			},
			error: function(status) {
				
			}
		})
	})
	//조건
	} else if( $("#userNick").val().length >= 9
		|| $("#userNick").val() == ''
		|| $("#userNick").css("border-color") == 'rgb(255, 0, 0)' ){
		alert("닉네임은 8글자 이하 또는 중복 일 수 없습니다");
	
	 */
    </script>
</body>
</html>