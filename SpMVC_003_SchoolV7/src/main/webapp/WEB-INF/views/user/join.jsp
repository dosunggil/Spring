<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: content-box;
}

form.join {
	width: 60%;
	margin: 20px auto;
}

form.join fieldset {
	border: 1px solid green;
}

form div {
	display: flex;
	margin: 5px; auto;
}

form input {
	flex: 1;
	padding : 8px;
}
.warn {
	color:red;
	font-weight: 900;
	text-decoration: underline;
}

.ok {
	color:blue;
}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/resources/js/join.js?ver=017"></script>

</head>
<body>
	<form class="join" method="POST">
		<fieldset>
			<legend>회원가입</legend>
			<div>
				<input name="username" placeholder="USER NAME" autocomplete="off">
				<button type="button" class="id-check">중복검사</button>
			</div>
			<div class="username"></div>
			<div>
				<input name="password" type="password" placeholder="PASSWORD"
					autocomplete="off">
			</div>
			<div>
				<input name="re_password" type="password"
					placeholder="PASSWORD CHECK" >
			</div>
			<div>
				<input name="name" placeholder="이름" />
			</div>
			<div>
				<input name="email" placeholder="E-MAIL" />
			</div>
			<div>
				<button type="button" class="join">회원가입</button>
				<button type="reset" class="">초기화</button>
			</div>
		</fieldset>

	</form>

</body>
</html>