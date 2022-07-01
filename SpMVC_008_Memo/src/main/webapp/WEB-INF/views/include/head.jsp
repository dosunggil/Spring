<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<head>
<meta charset="UTF-8">
<title>메모장</title>
<script>const rootPath = "${rootPath}"</script>
<script src="${rootPath}/resources/js/addMemo.js?ver=012" /></script>
<script src="${rootPath}/resources/js/ajax.js?ver=003" /></script>

<link rel="stylesheet" href="${rootPath}/resources/css/reset.css" />
<link rel="stylesheet" href="${rootPath}/resources/css/main.css" />
<link rel="stylesheet" href="${rootPath}/resources/css/header.css" />
<link rel="stylesheet" href="${rootPath}/resources/css/addMemo.css" />
<%-- <link rel="stylesheet" href="${rootPath}/resources/css/detail.css" /> --%>


</head>