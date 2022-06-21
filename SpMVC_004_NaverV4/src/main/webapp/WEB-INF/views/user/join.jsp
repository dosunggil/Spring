<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE-edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<style>
	form.join {
	width : 70%;
	margin: 20px auto;
	padding: 15px;}
	form.join input, form.join button {
		margin: 5px;
	
	}
</style>
<script src="${rootPath}/resources/js/join.js?001"></script>
</head>
<body>
<form method="post" class="w3-container w3-card-4 join">

	<h2>회원가입</h2>
	<label>User Name(ID)</label>
	<input id="username" name="username" placeholder="USERNAME" class="w3-input w3-border">
	<label>비밀번호</label>
	<input id="password" name="password" placeholder="PASSWORD"class="w3-input w3-border">
	<label>비밀번호 확인</label>
	<input id="re_password" name="re_password" placeholder="RE_PASSWORD"class="w3-input w3-border">
	<label>이메일</label>
	<input id="email" name="email" placeholder="EMAIL"class="w3-input w3-border">
	<label>이름</label>
	<input id="name" name="name" placeholder="NAME"class="w3-input w3-border">
	<label>닉네임</label>
	<input id="nickname" name="nickname" placeholder="NICKNAME"class="w3-input w3-border">
	
	<button id="btn-join" class="w3-button w3-blue" type="button">회원가입</button>

</form>

</body>
</html>