<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
		<h1> MY API</h1> 
		<p>Naver API 를 활용한 정보 서비스</p>
	</header>

	<nav>
		<ul>
			<li><a href="${rootPath}/">HOME</a></li>
			<li><a href="${rootPath}/books/list">도서정보</a></li>
			<li><a href="${rootPath}/news/list">오늘의 뉴스</a></li>
			<li><a href="${rootPath}/movies">영화정보</a></li>
			<li><a href="${rootPath}/naver">네이버 체험</a></li>

			<%
			// 로그인 하지 않았을 때
			%>
			<c:if test="${empty MEMBER}">
				<li><a href="${rootPath}/member/login">로그인</a></li>
				<li><a href="${rootPath}/member/join">회원가입</a></li>
			</c:if>

			<%
			// 로그인을 했을 때는 MEMBER 객체에 사용자 정보가 담겨있다.
			%>
			<c:if test="${not empty MEMBER}">
				<li><a href="${rootPath}/member/mypage">MY PAGE</a></li>
				<li><a href="${rootPath}/member/logout">로그아웃</a></li>
			</c:if>
		</ul>
	</nav>