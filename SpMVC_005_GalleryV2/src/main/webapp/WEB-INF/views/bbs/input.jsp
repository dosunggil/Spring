<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	#bbsVO3 {
		width : 60%;
		margin : 10px auto; 
			
	}
	#bbsVO3 input, #bbsVO3 textarea {
	width: 90%;
	margin : 5px auto;
	padding: 8px;
	
	}

</style>
</head>
<body>

<%/*
	controller 에서 model 에 Attribute 로 보낸 bbsVO 객체 데이터를 사용하여
	form 과 input 코드 자동화 하기
	
	Spring form taglibs 로 구현한다.
*/%>
	<form:form modelAttribute="bbsVO3" enctype="multipart/form-data">
		<form:input type="hidden" path="b_date"/>
		<form:input type="hidden" path="b_time"/>
		<form:input type="hidden" path="b_writer"/>
		<form:input path="b_subject"/>
		<form:textarea path="b_content"/>
		<input name="up_file" type="file"/>
		<button>작성완료</button>
	
	</form:form>
</body>
</html>