<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h3>공지글 상세보기</h3>

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
	<td colspan='5' class='left'>${ fn:replace( fn:replace(vo.board_content, crlf, '<br>') , lf, '<br>') }</td>
</tr>
<tr><th>첨부파일</th>
	<td colspan='5' class='left'>${vo.filename}
		<c:if test="${ ! empty vo.filename }">
			<span id='preview'></span>
			<a href='download.no?board_no=${vo.board_no}'><i class='fas fa-download'></i></a>
		</c:if>
	</td>
</tr>
</table>

<div class="btnSet">
	<a class="btn-fill" href='list.no?curPage=${page.curPage}'>목록으로</a>
	<!-- 글쓴이 본인만 수정/삭제 가능 -->
	<c:if test="${loginInfo.user_id eq vo.user_id}">
		<a class="btn-fill" href='modify.no?board_no=${vo.board_no}'>수정</a>
		<a class="btn-fill" onclick="if( confirm('정말 삭제하시겠습니까?') ){ location='delete.no?board_no=${vo.board_no}' }">삭제</a>
	</c:if>
</div>