<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>파라미터 값 전달(화면 URL요청: /request/req_ex02)</h2>
	
	<form action="param" method="post">
		ID: <input type="text" name="id" size="10"><br>
		PW: <input type="password" name="pw" size="10"><br>
		NAME: <input type="text" name="name" size="10"><br>
		AGE: <input type="text" name="age" size="10"><br>
		PHONE: 
		<input type="text" name="phone1" size="5">-
		<input type="text" name="phone2" size="5">-
		<input type="text" name="phone3" size="5"><br>
		<input type="submit" value="전송">
	</form>

	<h2>여러 파라미터 값 전달</h2>
	<form action="param2" method="post">
		<input type="checkbox" name="interest" value="java">자바
		<input type="checkbox" name="interest" value="jsp">JSP
		<input type="checkbox" name="interest" value="spring">스프링
		<input type="checkbox" name="interest" value="oracle">오라클
		<input type="submit" value="전송">		
				
	</form>
	
	
	
	
</body>
</html>