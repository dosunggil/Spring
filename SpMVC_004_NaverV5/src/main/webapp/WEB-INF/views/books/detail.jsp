<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<style>
section.w3-container {
	display: flex;
	flex-direction: column;
	width: 80%;
	margin: 10px auto;
}

div.detail-flex {
	display: flex;
	justify-content: space-around;
}
</style>
<%-- <%@ include file="/WEB-INF/views/books/head.jsp" %> --%>
<body>
	<%-- 	<%@ include file="/WEB-INF/views/books/header.jsp"%> --%>
	<section class="w3-container">
		<div class="w3-container detail-flex">
			<div>
				<img src="${BOOK.image}">
			</div>
			<div class="detail">
				<h2>
					도서명: <a href="${BOOK.link}" target=new>"${BOOK.title}</a>
				</h2>
				<p>ISBN : ${BOOK.isbn}
				<p>저자: ${BOOK.author}
				<p>출판사: ${BOOK.publisher}
				<p>가격: ${BOOK.price}
				<p>출판일자: ${BOOK.pubdate}
			</div>
		</div>

		<div class="btn-box">
			<a href="${rootPath}/books/list" class="list">리스트</a> <a
				href="${rootPath}/books/${BOOK.isbn}/update" class="update">수정</a> <a
				href="javascript:void(0)" class="delete">삭제</a>

		</div>

	</section>
</body>
<script>
	document.querySelector("a.delete").addEventListener("click",()=> {
		if(confirm("정말 삭제할까요?")) {
			document.location.replace("${rootPath}/books/${BOOK.isbn}/delete")
		}
	})
	/*
		location.href = URL 과 location.replace(URL) 의 차이점
		.href 는 브라우저 화면이 전환될 때 history 를 계속 간직하고 있다.
		어떤 page 에서 계속 뒤로가기를 클릭하면 연속으로 뒤로 복귀가 된다.
		
		.replace() 는 현재화면의 history 를 제거해버리고 
		새로운 page로 덮어쓰기가 된다.
		뒤로가기를 눌렀을 때 현재 보고잇는 페이지를 열 수 없다는 것이다.
		
		보통 Detail 에서 삭제를 선택했을 때
		삭제하고 난 후 뒤로가기를 눌러 이미 삭제된 데이터를 보는것을
		방지하기 위함이다.
	
	
	*/
</script>
</html>