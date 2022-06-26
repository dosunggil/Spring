<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<body>
	<header>
		<div class="top-nav">
			<a href="${rootPath}/">성길이의 메모장</a>
		</div>
	</header>
	<main>
		<div class="full-container">
			<div class="memo-listbox">
				<div class="btn-addMemo">+</div>
				<table class="memo-list">
					<c:forEach items="${MEMO}" var="MEMO">
						<tr data-seq="${MEMO.m_seq}">
							<td class="td-date">${MEMO.m_date}</td>
							<td class="td-memo">
								<div class="div-memo">${MEMO.m_title}</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="memo-drop">
			
			</div>
		</div>
	</main>
</body>
</html>