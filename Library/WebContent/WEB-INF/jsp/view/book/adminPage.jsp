<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
	tr.row:hover{
		background-color: lightyellow;
	}
	body {
		background-image: url("/Library/img/바다.jpg");
		background-repeat: no-repeat;
		background-size: cover;
	}
</style>
<script type="text/javascript">
	function formSubmit(str) {
		frm.memberId.value = str;
		frm.submit();
	}
</script>


<jsp:include page="../main/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<div>
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">대출 현황</h1>
		</div>
			<form action="bookInfo.do" id="frm" name="frm" method="post">
				<input type="hidden" id="memberId" name="memberId">
			</form>
		<div>
			<table border="1" style="background-color: white;">
				<tr>
					<th width="150">대출일</th>
					<th width="100">도서코드</th>
					<th width="150">아이디</th>
					<th width="150">반납일</th>
					<th width="150">반납예정일</th>
				</tr>
					<c:forEach var="vo" items="${list }">
						<tr style="cursor: pointer;" class="row" onClick="formSubmit(${vo.memberId })">
							<td align="center">${vo.rentalDate }</td>
							<td align="center">${vo.bookCode }</td>
							<td align="center">${vo.memberId }</td>
							<td align="center">${vo.returnDate }</td>
							<td align="center">${vo.expReturnDate }</td>
						</tr>
					</c:forEach>
			</table>
		</div><br/>
		<div>
			<button type="button" onclick="location.href='bookForm.do'">도서등록</button>	
		</div>
	</div>
</div>
</body>
</html>