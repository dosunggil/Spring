<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<%@ include file="/WEB-INF/views/books/head.jsp"%>
<body>
	<%@ include file="/WEB-INF/views/books/header.jsp"%>
	<table class="list2">
		<thead>
			<tr>
				<th>No.</th>
				<th>ISBN</th>
				<th>도서명</th>
				<th>출판사</th>
				<th>저자</th>
				<th>출판일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${BOOKS}" var="BOOK" varStatus="INDEX">
				<tr data-isbn="${BOOK.isbn}">
 					<td>${INDEX.count}</td> 
					<td>${BOOK.isbn}</td>
					<td>${BOOK.title}</td>
					<td>${BOOK.publisher}</td>
					<td>${BOOK.author}</td>
					<td>${BOOK.pubdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<a class="add" href="${rootPath}/books/insert2">도서정보추가</a>
</body>
</html>