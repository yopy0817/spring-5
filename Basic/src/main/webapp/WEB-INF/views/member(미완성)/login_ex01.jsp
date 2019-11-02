<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>화면요청(화면 URL요청: 컨패스/member/login_ex01)</h2>
	<h2>redirect 확인하기</h2>
	<form action="login" method="post">
		ID: <input type="text" name="id" size="10"><br>
		PW: <input type="password" name="pw" size="10"><br>
		<c:if test="${check eq false}">아이디와 비밀번호를 확인하세요<br></c:if>
		<input type="submit" value="로그인">
	</form>
</body>
</html>