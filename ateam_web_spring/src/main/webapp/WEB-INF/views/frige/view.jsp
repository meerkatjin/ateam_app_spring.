<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style type="text/css">
.container {width: 100%; overflow: hidden;}
.view {width: 49.5%; }

#content_items {margin-top: 10px; overflow-y: scroll; height: 828px;}
#content_search {width: 80%; float: left;}
#btn_content_search {width: 18%; float: right; box-shadow: 0 0 0;}
.content_list {
	overflow: hidden;
	width: 100%;
	margin-bottom: 5px;
	background-color: #ccc;
	cursor: pointer;
}
.content_list:last-child {margin-bottom: 0px;}
.content_list p {display: inline-block;}
.content_list p:first-child {width: 40%; font-size: 1.3rem;}
.content_list p:last-child {width: 58%;}
</style>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<h3 align="left">내 냉장고</h3>
<div class="container">
	<jsp:include page="detail.jsp" flush="false" />
	
	<form method="post" action="view.fc">
	<div class="view" id="irdnt_list" style="float: right;">
			<div style="overflow: hidden; display: flex;">
				<input style="margin-right: 5px;" type="text" name="keyword" id="content_search" placeholder="조회하실 재료명을 입력해주세요" value="${keyword }" />
				<a class="btn-fill" id="btn_content_search" onclick="$('form').submit()">검색</a>
			</div>
		
		<input type='hidden' name='user_id' value=${loginInfo.user_id } />
		<div id="content_items">
			<p style="display: inline-block; width: 40%;">재료이름</p>
			<p style="display: inline-block; width: 58%;">적정 최대 보관일</p>
			<c:forEach var="vo" items="${list }" varStatus="status">
				<c:choose>
					<c:when test="${vo.case1 eq 1 }">
						<div class="content_list" onclick="detail(${vo.content_list_id})" style="background-color: pink;">
					</c:when>
					<c:when test="${vo.case2 eq 1 }">
						<div class="content_list" onclick="detail(${vo.content_list_id})" style="background-color: yellow;">
					</c:when>
					<c:otherwise>
						<div class="content_list" onclick="detail(${vo.content_list_id})">
					</c:otherwise>
				</c:choose>
					<p>${vo.content_nm }</p>
					<p><fmt:formatDate value="${vo.shelf_life_end }" pattern="yyyy-MM-dd" /></p>
					</div>
					<input type='hidden' name='content_list_id'
						value=${vo.content_list_id } />
			</c:forEach>
		</div>
	</div>
	</form>
</div>

<script>
function detail(id) {
	$('[name=content_list_id').val(id);

	$('form').attr('action', 'detail.fc');
	$('form').submit();
}
</script>