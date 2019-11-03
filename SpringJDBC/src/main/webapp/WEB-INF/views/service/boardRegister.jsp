<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>게시글 등록 (화면 URL요청: 컨패스/service/boardRegister)</h2>
	<form action="boardForm" method="post">

		작성자:<input name="name"><br>
		제목:<input name="title"><br>
		내용:<textarea rows="3" name="content"></textarea><br>
		
		<input type="submit" value="등록">
		<input type="button" value="취소" onclick="location.href='boardList'">
	</form>


</body>
</html>