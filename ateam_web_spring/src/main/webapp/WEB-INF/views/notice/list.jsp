<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<a href="list.no">공지사항</a>
	<a href="list.qa">자주묻는 질문</a>
	<a href="list.bo">게시판</a>
</div>
<h3>공지사항</h3>
<form action="list.no" method="post">
<table>
<tr>
	<th class="w-px60">번호</th>
	<th>제목</th>
	<th class="w-px120">작성일자</th>
	<th class="w-px120">조회수</th>
</tr>
<tr>
	<td></td>
	<td>${vo.board_title}</td>
	<td></td>
	<td></td>
</tr>
</table>
</form>
</body>
</html>