<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
	tr.row:hover{
		background-color: lightyellow;
	}
	body {
		background-image: url("/Library/img/바다2.jpg");
		background-repeat: no-repeat;
		background-size: cover;
	}
</style>
<script type="text/javascript">
	function formSubmit(str) {
		frm.bookCode.value = str;
		frm.submit();
	}
</script>


<jsp:include page="../main/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<div>
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">Books List</h1>
		</div>
			<form action="bookInfo.do" id="frm" name="frm" method="post">
				<input type="hidden" id="bookCode" name="bookCode">
			</form>
		<div>
			<table border="1" style="background-color: white;">
				<tr>
					<th width="100">도서코드</th>
					<th width="200">도서명</th>
					<th width="150">기본수량</th>
					<th width="150">현재수량</th>
					<th width="100">상 태</th>
				</tr>
				<c:if test="${empty list }">
					<tr><td colspan="5" align="center">도서목록이 없습니다.</td></tr>
				</c:if>
				<c:if test="${not empty list }">
					<c:forEach var="vo" items="${list }">
						<tr style="cursor: pointer;" class="row" onClick="formSubmit(${vo.bookCode })">
							<td align="center">${vo.bookCode }</td>
							<td>&nbsp;${vo.bookName }</td>
							<td align="center">${vo.quantity }</td>
							<td align="center">${vo.bCount }</td>
							<c:choose>
								<c:when test="${vo.bCount ne 0}">
									<td align="center" style="background: #40f5b5;">대출 가능</td>
								</c:when>
								<c:when test="${vo.bCount eq 0}">
									<td align="center" style="background: #f24a41;">대출 불가</td>
								</c:when>
							</c:choose>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div><br/>
		<div>
			<button type="button" onclick="location.href='bookForm.do'">도서등록</button>	
		</div>
	</div>
</div>
</body>
</html>