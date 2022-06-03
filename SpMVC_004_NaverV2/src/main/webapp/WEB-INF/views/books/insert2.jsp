<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<%@ include file="/WEB-INF/views/books/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/views/books/header.jsp"%>
	<form method="POST">
	<div>
		<input name="isbn" id="isbn" placeholder="ISBN"> 
		<input name="title" id="title" placeholder="도서명 입력">
	</div>
	<div>
		<input name="author" placeholder="저자"> 
		<input name="publisher"	placeholder="출판사"> 
		<input name="pubdate" placeholder="출판일">
		<input name="price" type="number" placeholder="가격">
	</div>
	<div>
		<input name="link" placeholder="자세히보기"> 
		<input name="image"	placeholder="이미지경로">
		<input name="discount"	placeholder="할인가격">
	</div>
	<input name="description" placeholder="내용을 입력하세요" >
	<button type="submit">저장</button>
</form>
	
	<a href="${rootPath}/books/insert">저장</a>
	<a href="${rootPath}/books/detail">새로작성</a>
	<a href="${rootPath}/books/insert">리스트보기</a>
</body>
</html>