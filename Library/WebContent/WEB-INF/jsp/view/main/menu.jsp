<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: "Lato", sans-serif}
.mySlides {display: none}
button{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  height:40px;
  width: 120px;
  font-size:1.0em;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
button:hover{
  background:#fff;
  color:#1AAB8A;
}
button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

td, th {
  border: 1px solid #dddddd;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #bababa;
}
</style>
<script type="text/javascript">
	function LoginPlz() {
		alert("로그인 후 이용 가능합니다.");
	}
</script>
<body>
<c:choose>
	<c:when test="${sMemberId ne null }">
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
  	<img alt="" src="Library/img/연못.jpg">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="main.do" class="w3-bar-item w3-button w3-padding-large">HOME</a>
    <c:if test="${sMemberAuth eq 'ADMIN' }">
    	<a href="memberList.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">MEMBER LIST</a>
    	<a href="adminPage.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ADMIN</a>
    </c:if>
    <c:if test="${sMemberAuth eq 'USERS' }">
    	<a href="memberPage.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">MY PAGE</a>
    </c:if>
    <a href="booksList.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">BOOKS</a>
    <a href="logout.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">SIGN OUT</a>
    <div class="w3-dropdown-hover w3-hide-small">
      <button class="w3-padding-large w3-button" title="More">${sMemberId }&nbsp;&nbsp;<i class="fa fa-caret-down"></i></button>     
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
      	<c:if test="${sMemberAuth eq 'ADMIN' }">
      		<a href="adminPage.do" class="w3-bar-item w3-button">ADMIN</a>
      		<a href="memberList.do" class="w3-bar-item w3-button">MEMBER LIST</a>
      	</c:if>
      	<c:if test="${sMemberAuth eq 'USERS' }">
        	<a href="memberPage.do" class="w3-bar-item w3-button">MY PAGE</a>
        	<a href="booksList.do" class="w3-bar-item w3-button">BOOKS</a>
        </c:if>
        <a href="logout.do" class="w3-bar-item w3-button">SIGN OUT</a>
      </div>
    </div>
  </div>
</div>
</c:when>
<c:otherwise>
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
  	<img alt="" src="Library/img/연못.jpg">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="main.do" class="w3-bar-item w3-button w3-padding-large">HOME</a>
    <a onclick="LoginPlz()" class="w3-bar-item w3-button w3-padding-large w3-hide-small">BOOKS</a>
    <a href="loginForm.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">SIGN IN</a>
    <a href="memberJoinForm.do" class="w3-bar-item w3-button w3-padding-large w3-hide-small">SIGN UP</a>
    <div class="w3-dropdown-hover w3-hide-small">
      <button class="w3-padding-large w3-button" title="More">더보기&nbsp;&nbsp;<i class="fa fa-caret-down"></i></button>     
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="loginForm.do" class="w3-bar-item w3-button">SIGN IN</a>
        <a href="memberJoinForm.do" class="w3-bar-item w3-button">SIGN UP</a>
      </div>
    </div>
  </div>
</div>
</c:otherwise>
</c:choose>