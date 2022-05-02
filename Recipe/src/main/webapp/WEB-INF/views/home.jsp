<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요리교실</title>
<link rel="stylesheet" href="${rootPath}/resources/css/main.css" />
<style>
section {
	width: 100vw
}
div.search {
	width: 90%;
	
}
div.search input {
	
}

div.search input[type=text] {
	width: 50%;
}
div.search input[type=button] {
	width: 50px;
}
</style>
</head>
<body>
	<nav>로그인 관련</nav>
	<section>
		<div class="search">
			<form>
				<input type="text" placeholder="레시피 검색!" >
				<input type="button" value="검색">
			</form>


		</div>
		<div class="add">식재료 추가</div>
		<div class="hate">싫어하는 재료</div>





	</section>
</body>
</html>