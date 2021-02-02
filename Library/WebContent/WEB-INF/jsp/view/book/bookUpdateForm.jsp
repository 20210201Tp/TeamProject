<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	body {
		background-image: url("/Library/img/연못.jpg");
		background-repeat: no-repeat;
		background-size: cover;
	}
</style>
<style type="text/css">
	textarea{
		height: 400px;
	}
	input{
		width: 100%;
    	padding: 0;
 		border-width: 0;
	}
</style>
<jsp:include page="../main/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width:1300px;margin-top:46px">
	<div align="center">
		<div>
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">Write</h1>
		</div>
		<div>
			<form action="bookUpdate.do" id="frm" name="frm" method="post">
				<table border="1" style="background-color: white;">
					<tr>
						<th>도서코드</th>
						<td><input type="text" id="bookCode" name="bookCode" style="border: none;" readonly="readonly" value="${vo.bookCode }"></td>
						<th>도서명</th>
						<td><input type="text" id="bookName" name="bookName" style="border: none;" required="required" value="${vo.bookName }"></td>
					</tr>
				</table><br/>
				<button type="submit">도서수정</button> &nbsp;
				<button type="reset">취소</button> &nbsp;
				<button type="button" onclick="history.back()">돌아가기</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>