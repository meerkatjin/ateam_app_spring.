<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<header class="tm-header" id="tm-header">
  <div class="tm-header-wrapper">
      <button class="navbar-toggler" type="button" aria-label="Toggle navigation">
          <i class="fas fa-bars"></i>
      </button>
      <div class="tm-site-header">
          <div class="mb-3 mx-auto tm-site-logo"><i class="fas fa-times fa-2x"></i></div>            
          <h1 class="text-center">속보이는 냉장고</h1>
      </div>
  <!-- 로그인 / 회원가입 버튼 -->
  <div id="main-button">
   <a href="login" class="mb-2 tm-btn tm-btn-primary tm-prev-next">로그인</a>
   <a href="join" class="mb-2 tm-btn tm-btn-primary tm-prev-next">회원가입</a>
  </div> 
      <nav class="tm-nav" id="tm-nav">            
          <ul>
              <li class="tm-nav-item active"><a href='<c:url value="/" />' class="tm-nav-link">
                  <i class="fas fa-home"></i>
                  Home
              </a></li>
              <li class="tm-nav-item"><a href="post.html" class="tm-nav-link">
                  <i class="fas fa-pen"></i>
                  소개글
              </a></li>
              <li class="tm-nav-item"><a href="about.html" class="tm-nav-link">
                  <i class="fas fa-users"></i>
                  상품
              </a></li>
              <li class="tm-nav-item"><a href="commu" class="tm-nav-link">
                  <i class="far fa-comments"></i>
                  커뮤니티
              </a></li>
          </ul>
      </nav>
  </div>
</header>