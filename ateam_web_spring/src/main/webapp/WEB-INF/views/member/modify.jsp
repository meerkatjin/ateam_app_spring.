<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Modify</title>
<style type="text/css">
	@import url(resources/css/member_modify.css);
</style>

<div class="container">
	<div id="join" align="center">
		<h3>회원정보수정 / 회원탈퇴</h3>
		
		<p class='w-pct30 right' style='margin:0 auto; padding-bottom:10px; 
			float: right; margin-right: 15%;'>* 는 필수입력항목입니다</p>
		<form method="post" action="modifyRequest">
		<input type="hidden" name="user_id" value="${loginInfo.user_id }" />
			<div class="join-box flexSet-wrap">
				<input type='text' name="user_email" class="chk" 
					style="width: 100%"
					value="${loginInfo.user_email }" readonly />
				<span>* 이메일 변경</span>
				<!-- <a class="btn-fill" id="btn-email" onclick="email_modify()">이메일 변경</a> -->
				<div class='valid'>유효한 이메일을 입력하세요</div>
			</div>
			
			<div class="join-box flexSet-wrap">
				<input type='password' name="user_pw" class="chk" value="${loginInfo.user_pw }"/>
				<span>* 비밀번호 변경</span>
				<div class='valid'>
				영문자, 숫자, 특수문자(! @ # $ % &amp; + -)를<br/>
				모두 포함해 8~32자를 입력해주세요
				</div>
			</div>
			
			<div class="join-box flexSet-wrap">
				<input type='password' name="user_pwck" class="chk"  />
				<span>* 비밀번호 변경 확인</span>
				<div class='valid'>비밀번호를 다시 입력해주세요</div>
			</div>
			
			<div class="join-box flexSet-wrap">
				<input type='text' name='user_nm' class="chk" value="${loginInfo.user_nm }"/>
				<span>* 이름(별명) 변경</span>
			</div>
		</form>
		
		<div class="btnSet">
			<a class="btn-fill" id="btn-join" onclick="go_modify()">변경</a>
			<a class="btn-empty" id="btn-withdrawal" onclick="go_withdrawal(${loginInfo.user_id})">회원탈퇴</a>
			<a class="btn-empty" id="btn-join-cancel" href='<c:url value="/" />'>취소</a>
		</div>
	</div>
</div>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="js/join_check.js"></script>
<script type="text/javascript" src="js/member_modify.js"></script>