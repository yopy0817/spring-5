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
	
	<div align="center">
		<h2>게시글 목록</h2>
		<table>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>내용</td>
			</tr>
			
			<c:forEach var="good" items="${boardList }" varStatus="num">
			<tr>
				<td>${good.num }</td>
				<td>${good.name }</td>
				<td>${good.title }</td>
				<td>${good.content }</td>
				<td><input type="button" value="삭제" onclick="location.href='boardDelete?num=${good.num}'"></td>
			</tr>
			</c:forEach>
		</table>
		<a href="boardRegister">게시글 작성</a>
	</div>
	
</body>
</html>