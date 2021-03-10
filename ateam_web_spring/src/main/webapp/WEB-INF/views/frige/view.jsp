<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style type="text/css">
.container {
	width: 100%;
}

.view {
	width: 49.5%;
	margin-bottom: 30px;
	float: left;
}

#camera {
	padding-bottom: 49%;
	background-color: #ccc;
}

input[type="checkbox"], input[type="radio"] {
	display: none;
}

#filter_tabs, #filter_type {
	overflow: hidden;
	width: 100%;
	margin: 0;
	padding: 0;
}

#filter_tabs li {
	margin: 0px;
	display: inline-block;
	float: left;
	width: calc(100%/ 3);
	height: 30px;
	line-height: 27px;
	border: 1px solid #000000;
	transition: 0.25s;
	cursor: pointer;
}

#filter_tabs li:hover, #filter_type li:hover {
	background-color: #ccc;
}

#filter_tabs li.active, #filter_type li.active {
	background-color: #000000;
	color: #ffffff;
	font-weight: bold;
}

#filter_type li {
	margin: 0px;
	display: inline-block;
	float: left;
	width: calc(100%/ 8);
	height: 30px;
	line-height: 27px;
	border: 1px solid #000000;
	transition: 0.25s;
	font-size: 0.8rem;
	cursor: pointer;
}

#content_items {
	margin-top: 10px;
	overflow-y: scroll;
	height: 600px;
}

#content_search {
	width: 80%;
	float: left;
}

#btn_content_search {
	width: 18%;
	float: right;
	box-shadow: 0 0 0;
}

.content_list {
	overflow: hidden;
	width: 100%;
	margin-bottom: 5px;
	background-color: #ccc;
	cursor: pointer;
}

.content_list:last-child {
	margin-bottom: 0px;
}

.content_list p {
	display: inline-block;
}

.content_list p:first-child {
	width: 40%;
	font-size: 1.3rem;
}

.content_list p:last-child {
	width: 58%;
}
</style>

<div class="container">
	<h3 align="left">내 냉장고</h3>
	<div class="view" id="camera"></div>
	<div class="view" id="irdnt_list" style="float: right;">
		<ul id="filter_tabs">
			<li class="active" onclick="#">유통기한</li>
			<li onclick="#">종류</li>
			<li onclick="#">이름</li>
		</ul>

		<ul id="filter_type" style="display: none;">
			<li class="active">고기</li>
			<li>수산물</li>
			<li>채소</li>
			<li>과일</li>
			<li>유제품</li>
			<li>곡류</li>
			<li>조미료/주류</li>
			<li>음료/기타</li>
		</ul>

		<div style="overflow: hidden; margin-top: 10px;">
			<input type="text" id="content_search" placeholder="검색하실 재료명을 입력해주세요" />
			<a class="btn-fill" id="btn_content_search">검색</a>
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
</div>

<script>
$(function() {
	$('#filter_tabs li:eq(0)').trigger('click');
	$('#filter_type li:eq(0)').trigger('click');
});

$(document).on('click', '#filter_tabs li', function(){
	$('#filter_tabs li').removeClass();
	$(this).addClass('active');

	var idx = $('#filter_tabs li.active').index();
	if (idx == 0) {	//유통기한
		$('#filter_type').css('display', 'none');
// 		$.ajax({
// 			url: 'frige/date',
// 			data: {user_id: $('#user_id').val()},
// 			success: function(response) {
// 				if (response.item.length > 0) {
// 					frige_date($(response.item), true);
// 				}
// 			}, error: function(req, text) {
// 				alert(text + " : " + req.status);
// 			}
// 		});
	} else if (idx == 1) {	//종류
		$('#filter_type').css('display', 'block');
		$('#filter_type li').removeClass();
		$('#filter_type li:eq(0)').addClass('active');
	} else if (idx == 2) {	//이름
		$('#filter_type').css('display', 'none');
	}
});

$(document).on('click', '#filter_type li', function(){
	$('#filter_type li').removeClass();
	$(this).addClass('active');

	var idx = $('#filter_type li.active').index();
	if (idx == 0) {	//고기

	} else if (idx == 1) {	//수산물

	} else if (idx == 2) {	//채소
		
	} else if (idx == 3) {	//과일
		
	} else if (idx == 4) {	//유제품
		
	} else if (idx == 5) {	//곡류
		
	} else if (idx == 6) {	//조미료/주류
		
	} else if (idx == 7) {	//음료/일반
		
	}
});

function detail(id) {
	$('[name=content_list_id]').val(id);
	$('form').attr('action', 'detail.fc');
	$('form').submit();
}

</script>
