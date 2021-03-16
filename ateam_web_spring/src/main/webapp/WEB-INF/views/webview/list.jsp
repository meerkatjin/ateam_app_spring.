<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
.menu ul li { float: left; margin-right: 40px; font-size: 18px; font-weight: bold;}
.btn-write ul { margin: 0; }
.btn-write ul li { float: right; margin-bottom: 20px; font-weight: bold;}
.menu { height: 50px; background-color: #000; justify-content: space-around;}
.set-gp {font-size: 18px; color: #fff;  line-height: 50px;}
.btn-write ul { margin: 0; }
.btn-write ul li { float: right; margin-bottom: 20px; font-weight: bold; }
.web-view {border-bottom: 1px solid #999; justify-content: space-between;}
.title {margin: 5px; font-size: 20px;}
.sub-data{color: #999; margin: 5px;}
.left{width: 90%; margin-top: 10px; margin-bottom: 10px;}
.post-button{width:60px; height: 30px; line-height: 30px; border: 2px solid #999;  margin: 10px 0; border-radius: 15px;}
</style>

<form action="list.ap" method="post">
<div class="menu flexSet-wrap">
	<div class="set-gp"><a onclick="select_gp('1')">공지사항</a></div>
	<div class="set-gp"><a onclick="select_gp('2')">Q&amp;A</a></div>
	<div class="set-gp"><a onclick="select_gp('3')">게시판</a></div>
	<c:if test="${loginInfo.user_grade eq '2' and page.gp eq '1'}">
		<div class="set-gp post-button" onclick="location.href='new.no'">글쓰기</div>
	</c:if>
	<c:if test="${!empty loginInfo and page.gp eq '2'}">
		<div class="set-gp post-button" onclick="location.href='new.qa'">글쓰기</div>
	</c:if>
	<c:if test="${!empty loginInfo and page.gp eq '3'}">
		<div class="set-gp post-button" onclick="location.href='new.bo'">글쓰기</div>
	</c:if>
</div>
<input type='hidden' name='curPage' value='1'/>
<input type='hidden' name='gp' value='${page.gp}'/>
</form>

<c:forEach items="${page.list}" var="vo">
<c:forEach var="i" begin="1" end="${vo.indent}">
	${i eq vo.indent ? "<img src='imgs/comment.png' style='width:20px;' />" : "&nbsp;&nbsp;" }
</c:forEach>
<div class="web-view" onclick="location.href='view.no?board_no=${vo.board_no}'">
	<div class="left">
		<div class="title txt_line">
			${vo.board_title}
			${empty vo.filename ? '' : '&nbsp;<i class="fas fa-file-alt"></i>'}
		</div>
		<div class="sub-data">
			작성자 ${vo.name} &nbsp;
			<fmt:formatDate value="${vo.create_dt}" var="create_dt" pattern="yyyy-MM-dd" />
			작성일 ${create_dt} &nbsp;
			조회수 ${vo.board_readcount}
		</div>
	</div>
</div>
</c:forEach>
<div class="btnSet">
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>
<script type="text/javascript">
	function select_gp(gp){
		$('[name=gp]').val( gp );
		$('form').submit();
	}
</script>
