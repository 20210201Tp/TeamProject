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
	function returnBook(code) {
		var yn = confirm("반납하시겠습니까?")
		if(yn) {
		frm.memberId.value = document.getElementById('mId').value;	
		frm.bookCode.value = code;
		alert("반납 완료!");
		frm.submit();
		}
	}
	
	function memberDel() {
		if(document.getElementById('mId') != null) {
			alert("반납을 모두 완료하신 후 회원탈퇴가 가능합니다.");
		} else {
			frm.action = "memberDeleteForm.do";
			frm.submit();
		}
	}
</script>

<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width: 1300px; margin-top: 46px">
	<div align="center">
		<div>
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">My Page</h1>
		</div>
		<table border="1" style="background: white;">
			<tr>
				<th width="200">대출일</th>
				<th width="150">도서코드</th>
				<th width="150">아이디</th>
				<th width="200">반납일</th>
				<th width="200">반납예정일</th>
				<th width="150">반납하기</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td align="center">${vo.rentalDate }</td>
					<td align="center">${vo.bookCode }</td>
					<td align="center">${vo.memberId }</td>
					<td align="center">${vo.returnDate }</td>
					<td align="center">${vo.expReturnDate }</td>
					<c:if test="${vo.returnDate eq null || vo.returnDate eq ''}">
						<td>
							<button onclick="returnBook('${vo.bookCode}')">반납</button>
							<input type="hidden" id="mId" name="mId" value="${vo.memberId }">
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table><br/>
		<button onclick=memberDel()>회원탈퇴</button>
		<form action="bookReturn.do" id="frm" name="frm" method="post">
			<input type="hidden" id="memberId" name="memberId">
			<input type="hidden" id="bookCode" name="bookCode">
		</form>
	</div>
</div>
</body>
</html>