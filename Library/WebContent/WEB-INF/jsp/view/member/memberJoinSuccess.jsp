<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
<div align="center">
	<div>
		<h1>${vo.memberName }님 ${vo.memberId} 회원가입 완료</h1>
		<button type="button" onclick="location.href='main.do'">홈 가기</button>
	</div>
</div>
</body>
</html>