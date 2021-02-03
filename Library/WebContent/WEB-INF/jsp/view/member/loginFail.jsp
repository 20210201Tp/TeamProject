<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	body {
		background-image: url("/Library/img/바다2.jpg");
		background-repeat: no-repeat;
		background-size: cover;
	}
	input {
		width: 95%;
	}
</style>

<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:1300px;margin-top:46px">
	<div align="center">
			<div>
				<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">로그인 실패</h1>
			</div>
		<button type="button" onclick="location.href='main.do'">홈 가기</button>
	</div>
</div>
</body>
</html>