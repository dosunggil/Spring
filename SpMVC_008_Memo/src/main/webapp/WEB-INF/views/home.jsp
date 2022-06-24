<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<body>
	<div>
		<table class="memo-list">
			<c:forEach items="${MEMO}" var="MEMO">
				<tr data-seq="${MEMO.m_seq}">
					<td>${MEMO.m_author}</td>
					<td>${MEMO.m_memo}</td>
					<td>${MEMO.m_date}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<a href="${rootPath}/memo/addMemo"> 메모 추가하기</a>
		</div>

	</div>
</body>
</html>