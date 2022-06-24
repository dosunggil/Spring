<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<body>
<form method="POST" enctype="multipart/form-data">
	<h1>메모 추가하기</h1>
		<input hidden="hidden" name="m_seq" value="${MEMOVO.m_seq}">
		<textarea rows="6" placeholder="메모 내용" name="m_memo" >${MEMOVO.m_memo}</textarea>
		<!-- <input type="file" name="mfile" multiple="multiple" accept="images/*"> -->
		
		<img src="${rootPath}/upload/${MEMOVO.m_image}" >
							<div class="cho-edit-btns">
								<input accept=".gif, .jpg, .png" type="file" name="mfile"
								value="${rootPath}/upload/${MEMOVO.m_image}"
									id="cho-photo" style="display: none;"> <label
									class="btn-edit-photo" for="cho-photo">사진 선택</label>
									</div>
		
		
		<button>등록하기</button>

</form>

</body>
</html>