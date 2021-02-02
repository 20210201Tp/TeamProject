<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
<div align="center">
	<div>
		<h1>${vo.memberName }님 {vo.memberId}로 로그인 되었습니다.</h1>
	</div>
	<div>
		<button type="button" onclick="location.href='main.do'">홈 가기</button>
	</div>
</div>
</body>
</html>