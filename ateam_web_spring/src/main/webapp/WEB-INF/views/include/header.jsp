<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<header style='border-bottom:1px solid #ccc; padding:15px 0; text-align:left'>
	<div class='category' style='margin-left:100px'>
	<ul>
		<li><a href='<c:url value="/" />'><img src='imgs/hanul.logo.png'/></a></li>
		<li><a class="${category eq 'it' ? 'active' : ''}" href='intro.it'>소개글</a></li>
		<li><a class="${category eq 'no' ? 'active' : ''}" href='list.no'>공지사항</a></li>
		<li><a class="${category eq 'pd' ? 'active' : ''}" href='product.pd'>상품</a></li>
		<li><a class="${category eq 'rp' ? 'active' : ''}" href='list.rp'>레시피</a></li>
		<li class="menu"><a class="${category eq 'cu' ? 'active' : ''}" href='commu.cu'>커뮤니티</a>
			<ul class="submenu">
				<li><a href="#">공지사항</a></li>
				<li><a href="#">자주묻는 질문</a></li>
				<li><a href="#">게시판</a></li>
			</ul>
		</li>
	</ul>
	</div>
	
	<div style='position:absolute; right:0; top:25px; margin-right:100px'>
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
	margin:0; padding:0; display:inline }
.category { font-size:18px }
.category li:not(:first-child) { padding-left:30px }
.category li a:hover,
.category li a.active { font-weight:bold; color:#0000cd; }
</style>