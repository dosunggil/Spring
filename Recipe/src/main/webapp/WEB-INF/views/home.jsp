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

section {
	margin-top: 130px;
	width: 100%;
	height: 100%;
}

fieldset {
	border: none;
	outline: none;
}

div.container {
	position: relative;
	width : 700px;
	height: 55px;
	margin : 0 auto;
}

img.logo {
	cursor: pointer;
	position: absolute;
	width: 200px;
	height: auto;
}

div.search {
	display: block;
	width: 400px;
	border: 2px solid #ff7f00;
	position: absolute;
	left: 210px;
	top: 10px;
}

div.search input[type=text] {
	width: 350px;
	height: 35px;
	border: none;
	outline: none;
	padding-left: 5px;
}

div.search button {
	cursor: pointer; width : 40px;
	height: 35px;
	position: absolute;
	right: 0;
	border: none;
	outline: none;
	background-color: #ff7f00;
	width: 40px;
}

div.profile {
	cursor: pointer;
	position: absolute;
	left: 630px;
	top: 6px;
}

div.content_main {
border : 1px soild black;
width : 
}
</style>
</head>
<body>
	<section>
		<div class="nav">
			<div class="container">
				<img class="logo" src="${rootPath}/resources/images/logo.png">
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
				<div class="profile">
					<i class="fa-regular fa-user fa-2x fa-border"
						style="background-color: #ff7f00; border-radius: 15px;"></i>
				</div>
			</div>
		</div>
		<div class="content_main">
			<div></div>
			<div></div>
			<div></div>
			<div></div>
		
		</div>
	</section>
</body>
</html>