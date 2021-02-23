<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>공지글쓰기</h3>
<form action="insert.no" method="post">
<table>
	<tr>
		<th>제목</th>
		<td><input type="text" name="board_title"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${loginInfo.name}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="board_content"></textarea></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td></td>
	</tr>
</table>
</form>

<div class="btnSet">
	<a class="btn-fill" onclick="if( emptyCheck() ) $('form').submit()">저장</a>
	<a class="btn-empty">취소</a>
</div>

<script type="text/javascript" src="js/file_check.js"></script>
</body>
</html>