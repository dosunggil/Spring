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
	${MEMOVO.m_author} <br>
	${MEMOVO.m_date} <br>
	${MEMOVO.m_time} <br>
	${MEMOVO.m_memo} <br>
	<img src ="${rootPath}/upload/${MEMOVO.m_image.f_imageName}"> <br>
	
	<div><a href="${rootPath}/memo/${MEMOVO.m_seq}/update">수정하기</a></div>
	<div><a href="${rootPath}/memo/${MEMOVO.m_seq}/delete">삭제하기</a></div>

</div>
</body>
</html>