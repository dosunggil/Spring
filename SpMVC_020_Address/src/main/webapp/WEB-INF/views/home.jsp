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
<style>
#table {
	width: 500px;
	margin: 20px;
	border-collapse: collapse;
	border: 1px solid black;
}

#table td, #table th {
	width: 122px;
	border: 1px solid black;
}

.page-box {
	width: 90%;
	margin: 15px auto;
	padding: 16px;
	border: 1px solid blue;
}

.page-body {
	list-style: none;
	display: flex;
	justify-content: center;
	align-items: center;
}
.page-link {
	padding: 0.5rem 0.7rem;
	line-height: 1.25;
	color : #007bff;
	background-color: #fff;
	border : 1px solid #DEE2E6;
	text-decoration: none;
}
.page-item {
margin: 2px}
.page-link:hover {
	color : #0056b3;
	background-color: #e9eecf;
	border-color : #dee2ef
}
.page-link:focus {
z-index:3;
outline: 0;
box-shadow: 0 0 0 0.2rem rgba(0,123,255,0.25);}
</style>
</head>
<body>
	<h1>주소록</h1>
	<form method="POST">
		<input hidden="hidden" name="a_seq" data-seq="${ADDR.a_seq}"
			value='<c:out value="${ADDR.a_seq }" default="0" ></c:out>'>>
		<input name="a_name" value="${ADDR.a_name}" placeholder="이름">
		<input name="a_tel" value="${ADDR.a_tel}" placeholder="전화번호">
		<input name="a_address" value="${ADDR.a_address}" placeholder="주소">
		<button>저장</button>
		<table id="table">
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
			<c:forEach items="${AddrList}" var="ADDR">
				<tr>
					<td><a href="${rootPath}/detail?seq=${ADDR.a_seq}">${ADDR.a_name}</a></td>
					<td>${ADDR.a_tel}</td>
					<td>${ADDR.a_address}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<%@ include file="/WEB-INF/views/pagination.jsp"%>
</body>
</html>