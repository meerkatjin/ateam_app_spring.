<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
/*추천 레시피 아이템 사이즈*/
.recipe-header-items{ max-width: 24.2%; overflow: hidden; cursor: pointer; }
.recipe-header-items:not(:first-child){ margin-left: 10px; }

/*레시피 내용물*/
.recipe-content-container{ 
	display:grid; 
	grid-template-columns: repeat(auto-fill, minmax(19%, auto));
	grid-auto-rows: minmax(10px, auto);
	gap: 20px 10px;
	margin-top: 50px;
}
.recipe-content-items { overflow: hidden; cursor: pointer; }
.recipe-content-items:hover { background-color: #ddd }
.image-content { height: 200px; width: 100%; overflow: hidden; }
.recipe-content-items img { height: 200px; min-width:250px; transition: transform 0.35s;  }
.recipe-content-items img:hover { 
	-webkit-transform: translate(-40px, 0px);
	-ms-transform: translate(-40px, 0px);
	transform: translate(-40px, 0px);
	transition: transform 0.35s;
}
</style>
<div align="left" style="margin: 20px 0px 20px 0px;">
<div id="list-top" style="overflow: hidden;">
<form action="list.rp" method="post">
<div>
	<ul>
		<li><select name='pageList' class='w-px80' 
					onchange="$('[name=curPage]').val(1); $('form').submit()" >
				<option value='10' ${page.pageList eq 10 ? 'selected' : ''}>10개씩</option>
				<option value='20' ${page.pageList eq 20 ? 'selected' : ''}>20개씩</option>
				<option value='30' ${page.pageList eq 30 ? 'selected' : ''}>30개씩</option>
			</select>
		</li>
	</ul>
	<ul>
		<li>
			<select name='search' class='w-px80'>
				<option value="all" ${page.search eq 'all' ? 'selected' : ''}>전체</option>
				<option value="recipe_nm_ko" ${page.search eq 'recipe_nm_ko' ? 'selected' : ''}>이름</option>
				<option value="nation_nm" ${page.search eq 'nation_nm' ? 'selected' : ''}>나라</option>
				<option value="ty_nm" ${page.search eq 'ty_nm' ? 'selected' : ''}>유형</option>
			</select>
		</li>
		<li><input type='text' name='keyword' value='${page.keyword}' class='w-px200'/></li>
		<li><a class='btn-fill' onclick="$('form').submit()">검색</a></li>
	</ul>
</div>
<input type="hidden" name="curPage" value="1">
<input type="hidden" name='recipe_id'/>
<input type="hidden" name="vo">
</form>
</div>
<h3>레시피</h3>
	<div class="top-border-2px">
		<p align="center">오늘의 추천 레시피!</p>
		<div class="flexSet-wrap">
		<c:forEach var="vo" items="${recommend}">
			<div class="recipe-header-items bottom-border-2px" onclick="go_view(${vo.recipe_id})">
				<img src="${vo.img_url}" style="height: 250px; min-width: 250px;">
				<p>${vo.recipe_nm_ko}</p>
				<div style="font-size: 14px; padding: 5px;">${vo.sumry}</div>
			</div>
		</c:forEach>
		</div>
	</div>
	<div class="recipe-content-container top-border-2px">
	<p style="text-align: center; grid-column: 1 / span 5;">레시피 모음</p>
	<c:forEach var="vo" items="${page.list}">
		<div class="bottom-border-2px recipe-content-items" onclick="go_view(${vo.recipe_id})">
			<div class="image-content">
				<img src="${vo.img_url}">
			</div>
			<p>${vo.recipe_nm_ko}</p>
			<div style="font-size: 14px; padding: 5px;">${vo.sumry}</div>
		</div>
	</c:forEach>
	</div>
	<div class='btnSet' align="center">
		<jsp:include page="/WEB-INF/views/include/page.jsp"/>
	</div>
</div>

<script type="text/javascript">
function go_view(id){
	$('[name=recipe_id]').val(id);
	$('form').attr('action', 'view.rp');
	$('form').submit();
}
</script>