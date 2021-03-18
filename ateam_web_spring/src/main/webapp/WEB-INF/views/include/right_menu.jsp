<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
.left-container{ position:fixed; margin-left:max(1030px); top:25%; width: 90px; height: 350px; }
.left-content{ height:100%; position: relative; }
.left-top{ height:80%; border: 1px solid #aaa; margin-bottom: 10px; }
.left-top a:first-child {display: block; text-align: center; background-color: #aaa; width: 100%; height: 40px; line-height:39px; color: #fff;
border: 1px solid #fff; font-size: 30px;}
.left-bottom{ height: 33px; width:100%; background-color: #aaa; color: #fff; font-size: 22px; text-align: center;}
.alram-boll{width: 88px; height: 88px; border-radius: 50%; font-size: 50px; text-align: center; line-height: 88px; color: #fff}
</style>
<div class="left-container">
	<div class="left-content">
		<div class="left-top">
		<c:if test='${empty loginInfo}'>
			<a href="login"><i class="fas fa-user-circle"></i></a>
			로그인하세요
		</c:if>
		<c:if test='${!empty loginInfo}'>
			<a href="view.fc"><i class="fas fa-check-circle"></i></a>
			냉장고를 확인해보세요
			<c:if test="${fn:length(getLifeEndList) > 0}">
				<div class="alram-boll curser-pointer" style="background-color: #f45342; margin-top: 5px; margin-bottom: 10px;" onclick="location.href='view.fc'">
				${fn:length(getLifeEndList)}
				</div>
			</c:if>
			<c:if test="${fn:length(getNewContentList) > 0 }">
				<div class="alram-boll curser-pointer" style="background-color: #f4dc42;" onclick="location.href='view.fc'">
				${fn:length(getNewContentList)}
				</div>
			</c:if>
		</c:if>
		</div>
		
		<div class="left-bottom curser-pointer" onclick="window.scrollTo(0,0);"><i class="fas fa-arrow-circle-up"></i></div>
	</div>
</div>