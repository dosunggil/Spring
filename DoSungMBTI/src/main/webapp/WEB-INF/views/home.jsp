<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE-edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath}/resources/css/reset.css" />
<link rel="stylesheet" href="${rootPath}/resources/css/main.css" />
</head>
<body>
<header>header </header>
	<main>
		<div class="banner">
			1. 잡담은 싫어하지만 내게 중요한 문제를 깊이 논의하는 것은 좋아한다.
			<form method="post">
				<input id="for1" type="radio" name="Mbti_IE" value="I" hidden="hidden"/> <label for="for1">1. 그렇다.</label>
				<input id="for2" type="radio" name="Mbti_IE" value="E" hidden="hidden"/> <label for="for2">2. 아니다.</label>
			</form>
		</div>
	</main>
<footer>footer </footer>
</body>
</html>