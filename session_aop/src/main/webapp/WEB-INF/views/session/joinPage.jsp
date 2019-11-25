<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>AOP를 통한 서비스계층 로그 확인하기</h1>
	<h2>회원가입</h2>
	<hr>
	<form action="joinForm" method="post">
		아이디:<input type="text" name="id"><br>
		비밀번호:<input type="password" name="pw"><br>
		이름:<input type="text" name="name"><br>
		이메일:<input type="text" name="email"><br>
		<input type="submit" value="회원가입">
	</form>

</body>
</html>