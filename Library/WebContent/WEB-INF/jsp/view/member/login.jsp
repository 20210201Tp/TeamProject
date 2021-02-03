<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
	body {
		background-image: url("/Library/img/기차.jpg");
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
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">Sign In</h1>
		</div>
		<form id="frm" name="frm" action="login.do" method="post">
			<div>
				<table border="1" style="background: white;">
					<tr>
						<th width="100">아 이 디</th>
						<td width="150">
							<input type="text" id="memberId" name = "memberId" style="border: none;">
						</td>
					</tr>
					<tr>
						<th width="100">패스워드</th>
						<td width="150">
							<input type="password" id="memberPassword" name = "memberPassword" style="border: none; background: #bababa;">
						</td>	
					</tr>
				</table>
			</div><br>
			<div>
				<button type="submit">로그인</button>&nbsp;&nbsp;
				<button type="button" onclick="location.href='main.do'">홈 가기</button>
			</div>	
		</form>
	</div>
</div>
</body> 
</html>