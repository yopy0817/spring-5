<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 파일 업로드에서는 enctype(인코딩타입)을 multipart/form-data으로 반드시 설정해야합니다 -->
	<form action="upload_ok" method="post" enctype="multipart/form-data">
		파일선택:<input type="file" name="file"><br>
		<input type="submit" value="전송"><br>
	</form>
	 

</body>
</html>