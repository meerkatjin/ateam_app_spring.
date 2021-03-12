<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style type="text/css">
	@import url(resources/css/frige_view.css);
</style>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<h3 align="left">내 냉장고</h3>
<div class="container">
	<jsp:include page="detail.jsp" flush="false" />
	
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
						<p><fmt:formatDate value="${vo.shelf_life_end }" pattern="yyyy-MM-dd" /></p>
					</div>
					<input type='hidden' name='content_list_id'
						value=${vo.content_list_id } />
				</c:forEach>
			</div>
		</form>
	</div>	
</div>

<script src="resources/js/frige_view.js"></script>