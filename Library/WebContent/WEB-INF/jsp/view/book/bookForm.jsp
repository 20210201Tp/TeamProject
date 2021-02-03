<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	body {
		background-image: url("/Library/img/도서관.jpg");
		background-repeat: no-repeat;
		background-size: cover;
	}
</style>
<style type="text/css">
	textarea{
		height: 400px;
	}
	input{
		width: 99%;
    	padding: 0;
 		border-width: 0;
	}
</style>
<script type="text/javascript">
	function checkLength() {
		bCode = frm.bookCode.value;
		if(bCode.length != 4 || bCode == "0000") {
			if(bCode.length != 4) {
				alert("도서코드는 반드시 4자리여야 합니다.");
				frm.bookCode.value = "0000";
				frm.bookCode.focus();
			} else {
				alert("0000은 입력불가 도서코드입니다.");
				frm.bookCode.value = "0000";
				frm.bookCode.focus();
			}
		} else {
			frm.submit();
		}
	}
</script>
<jsp:include page="../main/menu.jsp" />

<!-- Page content -->
<div class="w3-content" style="max-width:1300px;margin-top:46px">
	<div align="center">
		<div>
			<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">Write</h1>
		</div>
		<div>
			<form action="bookInsert.do" id="frm" name="frm" method="post">
				<table border="1" style="background-color: white;">
					<tr>
						<th>도서코드</th>
						<td>
							<input type="text" id="bookCode" name="bookCode" style="border: none;" required="required" value="0000">
						</td>
						<th>도서명</th>
						<td>
							<input type="text" id="bookName" name="bookName" style="border: none;" required="required">
						</td>
					</tr>
				</table><br/>
				<button type="button" onclick="checkLength()">도서등록</button> &nbsp;
				<button type="reset">취소</button> &nbsp;
				<button type="button" onclick="history.back()">돌아가기</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>