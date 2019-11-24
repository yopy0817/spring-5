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
                <div class="col-xs-12 content-wrap">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    <form action="registForm" action="post" name="regForm">
                    <table class="table">
                        <tbody class="t-control">
                            <tr>
                                <td class="t-title">NAME</td>
                                <td><input class="form-control input-sm" name="writer" value=${sessionScope.user_id } readonly></td>
                            </tr>
                            <tr>
                                <td class="t-title">TITLE</td>
                                <td><input class="form-control input-sm" name="title"></td>
                            </tr>
                            <tr>
                                <td class="t-title">COMMENT</td>
                                <td>
                                <textarea class="form-control" rows="7" name="content"></textarea>
                                </td>                 
                            </tr>
                        </tbody>
                    </table>
                    <div class="titlefoot">
                        <button type="button" class="btn" id="freeRegist">등록</button>
                        <button type="button" class="btn" id="freeList">목록</button>
                    </div>
                    
                    </form>
                </div>
            </div>    
       </div>
    </section>
    <%@ include file="../include/footer.jsp" %>
    
    <script>
    	var freeList = document.getElementById("freeList");
    	freeList.onclick = function() {
    		location.href = "freeList"; 
    	}
    	
    	var freeRegist = document.getElementById("freeRegist");
    	freeRegist.onclick = function() {
    		
    		if(document.regForm.writer.value == '') {
    			alert("작성자는 필수 사항입니다");
    			document.regForm.writer.focus();
    			return;
    		} else if(document.regForm.title.value == '') {
    			alert("제목은 필수 사항입니다");
    			document.regForm.regForm.focus();
    			return;
    		} else {
    			//버튼태그는 반드시 type이 버튼이어야 폼에서 동작을 하지 않습니다
    			document.regForm.submit();
    		}
    		
    		
    	}
    	//폼검사
    	
    	
    	
    	
    </script>
    
    
    
    
    
    
</body>
</html>