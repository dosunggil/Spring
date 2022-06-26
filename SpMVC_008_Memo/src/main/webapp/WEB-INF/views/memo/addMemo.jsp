<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<body>
	<div class="addMemo-main">
		<form method="POST" enctype="multipart/form-data">
			<div class="addMemo-container">
				<input hidden="hidden" name="m_seq"
					value='<c:out value="${MEMOVO.m_seq }" default="0" ></c:out>'>

				<div class="title-box addMemo-box">
					<input class="input" placeholder="새 메모" name="m_title" value="${MEMOVO.m_title}" />
					<div class="date-time">${MEMOVO.m_date} - ${MEMOVO.m_time}
					</div>
				</div>
				<div class="memo-box addMemo-box">
					<textarea class="memo-textarea" onkeydown="resize(this)"
						onkeyup="resize(this)" placeholder="" name="m_memo">${MEMOVO.m_memo}</textarea>
				</div>
				<div class="img-box">
					<img class="img-img" src="${rootPath}/upload/${MEMOVO.m_image}"
						onerror="this.onerror=null; this.style.display='none'">
				</div>
				<div class="button-container">
					<div class="btn-edit-photo button">
						<input accept=".gif, .jpg, .png" type="file" name="mfile"
							value="${rootPath}/upload/${MEMOVO.m_image}" id="cho-photo"
							style='display: none;' onchange="setThumbnail(event);" multiple>
							 <label class="btn-edit-photo"	for="cho-photo">사진 선택</label>
					</div>
					<button class="button">저장</button>
					<a class="button" href="${rootPath}/memo/${MEMOVO.m_seq}/delete">삭제</a>
				</div>

			</div>
		</form>
	</div>

</body>
</html>