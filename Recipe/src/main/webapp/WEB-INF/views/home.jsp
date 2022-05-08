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
<link rel="stylesheet" href="${rootPath}/resources/css/reset.css" />
<link rel="stylesheet" href="${rootPath}/resources/css/main.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/js/all.min.js"></script>
<style>
</style>
</head>
<body>
	<header>
		<div class="top_nav">
			<div class="logo_box">
				<img class="logo" src="${rootPath}/resources/images/logo.png">
			</div>
			<div>임시</div>
			<div class="search_box">
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
				<i class="ico_cookcook"
					style="background-image: url('${rootPath}/resources/images/logo2.png') "></i>로그인
			</div>
		</div>
	</header>


	<section>
		<div class="middle_nav">
			<div class="container">
				<!-- 	
				<div class="search_box">
					<form>
						<fieldset>
							<input type="text" placeholder="레시피 검색!">
							<button type="submit">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
						</fieldset>
					</form>
				</div> -->
			</div>
		</div>
		<div class="content_top">
			<div> 손쉬운   식재료 보관법
			</div>
		</div>
		<div class="content_main">

			<div class="listname">
				<h3>
					오늘의 <span class="font_highlight">쿡쿡</span>
				</h3>
			</div>
			<div class="list_box">
				<ul>
					<li><a> <img
							src="${rootPath}/resources/images/tokbokk.jpg" />
							<div>진짜 만들기 쉬운 초간단 떡볶이1</div>
					</a></li>
					<li><a> <img src="${rootPath}/resources/images/toast.jpg" />
							<div>역대급 치즈 토스트!2</div>
					</a></li>
					<li><a> <img src="${rootPath}/resources/images/steak.jpg" />
							<div>촉촉한 함박 스테이크 무조건 맛있게3</div>
					</a></li>
					<li><a> <img src="${rootPath}/resources/images/pasta.jpg" />
							<div>토마토 파슷하4</div>
					</a></li>
				</ul>
			</div>
		</div>
	</section>
</body>
</html>