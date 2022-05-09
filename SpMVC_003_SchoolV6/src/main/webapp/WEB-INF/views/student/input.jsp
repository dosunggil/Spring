<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<style>
form {
	width : 95%;

}
form div {
	width:80%;
	botder:1px solid blue;
}
form label, form input {
	padding : 8px;
	display: inline-block;
}
form label {
width:30%;
text-align: right;}

form input {
width: 65%;
margin-left : 5px;}

form div:last-of-type {
	text-align: right;
}

</style>
<h1>학생정보 등록</h1>
<form method ="POST">
	<div>
		<label>학번</label>
		<input type="text" name="st_num">	
	</div>
	<div>
		<label>이름</label>
		<input type="text" name="st_name">	
	</div>
	<div>
		<label>학과</label>
		<input type="text" name="st_dept">	
	</div>
	<div>
		<label>학년</label>
		<input type="text" name="st_grade">	
	</div>
	<div>
		<label>전화번호</label>
		<input type="text" name="st_tel">	
	</div>
	<div>
		<label>주소</label>
		<input type="text" name="st_addr">	
	</div>
	<div><button>저장</button></div>
</form>