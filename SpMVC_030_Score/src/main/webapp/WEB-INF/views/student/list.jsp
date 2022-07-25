<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE-edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>

<body>
	<h1>학생 리스트</h1>
	<div class="student body" >
		<c:forEach items="${STLIST}" var="ST">
			<ul class="student list" data-stnum="${ST.st_num}">
				<li class="student stnum">학번 : ${ST.st_num}</li>
				<li class="student stname">이름 : ${ST.st_name}</li>
				<li class="student stgrade">학년 : ${ST.st_grade}</li>
				<li class="student stdept">학과 코드 : ${ST.st_dept}</li>
				<li class="student staddr">주소 : ${ST.st_addr}</li>
				<li class="student sttel">전화번호 : ${ST.st_tel}</li>
			</ul>
		</c:forEach>
	</div>
</body>
</html>