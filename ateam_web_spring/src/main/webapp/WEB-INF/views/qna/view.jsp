<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>질문글 상세보기</h3>

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
</table>

<div class="btnSet">
	<a class="btn-fill" href='list.qa?curPage=${page.curPage}'>목록으로</a>
	<c:if test="${loginInfo.user_id eq vo.user_id}">
	<a class="btn-fill" href='modify.qa?board_no=${vo.board_no}'>수정</a>
	<a class="btn-fill" onclick="if( confirm('정말 삭제하시겠습니까?') ){ location='delete.qa?board_no=${vo.board_no}' }">삭제</a>
	</c:if>
	<!-- 관리자만 답글 쓰기 가능 -->
	<c:if test="${loginInfo.user_grade eq '2'}">
		<a class="btn-fill" href="reply.qa?board_no=${vo.board_no}">답글쓰기</a>
	</c:if>
</div>
</body>
</html>