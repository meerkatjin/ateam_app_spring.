<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
.board_content {min-height: 300px; padding-left: 10px; padding-right: 10px;}
.big-button {width: 100%; height: 60px; line-height:60px; text-align: center; font-size: 28px; font-weight: bold; margin-top: 20px; background: #000; }
</style>
<div class="flexSet-wrap left webview-menu">
	<div class="menu-font left" style="width: 60%;" onclick="jabascript:history.back();">&lt;
	<c:if test="${page.gp eq 1}">공지사항</c:if>
	<c:if test="${page.gp eq 2}">Q&A</c:if>
	<c:if test="${page.gp eq 3}">게시판</c:if>
	</div>
	<div class="flexSet-wrap" style="width: 40%; justify-content: space-around;">
	<c:if test="${loginInfo.user_id eq vo.user_id}">
		<c:if test="${page.gp eq 1}">
			<div class="webview-button menu-font" onclick="location.href='modify.no?board_no=${vo.board_no}'">수정</div>
			<div class="webview-button menu-font" onclick="if( confirm('정말 삭제하시겠습니까?') ){ location='delete.no?board_no=${vo.board_no}' }">삭제</div>
		</c:if>
		<c:if test="${page.gp eq 2}">
			<div class="webview-button menu-font" onclick="location.href='modify.qa?board_no=${vo.board_no}'">수정</div>
			<div class="webview-button menu-font" onclick="if( confirm('정말 삭제하시겠습니까?') ){ location='delete.qa?board_no=${vo.board_no}' }">삭제</div>
		</c:if>
		<c:if test="${page.gp eq 3}">
			<div class="webview-button menu-font" onclick="location.href='modify.bo?board_no=${vo.board_no}'">수정</div>
			<div class="webview-button menu-font" onclick="if( confirm('정말 삭제하시겠습니까?') ){ location='delete.bo?board_no=${vo.board_no}' }">삭제</div>
		</c:if>
	</c:if>
	</div>
</div>

<div class="left">
	<h3 style="margin-left: 10px;">${vo.board_title}</h3>
	<div class="sub-data">
		작성자 ${vo.name} &nbsp;
		<fmt:formatDate value="${vo.create_dt}" var="create_dt" pattern="yyyy-MM-dd" />
		작성일 ${create_dt} &nbsp;
		조회수 ${vo.board_readcount}
	</div>
	<div class="border-2px-1px board_content">
		${ fn:replace( fn:replace(vo.board_content, crlf, '<br>') , lf, '<br>') }
	</div>
	<c:if test="${ ! empty vo.filename }">
	<div style="border-bottom: 1px solid #999; padding: 10px 0;">
		첨부파일 
		<span id='preview'></span>
		<a href='download.bo?board_no=${vo.board_no}'><i class='fas fa-download'></i></a>
	</div>
	</c:if>
	<div onclick="jabascript:history.back();" class="big-button">
	목록으로
	</div>
</div>

<form method="post" action="list.bo">
<input type='hidden' name='user_id' value='${vo.user_id}'/>
<input type='hidden' name='board_no' value='${vo.board_no}'/>
<input type='hidden' name='curPage' value='${page.curPage}'/>
</form>
<c:if test="${page.gp eq 3 }">
<div style='margin:0 auto; padding-top:20px; width:90%;'>
	<div id='comment_regist'>
		<span class='left'  style="float: left;"><strong>댓글작성</strong></span>
		<span class='right' style="float: right;"><a class='btn-fill-s' onclick='comment_regist()' >댓글등록</a></span>
		<textarea id='comment' style='margin-top:5px; width:100%; height:100px; resize:none'></textarea>
	</div>
	<div id='comment_list' style='text-align:left'>
	</div>
</div>
</c:if>

<script type="text/javascript" src="js/file_check.js"></script>
<script type="text/javascript">
image_size_limit();
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

//웹뷰로 볼때 이미지 사이즈 무조건 고정
function image_size_limit(){
	$(".board_content").children("p").children("img").css("width","300px");
}

</script>