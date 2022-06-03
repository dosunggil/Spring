<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE-edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>나의 API APP</title>
<link rel="stylesheet" href="${rootPath}/resources/css/home.css">
<link rel="stylesheet" href="${rootPath}/resources/css/main.css">
<link rel="stylesheet" href="${rootPath}/resources/css/table.css">
<link rel="stylesheet" href="${rootPath}/resources/css/modal.css">
<link rel="stylesheet" href="${rootPath}/resources/css/input.css">
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/resources/js/input.js?ver=114"></script>
</head>