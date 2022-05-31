<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE-edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<style> 
* {
box-sizing: border-box;
margin:0;
padding:0;}
html {
WIDTH: 100VW;
height: 100vh;}
body {
width:100%;
height: 100%;
display: flex;
flex-direction: column;}
section {
flex:1;}

	</style>
<link rel="stylesheet" href="${rootPath}/resources/css/table.css">
<link rel="stylesheet" href="${rootPath}/resources/css/modal.css">
<link rel="stylesheet" href="${rootPath}/resources/css/input.css">
<script>
	const rootPath="${rootPath}"
</script>
<script src="${rootPath}/resources/js/input.js?ver=114"></script>
</head>
<body>
	<header>
		<h1>도서정보관리</h1>
	</header>
	<form method="POST" action="${rootPath}/naver/books">
		<div>
		<input name="isbn" id="isbn" placeholder="ISBN">
		<input name="title" id="title" placeholder="도서명 입력">
		</div>
		<DIV>
			<input name="author" placeholder="저자">
			<input name="publisher"placeholder="출판사">
			<input name="pubdate"placeholder="출판일">
			<input name="price" type="number" placeholder="가격">
		</DIV>
		<div>
			<input name="link" placeholder="자세히보기">
			<input name="image" placeholder="이미지경로">
		</div>
		<textarea rows="10"></textarea>
		<button type="button">저장</button>
	</form>
	<footer>
		<address>Copyright &copy; chothegneius@gmail.com</address>
	</footer>
	<section class="modal" id="modal-box">
	
	</section>
</body>
</html>