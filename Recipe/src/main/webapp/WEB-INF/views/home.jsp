<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요리교실</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/js/all.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: content-box;
}

nav {
	height: 100px;
}

section {
	width: 100vw;
}

div.search {
	display: block;
	min-width: 400px;
	width: 30%;
	border: 2px solid orange;
	position: relative;
}
section div {
	margin: 0 auto;

}

div.search input {
	
}

fieldset {
	border: none;
	outline: none;
}

div.search input[type=text] {
	width: auto;
	height: 35px;
	border: none;
	outline: none;
	padding-left: 5px;
	position: relative;
}

div.search button {
	width: 40px;
	height: 35px;
	position: absolute;
	right: 0;
	border: none;
	outline: none;
	background-color: orange;
}

aside {
border: 1px solid black;
float:left;
height: 900px;
width:250px;}
</style>
</head>
<body>
	<nav>로그인 관련</nav>
	<section>
		<div>
		<aside>왼쪽 사이드 바</aside>
		<div class="search">
			<form>
				<fieldset>
					<input type="text" placeholder="레시피 검색!">
					<button type="submit"> 
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
				</fieldset>
			</form>
		</div>
		
		</div>
	</section>
</body>
</html>