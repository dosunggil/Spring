<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<div class="student detail-body">
	<div>학번 :</div>
	<div class="student detail">${ST.st_num}</div>
</div>
<div class="student detail-body">
	<div>이름 :</div>
	<div class="student detail">${ST.st_name}</div>
</div>
<div class="student detail-body">
	<div>학과 :</div>
	<div class="student detail">${ST.st_dept}</div>
</div>
<div class="student detail-body">
	<div>전화번호 :</div>
	<div class="student detail">${ST.st_tel}</div>
</div>
<div class="student detail-body">
	<div>주소 :</div>
	<div class="student detail">${ST.st_addr}</div>
</div>

<div>
	<c:forEach items="${ST.scoreList}" var="SST">
		<div>${SST.sb_name}(${SST.sb_code}) : ${SST.sc_score}</div>
	</c:forEach>
</div>

<div class="btn-box">
	<div><a href="${rootPath}/student/update/${ST.st_num}">수정</a></div>
	<div><a href="${rootPath}/student">리스트</a></div>
</div>

