<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<header id="top">
	<div class='category' style='margin-left:100px;'>
	<ul class="nav-list">
		<li class="nav-list"><a href='<c:url value="/" />'><img src='imgs/logo.white.horizontal.png' class="logo-header-size"/></a></li>
		<li class="nav-list"><a class="${category eq 'it' ? 'active' : ''} nav" href='intro.it'>소개글</a></li>
		<li class="nav-list"><a class="${category eq 'fc' ? 'active' : ''} nav" href='view.fc'>My 냉장고</a></li>
		<li class="nav-list"><a class="${category eq 'rp' ? 'active' : ''} nav" href='list.rp'>레시피</a></li>
		<li class="nav-list"><a class="${category eq 'cu' ? 'active' : ''} nav" href='commu.cu'>커뮤니티</a></li>
	</ul>
	</div>
	
	<div style='position:absolute; right:0; top:25px; margin-right:100px; display: inline;'>
	<ul>
		<!-- 로그인하지 않은 경우 -->
		<c:if test='${empty loginInfo}'>
		<li><a class='btn-fill' href='login'>로그인</a></li>
		<li><a class='btn-fill' href='join'>회원가입</a></li>
		</c:if>
		<!-- 로그인한 경우 -->
		<c:if test='${!empty loginInfo}'>
		<li style='padding-right:10px'><strong>${loginInfo.name}</strong>님</li>
		<li><a class='btn-fill' href='logout'>로그아웃</a></li>
		</c:if>
	</ul>
	</div>
</header>
<style>
header ul, header ul li { 
	margin:0px auto; padding:0; display:inline;}
#top { border-bottom:1px solid #ccc; padding:0px 0; text-align:left; background-color: #000000; overflow:hidden; min-width: 1024px; }
.nav-list { 
	margin:0px auto; padding:0; overflow: hidden; float: left;}
.category { font-size:18px }
.category li .nav{ color:#ffffff; display:block; line-height:70px; height: 70px; padding: 0px 20px; }
.category li .nav:hover,
.category li .nav.active { font-weight:bold; background-color:#ddd; color:#000; }

</style>