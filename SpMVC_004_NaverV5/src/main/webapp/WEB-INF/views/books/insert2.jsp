<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<%-- <%@ include file="/WEB-INF/views/books/head.jsp" %> --%>
<body>
<%-- 	<%@ include file="/WEB-INF/views/books/header.jsp"%> --%>
	<form method="POST" class="w3-container">
	<div>
		<input class="w3-input" name="isbn" id="isbn" placeholder="ISBN" value="${BOOK.isbn}"
		<c:if test="${not empty BOOK.isbn}">readonly="readonly" </c:if>> 
		<input class="w3-input" name="title" id="title" placeholder="도서명 입력" value="${BOOK.title}">
	</div>
	<div>
		<input class="w3-input" name="author" placeholder="저자" value="${BOOK.author}"> 
		<input class="w3-input" name="publisher"	placeholder="출판사" value="${BOOK.publisher}"> 
		<input class="w3-input" name="pubdate" placeholder="출판일" value="${BOOK.pubdate}">
		<input class="w3-input" name="price" type="number" placeholder="가격" value="${BOOK.price}">
		<input class="w3-input" name="link" placeholder="자세히보기" value="${BOOK.link}"> 
		<input class="w3-input" name="image"	placeholder="이미지경로" value="${BOOK.image}">
	</div>
	<div>
		
		<input class="w3-input" name="discount"	placeholder="할인가격" value="${BOOK.discount}">
	</div>
	<input class="w3-input" name="description" placeholder="내용을 입력하세요" value="${BOOK.description}">
	<textarea  class="w3-input" rows="10" cols=""></textarea>
	<button class="w3-button w3-indigo book-save" type="button">저장</button>
</form>
	
	
	<a href="${rootPath}/books/list">리스트보기</a>
</body>
</html>