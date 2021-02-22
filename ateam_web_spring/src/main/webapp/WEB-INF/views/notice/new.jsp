<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>공지글 쓰기</h3>

<form action="insert.no" method="post">
<table>
<tr>
	<th>제목</th>
	<td><input type="text" name="board_title" title="제목"></td>
</tr>
<tr>
	<th>작성자</th>
	<td></td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name="board_content" title="내용" ></textarea></td>
</tr>
<tr>
	<th>파일첨부</th>
	<td></td>
</tr>
</table>
<input type="hidden" name="board_gp" value="1">
</form>
<div class="btnSet">
<a class="btn-fill" onclick="if( emptyCheck() ) $('form').submit()">저장</a>
<a class="btn-empty">취소</a>
</div>

<script type="text/javascript" src="js/file_check.js"></script>
</body>
</html>