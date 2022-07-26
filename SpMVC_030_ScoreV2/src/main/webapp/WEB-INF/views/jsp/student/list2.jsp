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
<h1> 학생 리스트 </h1>
<ul>
	<c:forEach items="${STLIST}" var="ST">
	<li>학번 : ${ST.st_num}</li>
	<li>이름 : ${ST.st_name}</li>
	<li>학년 : ${ST.st_grade}</li>
	<li>학과 : ${ST.st_dept}</li>
	<li>주소 : ${ST.st_addr}</li>
	<li>전화번호 : ${ST.st_tel}</li><br><br>
	</c:forEach>
</ul>
</body>
</html>