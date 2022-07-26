<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<style>
form.student.input {
	width: 80%;
	margin: 20px auto;
}

form.student.input div {
	display: flex;
	flex-direction: column;
}

form.student.input input, form.student.input button {
	flex: 1;
	padding: 16px 12px;
	margin: 5px;
}
</style>
<form method="POST" class="student input">
	<div>
		<div>
			<input name="st_name" value="${ST.st_name}">
		</div>
		<div>
			<input name="st_dept" value="${ST.st_dept}">
		</div>
		<div>
			<input name="st_grade" value="${ST.st_grade}">
		</div>
		<div>
			<input name="st_tel" value="${ST.st_tel}">
		</div>
		<div>
			<input name="st_addr" value="${ST.st_addr}">
		</div>
		<div>
			<button>저장</button>
		</div>
	</div>
</form>
