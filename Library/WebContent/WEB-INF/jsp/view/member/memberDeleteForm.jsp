<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
body {
	background-image: url("/Library/img/도서관1.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<script type="text/javascript">
	function memberDel() {
		var yn = confirm("회원탈퇴를 하시겠습니까?");
		
		if(yn) {
			if("${sMemberId}" == document.getElementById('memberId').value){
				frm.submit();
			} else {
				alert("아이디 혹은 비밀번호를 확인해주세요!");
			}
		}
	}
</script>

<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width: 1300px; margin-top: 46px">
	<div align="center">
		<div>
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">회원탈퇴 페이지</h1>
		</div>
		<form id="frm" name="frm" action="memberDelete.do" method="post">
			<table border="1" style="background: white;">
				<tr>
					<th width="100">아 이 디</th>
						<td width="150">
							<input type="text" id="memberId" name="memberId" style="border: none;">
						</td>
					</tr>
					<tr>
						<th width="100">패스워드</th>
						<td width="150">
							<input type="password" id="memberPassword" name="memberPassword" style="border: none; background: #bababa;">
						</td>	
					</tr>
			</table>
		</form><br/>
		<button onclick="memberDel()">회원탈퇴</button>
	</div>
</div>
</body>
</html>