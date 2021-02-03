<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body {
		background-image: url("/Library/img/도서관1.jpg");
		background-repeat: no-repeat;
		background-size: cover;
	}
</style>
<jsp:include page="../main/menu.jsp" />

<div class="w3-content" style="max-width:2000px;margin-top:46px">
	<div align="center">
		<div>
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">Member List</h1>
		</div>
		<div>
			<table border="1" style="background-color: white;">
				<tr>
					<th width="150">아이디</th>
					<th width="150">닉네임</th>
					<th width="200">전화번호</th>
					<th width="200">주 소</th>
					<th width="100">권한</th>
				</tr>
				<c:if test="${empty list }">
					<tr><td colspan="5" align="center">도서목록이 없습니다.</td></tr>
				</c:if>
				<c:if test="${not empty list }">
					<c:forEach var="vo" items="${list }">
						<tr style="cursor: pointer;" class="row" onClick="">
							<td align="center">${vo.memberId }</td>
							<td align="center">${vo.memberName }</td>
							<td align="center">${vo.memberTel }</td>
							<td align="center">${vo.memberAddress }</td>
							<td align="center">${vo.memberAuth }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div><br/>
		<div>
			<button type="button" onclick="location.href='main.do'">돌아가기</button>	
		</div>
	</div>
</div>
</body>
</html>