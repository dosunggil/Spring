<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<style>
table{
width:95%;
margin : 10px auto;
border-collapse: collapse;
border:1px solid green;
}
th, td {
	text-align: left;
}
div.btn-box {
width:95%;
margin: 5px auto;
text-align: right;}

</style>
<script src="${rootPath}/resources/js/std_list.js?ver=2022-05-10-001"></script>
<table>
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>전화번호</th>
	</tr>
	<c:forEach items="${ST_LIST}" var="ST">
		<tr>
			<td>${ST.st_num}</td>
			<td>${ST.st_name}</td>
			<td>${ST.st_tel}</td>
		</tr>
	</c:forEach>
</table>

<div class ="btn-box">
	<button class="btn-blue std-input" >학생정보 등록</button>
	<form action="${rootPath}/score">
		<button type="button"
		class="btn-red">서버로 보내기</button>
	</form>

</div>