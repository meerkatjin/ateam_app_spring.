<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
.container {
	width: 100%;
}
.view {
	width: 49%;
	margin-bottom: 30px;
	float: left;
}
#camera {
	padding-bottom: 49%;
	background-color: #ccc;
}
input[type="radio"]{
	display: none;
}
.irdnt_filter {
	margin: 0px;
	display: inline-block;
	float: left;
	width: calc(100% / 3);
	height: 30px;
	line-height: 27px;
	border: 1px solid #000000;
	transition: 0.25s;
	cursor: pointer;
}
label:hover {
	background-color: #ccc;
}
input[type="radio"]:checked ~ label {
	background-color: #000000;
	color: #FFFFFF;
	font-weight: bold;
}
.type_filter {
	margin: 0px;
	display: inline-block;
	float: left;
	width: 12.5%;
	height: 30px;
	line-height: 27px;
	border: 1px solid #000000;
	transition: 0.25s;
	font-size: 0.7rem;
	cursor: pointer;
}
#irdnt_items {
	margin-top: 10px;
	border: 1px solid #000000;
}
#irdnt_search {
	width: 80%;
	float: left;
}
#btn_irdnt_search {
	width: 18%;
	float: right;
	box-shadow: 0 0 0;
}
</style>

<div class="container">
	<h3 align="left">My 냉장고</h3>
	<div class="view" id="camera"></div>
	<div class="view" id="irdnt_list" style="float: right;">
		<div style="overflow: hidden;">
			<input type="radio" name="irdnt_filter" id="filter_date" value="date" checked="checked" />
			<label for="filter_date" class="irdnt_filter">유통기한</label>
			<input type="radio" name="irdnt_filter" id="filter_type" value="type" />
			<label for="filter_type" class="irdnt_filter">종류</label>
			<input type="radio" name="irdnt_filter" id="filter_name" value="name" />
			<label for="filter_name" class="irdnt_filter">이름</label>
		</div>
		
		<div style="overflow: hidden; margin-top: 10px; display: none;">
			<input type="radio" name="type_filter" id="filter_meat" value="meat" checked="checked" />
			<label for="filter_meat" class="type_filter">고기</label>
			<input type="radio" name="type_filter" id="filter_fish" value="fish" />
			<label for="filter_fish" class="type_filter">수산물</label>
			<input type="radio" name="type_filter" id="filter_vegetable" value="vegetable" />
			<label for="filter_vegetable" class="type_filter">채소</label>
			<input type="radio" name="type_filter" id="filter_fruit" value="fruit" />
			<label for="filter_fruit" class="type_filter">과일</label>
			<input type="radio" name="type_filter" id="filter_dairy" value="dairy" />
			<label for="filter_dairy" class="type_filter">유제품</label>
			<input type="radio" name="type_filter" id="filter_grain" value="grain" />
			<label for="filter_grain" class="type_filter">곡류</label>
			<input type="radio" name="type_filter" id="filter_seasoning" value="seasoning" />
			<label for="filter_seasoning" class="type_filter">조미료/주류</label>
			<input type="radio" name="type_filter" id="filter_etc" value="etc" />
			<label for="filter_etc" class="type_filter">음료/기타</label>
		</div>
		
		<div style="overflow: hidden; margin-top: 10px;">
			<input type="text" id="irdnt_search" placeholder="검색하실 재료명을 입력해주세요" />
			<a class="btn-fill" id="btn_irdnt_search">검색</a>
		</div>
		
		<div id="irdnt_items">
			<p>내 냉장고 재료</p>
			<c:forEach var="vo" items="${page.list }">
				<div class="irdnt_list" onclick="#">
					<p>${vo.irdnt_nm }</p>
					<p>${vo.shelf_life_end }</p>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<script>
	
</script>
