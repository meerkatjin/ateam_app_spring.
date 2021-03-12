<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style type="text/css">
	@import url(resources/css/frige_detail.css);
</style>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<div class="view" id="detail">
	<div style="overflow: hidden;">
		<c:if test="${!empty detail }">
			<img src="http://112.164.58.217:8999/ateamiot/resources/<c:out value='${detail.image_path}'/>"/>		
		</c:if>
		<c:if test="${empty detail }">
			<img src="resources/images/frige_default.png"/>		
		</c:if>
	</div>

	<div id="content_detail">
	<h3>내용 상세 및 수정</h3>
		<form method="post" action="modify.fc">
			<p><input type="hidden" name="content_list_id" value="${detail.content_list_id }" /></p>
			<p style="font-size: 1.2rem;">재료명</p>
			<p><input type="text" class="detail_input" name="content_nm" value="${detail.content_nm }" /></p>
			<p style="margin-top: 70px; font-size: 1.2rem;">재료종류</p>
			<ul id="filter_type">
				<li>고기</li>
				<li>수산물</li>
				<li>채소</li>
				<li>과일</li>
				<li>유제품</li>
				<li>곡류</li>
				<li>조미료/주류</li>
				<li>음료/기타</li>
			</ul>
			<p><input type="hidden" name="content_ty" value="${detail.content_ty }" readonly /></p>
			<p style="margin-top: 70px; font-size: 1.2rem;">적정 최대 보관일</p>
			<p><input type="text" class="detail_input" name="shelf_life_end" value="<fmt:formatDate value="${detail.shelf_life_end }" pattern="yyyy-MM-dd" />" readonly /></p>
		</form>
	</div>
	
	<div class="btnSet">
		<a class="btn-fill" id="btn-irdnt-modify" onclick="do_modify()">수정</a>
		<a class="btn-fill" id="btn-irdnt-delete" onclick="do_delete()">삭제</a>
		<a class="btn-empty" id="btn-irdnt-cancel" href='<c:url value="/view.fc" />'>취소</a>
	</div>
</div>

<script src="resources/js/frige_detail.js"></script>