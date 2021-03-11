<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>공지글 쓰기</h3>

<form action="insert.no" method="post" enctype="multipart/form-data" >
<table>
<tr>
	<th>제목</th>
	<td><input type="text" name="board_title" title="제목" class="chk"></td>
</tr>
<tr>
	<th>작성자</th>
	<td>${loginInfo.user_nm}</td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea id="popContent" name="board_content" title="내용" cols="108" rows="15"></textarea></td>
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
<a class="btn-fill" onclick="if( emptyCheck() ) fnSubmit();">저장</a>
<a class="btn-empty" href="list.no">취소</a>
</div>

<script type="text/javascript" src="resources/js/smartEditor/js/service/HuskyEZCreator.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/file_check.js"></script>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "popContent",  //textarea ID
    sSkinURI: "resources/js/smartEditor/SmartEditor2Skin.html",  //skin경로
    fCreator: "createSEditor2",
});

function fnSubmit(){

	oEditors.getById['popContent'].exec("board_content", []);
	
	$('form').submit();
}



</script>