<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
/*추천 레시피 아이템 사이즈*/
.recipe-header-items{ max-width: 24.2%; overflow: hidden; }
.recipe-header-items:not(:first-child){ margin-left: 10px; }

/*레시피 내용물*/
.recipe-content-container{ 
	display:grid; 
	grid-template-columns: repeat(auto-fill, minmax(19%, auto));
	grid-auto-rows: minmax(10px, auto);
	gap: 10px;
	margin-top: 50px;
}
.recipe-content-items { height: 200px; transition: transform 0.35s; }
.recipe-content-items:hover { 
	-webkit-transform: translate(-30px, 0px);
	-ms-transform: translate(-30px, 0px);
	transform: translate(-30px, 0px);
	transition: transform 0.35s;
}
</style>
<div align="left" style="margin-top: 20px;">
<form action="list.rp" method="post">
<input type="hidden" name="curPage" value="1">
	<div align="right">
		<select name='search' class='w-px80'>
			<option value="all" ${page.search eq 'all' ? 'selected' : ''}>전체</option>
			<option value="recipe_nm_ko" ${page.search eq 'recipe_nm_ko' ? 'selected' : ''}>이름</option>
			<option value="nation_nm" ${page.search eq 'nation_nm' ? 'selected' : ''}>나라</option>
			<option value="ty_nm" ${page.search eq 'ty_nm' ? 'selected' : ''}>유형</option>
		</select>
		<input type='text' name='keyword' value='${page.keyword}' class='w-px200'/>
		<a class='btn-fill' onclick="$('form').submit()">검색</a>
	</div>
</form>
<h3>레시피</h3>
	<div class="top-border-2px">
		<p align="center">오늘의 추천 레시피!</p>
		<div class="flexSet-wrap">
			<div class="recipe-header-items bottom-border-2px">
				<img alt="테스트1" src="http://file.okdab.com/UserFiles/searching/recipe/000200.jpg" style="max-height: 250px;">
				<p>대충 여기에 내용 뿌리기</p>
			</div>
			<div class="recipe-header-items bottom-border-2px">
				<img alt="테스트1" src="http://file.okdab.com/UserFiles/searching/recipe/005100.jpg" style="max-height: 250px;">
				<p>대충 여기에 내용 뿌리기</p>
			</div>
			<div class="recipe-header-items bottom-border-2px">
				<img alt="테스트1" src="http://file.okdab.com/UserFiles/searching/recipe/010400.jpg" style="max-height: 250px;">
				<p>대충 여기에 내용 뿌리기</p>
			</div>
			<div class="recipe-header-items bottom-border-2px">
				<img alt="테스트1" src="http://file.okdab.com/UserFiles/searching/recipe/011300.jpg" style="max-height: 250px;">
				<p>대충 여기에 내용 뿌리기</p>
			</div>
		</div>
	</div>
	<div class="recipe-content-container top-border-2px">
	<p style="text-align: center; grid-column: 1 / span 5;">레시피 모음</p>
	<c:forEach var="vo" items="${page.list}">
		<div class="bottom-border-2px" style="overflow: hidden;">
			<img src="${vo.img_url}" class="recipe-content-items">
			<p>${vo.recipe_nm_ko}</p>
			<div style="font-size: 14px; padding: 5px;">${vo.sumry}</div>
		</div>
	</c:forEach>
	</div>
	<div class='btnSet' align="center">
		<jsp:include page="/WEB-INF/views/include/page.jsp"/>
	</div>
</div>