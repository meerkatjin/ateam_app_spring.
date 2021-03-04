<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>게시판 글상세보기</h3>

<table>
<tr><th class='w-px160'>제목</th>
	<td colspan='5' class='left'>${vo.board_title}</td>
</tr>
<tr><th>작성자</th>
	<td>${vo.name}</td>
	<th class='w-px120'>작성일자</th>
	<fmt:formatDate value="${vo.create_dt}" var="create_dt" pattern="yyyy-MM-dd" />
	<td class='w-px120'>${create_dt }</td>
	<th class='w-px80'>조회수</th>
	<td class='w-px80'>${vo.board_readcount}</td>
</tr>
<tr><th>내용</th>
	<td colspan='5' class='left'>${vo.board_content}</td>
</tr>
<tr><th>첨부파일</th>
	<td colspan='5' class='left'>${vo.filename}
		<c:if test="${ ! empty vo.filename }">
			<span id='preview'></span>
			<a href='download.bo?board_no=${vo.board_no}'><i class='fas fa-download'></i></a>
		</c:if>
	</td>
</tr>
</table>



<div class="btnSet">
	<a class="btn-fill" href='javascript:$("form").submit()'>목록으로</a>
	<c:if test="${loginInfo.user_id eq vo.user_id}">
	<a class="btn-fill" href='modify.bo?board_no=${vo.board_no}'>수정</a>
	<a class="btn-fill" onclick="if( confirm('정말 삭제하시겠습니까?') ){ location='delete.bo?board_no=${vo.board_no}' }">삭제</a>
	</c:if>
</div>

<form method="post" action="list.bo">
<input type='hidden' name='user_id' value='${vo.user_id}'/>
<input type='hidden' name='board_no' value='${vo.board_no}'/>
<input type='hidden' name='curPage' value='${page.curPage}'/>
</form>

<div style='margin:0 auto; padding-top:20px; width:500px'>
	<div id='comment_regist'>
		<span class='left'><strong>댓글작성</strong></span>
		<span class='right' style="float: right;"><a class='btn-fill-s' onclick='comment_regist()' >댓글등록</a></span>
		<textarea id='comment' style='margin-top:5px; width:100%; height:60px; resize:none'></textarea>
	</div>
	<div id='comment_list' style='text-align:left'>
	</div>
</div>

<script type="text/javascript" src="js/file_check.js"></script>
<script type="text/javascript">
comment_list();
function comment_regist(){
	if( ${empty loginInfo} ){
		alert('댓글을 등록하려면 로그인하세요!');
		return;
	}else if( $.trim($('#comment').val())=='' ){
		alert('댓글을 입력하세요!');
		$('#comment').val('');
		$('#comment').focus();
		return;
	}
	
	$.ajax({
		url: 'board/comment/insert',
		data: { sub_parent_no:${vo.board_no}, sub_content:$('#comment').val(), user_id:${vo.user_id} },
		success: function( response ){
			if( response ){
				alert('댓글이 등록되었습니다!');
				$('#comment').val('');
				comment_list();
			}else{
				alert('댓글 등록 실패ㅠㅠ');
			}
		},error: function(req, text){
			alert(text+ ':'+ req.status);
		}
	
	});
	
}

function comment_list(){
	$.ajax({
		url: 'board/comment/${vo.board_no}',
		success: function( response ){
			$('#comment_list').html(response);
		
		},error: function(req, text){
			alert(text+ ':'+ req.status);
		}
	});
}

</script>