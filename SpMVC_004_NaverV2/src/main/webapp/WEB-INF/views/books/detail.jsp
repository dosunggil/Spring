<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/books/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/views/books/header.jsp"%>
	<table class="detail">
		<tr>
			<td>도서코드</td>
			<td></td>
			<td>도서명</td>
			<td></td>
		</tr>	
		<tr>
			<td>출판사</td>
			<td></td>
			<td>저자</td>
			<td></td>
		</tr>	
		<tr>
			<td>출판일자</td>
			<td></td>
			<td>정가</td>
			<td></td>
		</tr>	
	</table>
	<a href="${rootPath}/books/insert">저장</a>
	<a href="${rootPath}/books/detail">새로작성</a>
	<a href="${rootPath}/books/insert">리스트보기</a>

</body>
</html>