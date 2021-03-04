<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h3>질문글쓰기</h3>

<form action="insert.qa" method="post" enctype="multipart/form-data" >
<table>
<tr>
	<th>제목</th>
	<td><input type="text" name="board_title" title="제목"></td>
</tr>
<tr>
	<th>작성자</th>
	<td>${loginInfo.user_nm}</td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name="board_content" title="내용" ></textarea></td>
</tr>
<tr>
	<th>파일첨부</th>
	<td class='left'>
		<label>
		<input type='file' name='file' id='attach-file' />
		<img src='imgs/select.png' class='file-img' />
		</label>
		<span id='file-name'></span>
		<span id='delete-file'><i class='fas fa-times'></i></span>
	</td>
</tr>
</table>
<input type="hidden" name="board_gp" value="2">
<input type="hidden" name="user_id" value="${loginInfo.user_id}">
<input type="hidden" name="user_type" value="${loginInfo.user_type}">
</form>

<div class="btnSet">
<a class="btn-fill" onclick="if( emptyCheck() ) $('form').submit()">저장</a>
<a class="btn-empty" href="list.qa">취소</a>
</div>

<script type="text/javascript" src="js/file_check.js"></script>