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
	function editAlert() {
		var yn = confirm("대출하시겠습니까?")
		if(yn) {
			frm.action="bookDecrease.do";
			alert("대출 완료!");
			frm.submit();
		}
	}
	
	function deleteAlert() {
		var yn = confirm("삭제하시겠습니까?")
		if(yn) {
			frm.action="bookDelete.do";
			frm.submit();
		}
	}
	
	function updateAlert() {
		var yn = confirm("수정하시겠습니까?")
		if(yn) {
			frm.action="bookUpdateForm.do";
			frm.submit();
		}
	}
</script>


<jsp:include page="../main/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<div>
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">Books List</h1>
		</div>
			<form action="bookUpdate.do" id="frm" name="frm" method="post">
				<input type="hidden" id="bookCode" name="bookCode" value="${vo.bookCode }">
				<input type="hidden" id="bCount" name="bCount" value="${vo.bCount }">
				<input type="hidden" id="memberId" name="memberId" value="${sMemberId }">
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
				<tr>
					<td align="center">${vo.bookCode }</td>
					<td>&nbsp;${vo.bookName }</td>
					<td align="center">${vo.quantity }</td>
					<td align="center">${vo.bCount }</td>
					<c:choose>
						<c:when test="${vo.bCount ne 0}">
							<td align="center">대출 가능</td>
						</c:when>
						<c:when test="${vo.bCount eq 0}">
							<td align="center">대출 불가</td>
						</c:when>
					</c:choose>
				</tr>
				<tr>
					<td colspan="5"><img src="/Library/img/바다.jpg"></td>
				</tr>
			</table>
		</div><br/>
		<div>
			<c:choose>
				<c:when test="${vo.bCount ne 0}">
					<button type="button" onclick=editAlert()>도서대출</button>
				</c:when>
				<c:when test="${vo.bCount eq 0}">
					<button style="background: #f24a41;">대출불가</button>
				</c:when>
			</c:choose>
				&nbsp;
			<button type="button" onclick="history.back()">돌아가기</button>
			<c:if test="${sMemberAuth eq 'ADMIN' }">
				&nbsp;<button type="button" onclick=updateAlert()>수정</button>
				&nbsp;<button type="button" onclick=deleteAlert()>삭제</button>
			</c:if>
		</div>
	</div>
</div>
</body>
</html>