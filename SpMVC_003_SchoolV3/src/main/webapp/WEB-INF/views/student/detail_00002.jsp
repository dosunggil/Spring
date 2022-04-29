<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
section {
	display: flex;
	flex-direction: column;
}
table {
border-collapse: collapse;
border : 2px solid #ddd;
width: 60%;
margin: 0 auto;
}
tr:not(:last-child) {
border-bottom: 1px solid #ddd;}

th {
background-color: #eee;
}
td {
padding : 5px;}

div.botton-box {
width:60%;
margin:30px auto;
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
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jsp"%>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
	<section>
		<table>
			<tr>
				<th>이름</th>
				<td>박종훈</td>
				<th>학년</th>
				<td>4</td>
			</tr>
			<tr>
				<th>학번</th>
				<td>00002</td>
				<th>전공</th>
				<td>토목공학과</td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="3">경기 화성시</td>
			</tr>
		</table>
		<div class="botton-box"><button>학생정보 수정</button></div>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>