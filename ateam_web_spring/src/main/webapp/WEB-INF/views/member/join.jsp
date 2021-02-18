<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Join</title>
<style type="text/css">
.container {
	width: 60%; 
	margin: 50px auto;
}
#join { width:100%; border:1px solid #ccc; padding:30px 0; }
input[type="text"], input[type="password"] {
	width:70%; height:40px; 
	padding:5px 3%; margin-bottom:10px;
	border-collapse: collapse;
	border: 0px;
	border-style: none;
	background: none;
	outline: none;
	border-bottom: 1px solid #000000;
	display: block;
}
#user_pro_img {
	display: inline-block;
	width: 150px;
	height: 150px;
	position: relative;
	left: -17%;
	border: 2px solid #CCC;
}
#btn-img-upload {
	position: relative;
	left: -15%;
	margin: 0px;
}
#btn-join, #btn-join-cancel {
	padding-left: 90px;
	padding-right: 90px;
}
#btn-join {
	position: relative;
	left: -3%;
}
#btn-join-cancel {
	position: relative;
	right: -3%;
}
.valid, .invalid { font-size:13px; font-weight:bold; float: left; margin-left: 12%; }
.valid { color:green; }
.invalid { color:red; }
</style>
</head>
<body>
	<div class="container">
		<div id="join" align="center">
			<h3>회원가입</h3>
			<p class='w-pct30 right' style='margin:0 auto; padding-bottom:10px; 
				float: right; margin-right: 12%;'>* 는 필수입력항목입니다</p>
			<form method="post" action="join">
				<input type='text' name="user_email" class="check" placeholder="이메일 *" />
				<div class='valid'>유효한 이메일을 입력하세요</div>
				<input type='password' name="user_pw" class="check" placeholder="비밀번호 *" />
				<div class='valid'>영문자, 숫자, 특수문자(! @ # $ % ^ & + -)를 모두 포함해 8~32자를 입력해주세요</div>
				<input type='password' name="user_pwck" class="check" placeholder="비밀번호 확인 *" />
				<div class='valid'>비밀번호를 다시 입력해주세요</div>
				<input type='text' name='user_nm' placeholder="이름(별명) *" />
				<input type='text' name='user_addr' placeholder="주소" />
				<input type='text' name='user_phone_no' placeholder="전화번호" />
				<img src="imgs/logo.balck.small.png" id="user_pro_img" />
				<a class="btn-fill" id="btn-img-upload">사진 업로드</a>
			</form>
			
			<div class="btnSet">
				<a class="btn-fill" id="btn-join" onclick="go_join()">가입</a>
				<a class="btn-empty" id="btn-join-cancel" href='<c:url value="/" />'>취소</a>
			</div>
		</div>
	</div>
	
<script type="text/javascript" src="js/join_check.js"></script>
<script type="text/javascript">
function go_join() {
	if( $('[name=user_email]').val()=='' ){
		alert('이메일을 입력하세요!');
		$('[name=user_email]').focus();
		return;
	}

	alert('test');
}
</script>
</body>
</html>