<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css">
	body {
		background-image: url("/Library/img/바다2.jpg");
		background-repeat: no-repeat;
		background-size: cover;
	}
	input {
		border: none;
		width: 70%;
	}
</style>
<script type="text/javascript">
	function formCheck(){
		if(frm.memberPassword.value != frm.memberPassword1.value){
			alert("패스워드 불일치");
			frm.memberPassword.value = null;
			frm.memberPassword1.value = null;
			frm.memberPassword.focus();
			return false;
		}
		return true;
	}
	
	function idCheck(str){
		var url = "idCheck.do?memberId="+str;
		if(str == ""){
			alert("아이디 입력하시오");
			frm.memberId.focus();
		}else{
			window.open(url,"아이디 중복확인", "width=200, heigth=100, top=100, left=100");
		}
	}
</script>
<jsp:include page="../main/menu.jsp" />
<div class="w3-content" style="max-width:1300px;margin-top:46px">
<div align="center">
	<h1 style="font-family: Georgia, Serif; font-size: 50px; font-weight: bold; font-style: italic; color: white;">Sign Up</h1>
 <div>
	<form id="frm" name="frm" onsubmit="formCheck()" action="memberJoin.do" method="post">
	 <div>
		<table border="1" style="background: white; width: 800px;">
			<tr>
				<th width="150">아이디</th>
				<td width="250">
					<input type="text" id="memberId" name="memberId" size="20" required="required">
					<button type="button" onclick="idCheck(memberId.value)" style="font-size: 14; ">중복체크</button>
				</td>	
			</tr>
			<tr>
				<th width="150">닉네임</th>
				<td width="200">
					<input type="text" id="memberName" name="memberName" size="20" required="required" style="background: #bababa">
					</td>
			</tr>		
			<tr>
				<th width="150">비밀번호</th>
				<td width="200">
					<input type="password" id="memberPassword" name="memberPassword" size="20" required="required"></td>
			</tr>		
			<tr>
				<th width="150">비밀번호 확인</th>
				<td width="200"><input type="password" id="memberPassword1" name="memberPassword1" size="20" required="required" style="background: #bababa"></td>
			</tr>		
			<tr>
				<th width="150">전화번호</th>
				<td width="200">
					<input type="text" id="memberTel" name="memberTel" size="20" required="required"></td>
			</tr>  
			<tr>
				<th width="150">회원 주소</th>
				<td width="200">
					<input type="text" id="memberAddress" name="memberAddress" size="20" required="required" style="background: #bababa"></td>
			<tr>
		</table>
	  </div><br/>	
	  	<div>
	  			<button type="submit">회원가입</button>&nbsp;&nbsp;
	  			<button type="reset">취소</button>&nbsp;&nbsp;
	  			<button type="button" onclick="location.href='main.do'">홈 가기</button>
	  	</div>
	 </form>		
	</div>
</div>	
</div>
</body>
</html>