<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Model 전달자</h2>
	<h2>response(화면 URL요청: 컨패스/response/res_ex01)</h2>
	
	<a href="res_ex02">res_ex02로 이동</a><br>
	<a href="res_ex03">res_ex03로 이동</a><br>
	<a href="res_ex04?id=kim">res_ex04로 이동</a>
	
	<form action="res_ex05" method="post">
		아이디:<input type="text" name="id"><br>
		이름:<input type="text" name="name"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>