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

</head>
<body>
<form method="post" class="w3-container w3-card-4 login">

	<h2>로그인</h2>
	
	<%--BookController 에서 insert2 / GET method 참고 --%>
	<c:if test="${error =='LOGIN_NEED'}">
	<div class = "w3-red w3-padding-16">로그인이 필요한 서비스입니다.</div>
	</c:if>
	<c:if test="${error =='USERNAME_FAIL'}">
	<div class = "w3-red w3-padding-16">ID 가 없음. 회원가입을 먼저 하세요.</div>
	</c:if>
	<c:if test="${error =='PASSWORD_FAIL'}">
	<div class = "w3-red w3-padding-16">비밀번호를 확인하세요.</div>
	</c:if>
	
	
	<label>User Name(ID)</label>
	<input id="username" name="username" placeholder="USERNAME" class="w3-input w3-border">
	<label>비밀번호</label>
	<input id="password" name="password" placeholder="PASSWORD"class="w3-input w3-border">

	<button id="btn-login" class="w3-button w3-blue" type="button">로그인</button>

</form>
</body>
<script src="${rootPath}/resources/js/login.js?003"></script>
</html>