<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
/*레시피 과정 내용*/
.reciping-content-items{ 
	display:gird;
	grid-template-columns: 100px 2fr;
	grid-auto-rows: minmax(10px, auto);
}
</style>
<div align="left">
<h3>레시피</h3>
<c:forEach var="vo" items="${vo}">
<div class="flexSet-wrap" style="width: 100%; min-height: 100px;">
	<div style="width: 10%">${vo.cooking_no}</div>
	<div style="width: 70%">${vo.cooking_dc} </div>
	<div style="width: 20%">
	<c:if test="${! empty vo.stre_step_image_url}">
		<img src="${vo.stre_step_image_url}" style="width: 100%">
	</c:if>
	</div>
</div>
</c:forEach>
</div>