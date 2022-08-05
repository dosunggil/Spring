<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE-edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
<h1>여기는 join</h1>
<form:form>
	<input name="username" placeholder="아이디"><br>
	<input name="password" placeholder="암호"><br>
	<input name="email" placeholder="이메일"><br>
	<input name="realname" placeholder="실제 이름"><br>
	<input name="nickname" placeholder="닉네임"><br>
	<button>회원가입 </button>
</form:form>
</body>
</html>