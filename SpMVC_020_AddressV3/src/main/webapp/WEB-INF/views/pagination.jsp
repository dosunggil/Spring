<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<div class="page-box">
	<ul class="page-body">
		<li class="page-item"><a class="page-link" href="${rootPath}?pageno=1">1</a></li>
		<c:forEach begin="2" end="9" var="page">
			<li class="page-item"><a class="page-link" href="${rootPath}?pageno=${page}">${page}</a></li>
		</c:forEach>
		<li class="page-item"><a class="page-link" href="${rootPath}?pageno=10">10</a></li>

	</ul>
</div>