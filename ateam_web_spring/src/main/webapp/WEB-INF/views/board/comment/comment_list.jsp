<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:forEach items="${list}" var="vo" varStatus="status">
${status.index eq 0 ? '<hr>' : ''}
<div data-id='${vo.board_no}' >${vo.name} [ ${vo.create_dt} ]
	<c:if test="${vo.user_id eq loginInfo.user_id}">
	<span style='float:right;'>
		<a class='btn-fill-s btn-modify-save'>수정</a>
		<a class='btn-fill-s btn-delete-cancel'>삭제</a>
	</span>
	</c:if>
	<div class='original'>${fn: replace( fn:replace(vo.content, lf, '<br>'), crlf, '<br>') }</div>       
	<div class='modify' style='display:none; margin-top:6px;'></div>
</div>
<hr>
</c:forEach>

