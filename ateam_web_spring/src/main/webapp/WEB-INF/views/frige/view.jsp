<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style type="text/css">
	@import url(resources/css/frige_view.css);
</style>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<div class="container">
	<h3 align="left">내 냉장고</h3>
	<div class="view" id="camera">
		<img src="http://112.164.58.217:8999/ateamiot/resources/2021/03/03/8ddf5229-d7a3-4182-a92f-132ddefc847e.jpg" />
	</div>
	
	<div class="view" id="irdnt_list" style="float: right;">
		<div style="overflow: hidden;">
			<input type="text" id="content_search" placeholder="조회하실 재료명을 입력해주세요" value="${keyword }" />
			<a class="btn-fill" id="btn_content_search" onclick="$('form').submit()">검색</a>
		</div>

		<form action="view.fc" method="post">
			<input type='hidden' name='user_id' value=${loginInfo.user_id } />
			<div id="content_items">
				<p style="display: inline-block; width: 40%;">재료이름</p>
				<p style="display: inline-block; width: 58%;">적정 최대 보관일</p>
				<c:forEach var="vo" items="${list }">
					<div class="content_list" onclick="detail(${vo.content_list_id})">
						<p>${vo.content_nm }</p>
						<p><fmt:formatDate value="${vo.shelf_life_end }" pattern="yyyy년 MM월 dd일" /></p>
					</div>
					<input type='hidden' name='content_list_id'
						value=${vo.content_list_id } />
				</c:forEach>
			</div>
		</form>
	</div>
	
	<div class="view" id="irdnt_detail" style="display: none; float: right;">
		<h3>재료 정보 및 수정</h3>
		<div>
			<p><input type="hidden" name="content_list_id_detail" value="${detail.content_list_id }" /></p>
			<p style="font-size: 1.2rem;">재료명</p>
			<p><input type="text" class="detail_input" name="content_nm_detail" value="${detail.content_nm }" /></p>
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
			<p><input type="hidden" name="content_ty_detail" value="${detail.content_ty }" readonly /></p>
			<p style="margin-top: 70px; font-size: 1.2rem;">적정 최대 보관일</p>
			<p><input type="text" class="detail_input" name="shelf_life_end_detail" value="<fmt:formatDate value="${detail.shelf_life_end }" pattern="yyyy년 MM월 dd일" />" readonly /></p>
		</div>
		
		<div class="btnSet">
			<a class="btn-fill" id="btn-irdnt-modify" onclick="do_modify()">수정</a>
			<a class="btn-fill" id="btn-irdnt-delete" onclick="do_delete()">삭제</a>
			<a class="btn-empty" id="btn-irdnt-cancel" href='<c:url value="/view.fc" />'>목록</a>
		</div>
		<p></p>
	</div>
</div>

<script src="resources/js/frige_view.js"></script>
