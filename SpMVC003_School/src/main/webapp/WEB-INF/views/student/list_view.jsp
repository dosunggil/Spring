<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<style>
section {
	display: flex;
	flex-direction: column;
}

article {
	width: 80%;
	margin: 0 auto;
}

table {
	width: 80%;
	margin: 0 auto;
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	border-collapse: collapse;
}

table tr {
	border-bottom: 1px solid #ddd;
}

th, td {
	padding: 7px;
	text-align: left;
	cursor: pointer;
}

tr:nth-of-type(even) {
	background-color: #eee;
}

tr:not(:first-child):hover {
	background-color: #ddd;
}
div.botton-box {
width:80%;
margin:5px auto;
text-align: right;
padding: 5px 0;

}
div.botton-box button {
display: inline-block;
padding: 12px 16px;
color:white;
background: #636363;
border-radius: 5px;


}
div.botton-box button:hover {
cursor: pointer;}

</style>
<script src="${rootPath}/resources/js/student.js"></script>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jsp"%>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>


	<section>
		<article>통원 진료 받았음</article>
		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>학년</th>
			</tr>
			<c:forEach items="${STUDENTS}" var="stVO"> <!-- var stVO = STUDENTS[0] -->
			<tr>
				<td>${stVO.stNum}</td>
				<td class="name" data-num="${stVO.stNum}">${stVO.stName}</td>
				<td>${stVO.stDept}</td>
				<td>${stVO.intGrade}</td>
			</tr>
			</c:forEach>
		</table>
		<div class="botton-box"><button>
		<a href="${rootPath}}/student/insert">학생정보등록</a></button></div>
	</section>

	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
<script>


</script>
</html>