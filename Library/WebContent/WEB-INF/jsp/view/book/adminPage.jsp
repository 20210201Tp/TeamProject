<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
	tr{
		height: 50;
	}
	tr.row:hover{
		background-color: lightyellow;
	}
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
</script>


<jsp:include page="../main/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<div>
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">Loan Status</h1>
		</div>
			<form action="bookReturn.do" id="frm" name="frm" method="post">
				<input type="hidden" id="memberId" name="memberId">
				<input type="hidden" id="bookCode" name="bookCode">
			</form>
		<div>
			<table border="1" style="background-color: white; text-align: center;">
				<tr>
					<th width="150">대출일</th>
					<th width="100">도서코드</th>
					<th width="150">아이디</th>
					<th width="150">반납일</th>
					<th width="150">반납예정일</th>
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
			</table>
		</div>
	</div>
</div>
</body>
</html>