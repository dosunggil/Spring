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
<h1> 자세히보기 </h1>
<form method="POST">
<input hidden="hidden" name="a_seq" data-seq="${ADDR.a_seq}"
			value='<c:out value="${ADDR.a_seq }" default="0" ></c:out>'>>
<input name="a_name"  value="${ADDR.a_name}"  placeholder="이름" >
<input name="a_tel"  value="${ADDR.a_tel}" placeholder="전화번호">
<input name="a_address" value="${ADDR.a_address}" placeholder="주소">
<button>저장</button>
<table>
<tr>
	<th>이름</th>
	<th>전화번호</th>
	<th>주소</th>
</tr>
<tr>
 <td>${ADDR.a_name}</td>
	<td>${ADDR.a_tel}</td>
	<td>${ADDR.a_address}</td>
</tr>

</table>
</form>
<div>수정하기</div>
<a href="${rootPath}/delete/${ADDR.a_seq}">삭제하기</a>
</body>
</html>