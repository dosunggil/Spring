<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/nav.jsp" %>
	<h1>${my_name}님 안녕하세요!!</h1>
	<h2>30 x 40 : ${30*40}</h2>
	<h3>1 &lt; 9 : ${1<9}</h3>
	<h3>1 &gt; 9 : ${1>9}</h3>
	<h3>${false}</h3>
	<h3>3 == 3 : ${3 == 3 }</h3>
	<h3>3 == 3 : ${3 eq 3 }</h3>
	<h3>1 &lt; 9 : ${1 lt 9}</h3>
	<h3>1 =&gt; 9 : ${1 <=  9 }</h3>
	<h3>1 =&gt; 9 : ${1 ge 9 }</h3>
	<h3>9 나누기 3 : ${(9 div 3)}</h3>
	<h3>9 나누기 4 의 나머지: ${9 mod 4}</h3>
	
	<ul>
		<li>${ST[0]} </li>
		<li>${ST[1]} </li>
		<li>${ST[2]} </li>
		<li>${ST[3]} </li>
		<li>${ST[4]} </li>
	</ul>
	
</body>
</html>