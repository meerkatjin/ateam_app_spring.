<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Community Board</title>
<style type="text/css">
.menu ul li { float: left; margin-right: 40px; font-size: 18px; font-weight: bold;}
.menu { margin-bottom: 60px; }
table { width: 1024px; }

</style>
</head>
<body>
<div class="boardLayout">
<div class="menu">
<ul>
	<li><a href="list.no">공지사항</a></li>
	<li><a href="list.qa">자주묻는 질문</a></li>
	<li><a href="list.bo">게시판</a></li>
</ul>
<ul>
	<li><a class="btn-fill">글쓰기</a></li>
</ul>
</div>

<form action="list.no" method="post">
<input type='hidden' name='curPage' value='1'/>
<table>
<tr>
	<th class="w-px80">번호</th>
	<th>제목</th>
	<th class="w-px120">작성자</th>
	<th class="w-px120">작성일</th>
	<th class="w-px120">첨부파일</th>
	<th class="w-px120">조회수</th>
</tr>
<c:forEach items="${page.list}" var="vo">
<tr>
	<td>${vo.no}</td>
	<td class="left">${vo.board_title}</td>
	<td></td>
	<td>${vo.create_dt}</td>
	<td></td>
	<td>${vo.board_readcount}</td>
</tr>
</c:forEach>
</table>
<div class="btnSet">
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>
</form>
</div>
</body>
</html>