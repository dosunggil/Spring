<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<%@ include file="/WEB-INF/views/books/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/views/books/header.jsp"%>
	<form method="POST">
	<div>
		<input name="isbn" id="isbn" placeholder="ISBN" value="${BOOK.isbn}"
		<c:if test="${not empty BOOK.isbn}"> 
		readonly="readonly" </c:if>> 
		<input name="title" id="title" placeholder="도서명 입력" value="${BOOK.title}">
	</div>
	<div>
		<input name="author" placeholder="저자" value="${BOOK.author}"> 
		<input name="publisher"	placeholder="출판사" value="${BOOK.publisher}"> 
		<input name="pubdate" placeholder="출판일" value="${BOOK.pubdate}">
		<input name="price" type="number" placeholder="가격" value="${BOOK.price}">
	</div>
	<div>
		<input name="link" placeholder="자세히보기" value="${BOOK.link}"> 
		<input name="image"	placeholder="이미지경로" value="${BOOK.image}">
		<input name="discount"	placeholder="할인가격" value="${BOOK.discount}">
	</div>
	<input name="description" placeholder="내용을 입력하세요" value="${BOOK.description}">
	<button type="submit">저장</button>
</form>
	
	<a href="${rootPath}/books/insert">저장</a>
	<a href="${rootPath}/books/detail">새로작성</a>
	<a href="${rootPath}/books/list">리스트보기</a>
</body>
</html>