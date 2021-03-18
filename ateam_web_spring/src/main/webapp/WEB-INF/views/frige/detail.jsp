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
	<div id="content_image">
		<c:if test="${!empty detail.image_path }">
			<img src="http://112.164.58.217:8999/ateamiot/resources/<c:out value='${detail.image_path}' default='#'/>"/>		
		</c:if>
		<c:if test="${empty detail }">
			<img src="resources/images/frige_default.png"/>		
		</c:if>
	</div>

	<c:if test="${!empty detail }">
		<div id="content_detail">
			<form method="post" action="modify.fc" id="formM">
				<input type="hidden" name="content_list_id" value="${detail.content_list_id }" />
				<div style="overflow: hidden;">
					<div style="width:46%; display:inline-block; float: left;">
						<p style="font-size: 1.2rem;">재료명</p>
						<p><input type="text" class="detail_input" name="content_nm" value="${detail.content_nm }" /></p>
					</div>
					
					<div style="width:46%; display:inline-block; float: right;">
						<p style="font-size: 1.2rem;">재료종류</p>
						<select id="filter_type" onchange="filterType()">
							<option selected="selected">미분류</option>
							<option value="고기">고기</option>
							<option value="수산물">수산물</option>
							<option value="채소">채소</option>
							<option value="과일">과일</option>
							<option value="유제품">유제품</option>
							<option value="곡류">곡류</option>
							<option value="조미료/주류">조미료/주류</option>
							<option value="음료/기타">음료/기타</option>
						</select>
						<input type="hidden" name="content_ty" value="${detail.content_ty }" readonly />
					</div>
				</div>
				
				<div style="overflow: hidden;">
					<div style="width:46%; display:inline-block; float: left;">
						<p style="margin-top: 20px; font-size: 1.2rem;">재료 저장일</p>
						<p><input type="text" class="detail_input" name="shelf_life_start" value="<fmt:formatDate value="${detail.shelf_life_start }" pattern="yyyy-MM-dd" />" readonly /></p>
					</div>
					<div style="width:46%; display:inline-block; float: right;">
						<p style="margin-top: 20px; font-size: 1.2rem;">적정 최대 보관일</p>
						<p><input type="text" class="detail_input" name="shelf_life_end" value="<fmt:formatDate value="${detail.shelf_life_end }" pattern="yyyy-MM-dd" />" readonly /></p>
					</div>
				</div>
			</form>
		</div>
		
		<div class="btnSet">
			<a class="btn-fill" id="btn-irdnt-modify" onclick="do_modify()">수정</a>
			<a class="btn-fill" id="btn-irdnt-delete" onclick="do_delete(${detail.content_list_id})">삭제</a>
			<a class="btn-empty" id="btn-irdnt-cancel" href='<c:url value="/view.fc" />'>취소</a>
		</div>
	</c:if>
</div>

<script src="resources/js/frige_detail.js"></script>