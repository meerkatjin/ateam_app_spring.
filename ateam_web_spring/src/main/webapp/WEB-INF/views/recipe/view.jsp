<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
/*레시피 상세 내용*/
#image {
	position:fixed;
	left:50%; top:50%; transform:translate(-50%, -50%) ;
	border:2px solid #666; display:none;
}
.reciping-content-items{ margin: 10px 0; width: 100%; min-height: 50px; padding-bottom: 10px}
.reciping-content-imgbox{ width: 20%; max-height: 150px; overflow: hidden; padding: 5px;
border: 1px solid; border-radius: 10px;}
.reciping-title-imgbox{ width:100%; max-height:500px; padding: 10px; 
	-webkit-transform: translate(0px, 0px, -10px);
	-ms-transform: translate(0px, 0px, -10px);
	transform: translate(0px, 0px, -10px);
	text-align: center; }
.reciping-irdnt-box{ width: 29%; padding: 0px 20px; }
.reciping-irdnt-box ul li:first-child{ font-size: 18px; font-weight: bold; }
hr { margin: 5px 0px; }
ul { margin: 5px 0px; }
.show{ cursor: pointer; }
</style>
<div align="left" style="margin: 20px 0px 20px 0px;">
<h3>레시피 상세</h3>
<div class="flexSet-wrap bottom-border-2px" style="align-items: flex-start; padding-bottom: 20px;">
	<!-- 타이틀 이미지 -->
	<div class="reciping-title-imgbox">
		<div style="width:60%; margin:0px auto; overflow: hidden; border: 1px solid; border-radius: 5px;">
			<img src="${info.img_url}" style="max-height:460px; width: 100%" class="show">
		</div>
	</div>
	
	<!-- 레시피 이름 및 개요 -->
	<div style="width: 100%; padding: 0px 10px; text-align: center;">
		<span style="font-size: 35px; font-weight: bold;">${info.recipe_nm_ko}</span>
		<br/>
		<br/>
		${fn: replace(  fn:replace(info.sumry, crlf, '<br>'), lf, '<br>') }
	</div>
	
	<!-- 상세 정보 -->
	<div class="bottomtop-border-2px flexSet-wrap" style="font-size: 20px; width: 100%; justify-content: space-around; margin: 20px 0;">
			<span>유형 : ${info.nation_nm}</span>
			<span>분류 : ${info.ty_nm}</span>
			<span>조리시간 : ${info.cooking_time}</span>
			<span>열량 :
			<c:choose>
				<c:when test="${info.calorie eq '0Kcal'}">no data</c:when>
				<c:when test="${info.calorie eq 'Kcal'}">no data</c:when>
				<c:otherwise>${info.calorie}</c:otherwise>
			</c:choose></span>
			<span>
			난이도 : 
			<c:choose>
				<c:when test="${info.level_nm eq '초보환영'}">★☆☆ (EASY)</c:when>
				<c:when test="${info.level_nm eq '보통'}">★★☆ (NORMAL)</c:when>
				<c:otherwise>★★★ (HARD)</c:otherwise>
			</c:choose>
			</span>
			<span>분량 : ${info.qnt}</span>
	</div>
	
	<!-- 재료 정보 -->
	<div class="flexSet-wrap" style="width: 100%">
	<c:if test="${mainIrdnt != 0}">
		<div class="reciping-irdnt-box">
		<ul>
			<li>주재료</li>
			<li><hr style="height: 2px;"></li>
			<c:forEach var="vo" items="${irdnt}">
				<c:if test="${vo.irdnt_ty_nm eq '주재료'}">
					<li>${vo.irdnt_nm} <span style="float: right;">${vo.irdnt_cpcty}</span></li>
				</c:if>
			</c:forEach>
		</ul>
		</div>
	</c:if>
	<c:if test="${subIrdnt != 0}">
		<div class="reciping-irdnt-box">
		<ul>
			<li>부재료</li>
			<li><hr style="height: 2px;"></li>
			<c:forEach var="vo" items="${irdnt}">
				<c:if test="${vo.irdnt_ty_nm eq '부재료'}">
					<li>${vo.irdnt_nm} <span style="float: right;">${vo.irdnt_cpcty}</span></li>
				</c:if>
			</c:forEach>
		</ul>
		</div>
	</c:if>
	<c:if test="${sauce != 0}">
		<div class="reciping-irdnt-box">
		<ul>
			<li>양념</li>
			<li><hr style="height: 2px;"></li>
			<c:forEach var="vo" items="${irdnt}">
				<c:if test="${vo.irdnt_ty_nm eq '양념'}">
					<li>${vo.irdnt_nm} <span style="float: right;">${vo.irdnt_cpcty}</span></li>
				</c:if>
			</c:forEach>
		</ul>
		</div>
	</c:if>
	</div>
</div>

<!-- 레시피 과정 -->
<c:forEach var="vo" items="${ing}">
<div class="flexSet-wrap bottom-border-2px reciping-content-items">
	<div style="width: 10%">
		<div style="border-radius: 50%; background-color: #000; color: #fff; width: 30px; height: 30px; line-height:30px; text-align: center;">
		${vo.cooking_no}
		</div>
	</div>
	<div style="width: 68%; font-weight: bolder; font-size: 20px">${vo.cooking_dc} </div>
	<c:if test="${! empty vo.stre_step_image_url}">
	<div class="reciping-content-imgbox">
		<div style="width: 100%; height: 100%; overflow: hidden;">
			<img class="show" src="${vo.stre_step_image_url}" style="width: 100%">
		</div>	
	</div>
	</c:if>
</div>
</c:forEach>
</div>
<div id='popup-background'></div>
<div id='image'><img src="" style="height:100%;"></div>
<script type="text/javascript">
$(document).on('click', '.show', function(){
	$('#image, #popup-background').css('display', 'block');
	
	var image = $(this).attr('src');
	$('#image').children().attr('src', image);
}).on('click', '#popup-background', function(){
	$('#image, #popup-background').css('display', 'none');

});
</script>












