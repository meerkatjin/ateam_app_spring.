<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style type="text/css">
	@import url(resources/css/frige_view.css);
</style>

<div class="container">
	<h3 align="left">내 냉장고</h3>
	<div class="view" id="camera">
		<img src="http://112.164.58.217:8999/ateamiot/resources/2021/03/03/8ddf5229-d7a3-4182-a92f-132ddefc847e.jpg" />
	</div>
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

	var sdate = new Date();
	sdate.setDate(sdate.getDate() - 3);
	$('.content_list').each(function() {
		$('.content_list').css('background-color', 'pink');
	});
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
