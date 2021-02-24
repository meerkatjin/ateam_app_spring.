<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.left-container{ position:fixed; margin-left:max(1030px); top:25%; width: 90px; height: 350px; }
.left-content{ height:100%; position: relative; }
.left-top{ height:80%; border: 1px solid #aaa; margin-bottom: 10px; }
.left-top a:first-child {display: block; text-align: center; background-color: #aaa; width: 100%; height: 40px; line-height:35px; color: #fff;
border: 1px solid #fff; font-size: 30px;}
.left-bottom{ height: 10%; width:100%; background-color: #aaa; color: #fff; font-size: 22px; text-align: center;}
</style>
<div class="left-container">
	<div class="left-content">
		<div class="left-top">
		<c:if test='${empty loginInfo}'>
			<a href="login"><i class="fas fa-user-circle"></i></a>
			로그인하슈
		</c:if>
		<c:if test='${!empty loginInfo}'>
			<a href="view.fc">냉장고</a>
		</c:if>
		</div>
		
		<div class="left-bottom curser-pointer" onclick="window.scrollTo(0,0);"><i class="fas fa-arrow-circle-up"></i></div>
	</div>
</div>