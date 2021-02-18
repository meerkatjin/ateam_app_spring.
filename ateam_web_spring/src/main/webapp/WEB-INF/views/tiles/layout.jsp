<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:choose>
	<c:when test="${category eq 'it'}">
		<c:set var="title" value="소개글 :" />
	</c:when>
	<c:when test="${category eq 'fc'}">
		<c:set var="title" value="My 냉장고 :" />
	</c:when>
	<c:when test="${category eq 'rp' }">
		<c:set var="title" value="레시피 :" />
	</c:when>
	<c:when test="${category eq 'cu' }">
		<c:set var="title" value="커뮤니티 :" />
	</c:when>
	<c:when test="${category eq 'login' }">
		<c:set var="title" value="로그인 :" />
	</c:when>
	<c:when test="${category eq 'join' }">
		<c:set var="title" value="회원가입 :" />
	</c:when>
</c:choose>

<title>${title} 속보이는 냉장고</title>
<link rel="icon" type="image/x-icon" href="imgs/logo.ico">
<link rel='stylesheet' type='text/css' href='css/common.css?v=<%=new java.util.Date().getTime() %>'>
<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/js/all.min.js"></script>
</head>
<body>
<tiles:insertAttribute name="header" />
<div id='content' class="flexSet-wrap">
<tiles:insertAttribute name="content" />
</div>
<tiles:insertAttribute name="footer" />
</body>
</html>