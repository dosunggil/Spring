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
<div>
	<form method="POST">
		<input name="st_num" value="${ST.st_num}" hidden="hidden">
		<input name="st_name" value="${ST.st_name}">
		<input name="st_dept" value="${ST.st_dept}">
		<input name="st_grade" value="${ST.st_grade}">
		<input name="st_tel" value="${ST.st_tel}">
		<input name="st_addr" value="${ST.st_addr}">
		<button>저장</button>
	</form>

</div>

</body>
</html>