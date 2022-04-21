<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	margin: 0 autu;
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
				<th>주소</th>
			</tr>
			<tr>
				<td>0001</td>
				<td>조도성</td>
				<td>수학과</td>
				<td>4</td>
				<td>송정리</td>
			</tr>
			<tr>
				<td>0002</td>
				<td>임수정</td>
				<td>수학과</td>
				<td>4</td>
				<td>서울시</td>
			</tr>
			<tr>
				<td>0003</td>
				<td>이재혁</td>
				<td>수학과</td>
				<td>4</td>
				<td>인천광역시</td>
			</tr>
			<tr>
				<td>0003</td>
				<td>이재혁</td>
				<td>수학과</td>
				<td>4</td>
				<td>인천광역시</td>
			</tr>
			<tr>
				<td>0003</td>
				<td>이재혁</td>
				<td>수학과</td>
				<td>4</td>
				<td>인천광역시</td>
			</tr>
			<tr>
				<td>0003</td>
				<td>이재혁</td>
				<td>수학과</td>
				<td>4</td>
				<td>인천광역시</td>
			</tr>
			<tr>
				<td>0003</td>
				<td>이재혁</td>
				<td>수학과</td>
				<td>4</td>
				<td>인천광역시</td>
			</tr>
			<tr>
				<td>0003</td>
				<td>이재혁</td>
				<td>수학과</td>
				<td>4</td>
				<td>인천광역시</td>
			</tr>
		</table>
		<div class="botton-box"><button><a href="${pageContext.request.contextPath}/student/insert">학생정보등록</a></button></div>
	</section>

	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>