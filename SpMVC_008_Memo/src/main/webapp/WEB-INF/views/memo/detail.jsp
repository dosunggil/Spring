<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<body>
	<div class="detail-main">
		<div class="detail-container">
			<div class="detail-title-box detail-box">${MEMOVO.m_title}</div>
			<div class="detail-memo-box detail-box" >${MEMOVO.m_memo}</div>
			<div class="img-box detail-box">
				<img src="${rootPath}/upload/${MEMOVO.m_image}"
				 onerror="this.onerror=null; this.style.display='none'">
			</div>
			<div>
				<div class="btn-Update" data-seq="${MEMOVO.m_seq}">수정</div>
				<a class="button" href="${rootPath}/memo/${MEMOVO.m_seq}/delete">삭제</a>
			</div>
		</div>

	</div>
</body>
</html>