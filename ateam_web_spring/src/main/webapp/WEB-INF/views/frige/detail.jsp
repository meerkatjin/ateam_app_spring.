<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재료 상세 및 수정페이지</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style type="text/css">
.container {
	width: 60%; 
	margin: 50px auto;
}
#content_detail { width:100%; border:1px solid #ccc; padding:30px 0; }
#filter_type {
	overflow:hidden; width: 100%;
	margin:0; padding:0;
}
#filter_type li {
	margin: 0px;
	display: inline-block;
	float: left;
	width: calc(100% / 8);
	height: 30px;
	line-height: 27px;
	border: 1px solid #000000;
	transition: 0.25s;
	font-size: 0.7rem;
	cursor: pointer;
}
#filter_type li.active {
	background-color: #000000;
	color: #ffffff;
	font-weight: bold;
}
.btnSet a {
	padding-left: 90px;
	padding-right: 90px;
}
</style>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<h3>상세페이지</h3>
<div class="container">
	<div id="content_detail">
		<form method="post" action="modify.fc">
			<p><input type="hidden" name="content_list_id" value="${detail.content_list_id }" /></p>
			<p>재료명</p>
			<p><input type="text" name="content_nm" value="${detail.content_nm }" /></p>
			<p>재료종류</p>
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
			<p><input type="text" name="content_ty" value="${detail.content_ty }" readonly /></p>
			<p>적정 최대 보관일</p>
			<p><input type="text" name="shelf_life_end" value="${detail.shelf_life_end }" readonly /></p>
		</form>
	</div>
	
	<div class="btnSet">
		<a class="btn-fill" id="btn-irdnt-modify" onclick="do_modify()">수정</a>
		<a class="btn-empty" id="btn-irdnt-cancel" href='<c:url value="/view.fc" />'>취소</a>
	</div>
</div>

<script type="text/javascript">

$(function(){
	$('#filter_type li').removeClass();
	if ($('[name=content_ty]').val() == '고기'){
		$('#filter_type li:eq(0)').addClass('active');
	} else if ($('[name=content_ty]').val() == '수산물'){
		$('#filter_type li:eq(1)').addClass('active');
	} else if ($('[name=content_ty]').val() == '채소'){
		$('#filter_type li:eq(2)').addClass('active');
	} else if ($('[name=content_ty]').val() == '과일'){
		$('#filter_type li:eq(3)').addClass('active');
	} else if ($('[name=content_ty]').val() == '유제품'){
		$('#filter_type li:eq(4)').addClass('active');
	} else if ($('[name=content_ty]').val() == '곡류'){
		$('#filter_type li:eq(5)').addClass('active');
	} else if ($('[name=content_ty]').val() == '조미료/주류'){
		$('#filter_type li:eq(6)').addClass('active');
	} else if ($('[name=content_ty]').val() == '음료/기타'){
		$('#filter_type li:eq(7)').addClass('active');
	}
	
	$('[name=shelf_life_end]').datepicker({
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
		, dateFormat : 'yy-mm-dd'
		, changeYear : true
		, changeMonth : true
		, showMonthAfterYear: true
		, monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월'
							, '7월', '8월', '9월', '10월', '11월', '12월']
		//, beforeShowDay: after
	});
});

$(document).on('click', '#filter_type li', function(){
	$('#filter_type li').removeClass();
	$(this).addClass('active');

	var idx = $('#filter_type li.active').index();
	if (idx == 0) {	//고기
		$('[name=content_ty]').val('고기');
	} else if (idx == 1) {	//수산물
		$('[name=content_ty]').val('수산물');
	} else if (idx == 2) {	//채소
		$('[name=content_ty]').val('채소');
	} else if (idx == 3) {	//과일
		$('[name=content_ty]').val('과일');
	} else if (idx == 4) {	//유제품
		$('[name=content_ty]').val('유제품');
	} else if (idx == 5) {	//곡류
		$('[name=content_ty]').val('곡류');
	} else if (idx == 6) {	//조미료/주류
		$('[name=content_ty]').val('조미료/주류');
	} else if (idx == 7) {	//음료/기타
		$('[name=content_ty]').val('음료/기타');
	}
});

function do_modify() {
	var content_list_id = $('[name=content_list_id]').val();
	$('form').submit();
}
</script>
</body>
</html>