<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.container {
	width: 50%; 
	margin: 50px auto;
}
#login { width:100%; border:1px solid #ccc; padding:30px 0; }
#user_email, #user_pw { 
	width:60%; height:40px; 
	padding:5px 3%; margin-bottom:10px;
	border-collapse: collapse;
	border: 0px;
	border-style: none;
	background: none;
	outline: none;
	border-bottom: 1px solid #000000;
	display: block;  }
.login_keep{
	height: 30px;
	line-height: 30px;
	margin-bottom:10px;
}
#login_keep{
	display: none;
}
label {
	color: #888888;
	transition: 0.25s;
	cursor: pointer;
}
label:hover {
	font-weight: bold;
}
#login_keep:checked ~ label {
	color: #000000;
	font-weight: bold;
}
.social {
	display: block;
	margin: 10px 0px;
}
.social img { width:60%; height:42px; }
.bottom {
	font-size: 14px;
	margin-left: 10px;
	transition: 0.25s;
}
.bottom:hover {
	font-weight: bold;
}
</style>

</head>
<body>
	<div class="container" align="center">
		<div id='login'>
			<h3>로그인</h3>
			<form method="post" action=''>
				<input type='text' id='user_email' placeholder="이메일" />
				<input type='password' id='user_pw' placeholder="비밀번호"
					onkeypress="if( event.keyCode==13 ) do_login()"	 />
				<div align="left" style="width:60%;" class="login_keep">
					<input type="checkbox" id="login_keep" /><label for="login_keep">로그인 상태 유지</label>
				</div>
				<a onclick='do_login()' class='btn-fill' style='display:block; margin:auto; width:60%; height:42px; line-height:33px; box-shadow:none;'>로그인</a>
			</form>
			<hr style='width:80%; margin:25px auto'>
			<a class='social' href='kakaoLogin'><img src='imgs/kakao_login.png' alt='카카오로그인' /></a>
			<!-- <a class='social' href='googleLogin'><img src='imgs/google_login.png' alt='구글로그인' /></a> -->
			
			<div align="right" style="width:60%;">
				<a href="join" class="bottom">회원가입</a>
				<a onclick="do_find()" class="bottom">비밀번호 찾기</a>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
function do_login() {
	if ($('#user_email').val() == '') {
		alert('이메일을 입력하세요!');
		$('#user_email').focus();
		return;
	} else if ($('#user_pw').val() == '') {
		alert('비밀번호를 입력하세요!');
		$('#user_pw').focus();
		return;
	}

	$.ajax({
		type: 'post',
		url: 'memberLogin',
		data: { user_email:$('#user_email').val(), user_pw:$('#user_pw').val() },
		success: function( response ){
			if( response ){
				//목록을 제외한 화면과 회원가입화면은e 홈으로 연결
				//그 외는 해당 화면
				location.href = ( document.referrer.match(/member/g)
								 || !document.referrer.match(/list/g) ) 
							? '<c:url value="/"/>' : document.referrer;
			} else {
				alert('이메일이나 비밀번호가 일치하지 않습니다!');
			}
		},error: function(req, text){
			alert(text + ':' + req.status);
		}
	});
}

function do_find() {
	if (confirm('비밀번호를 찾습니다\n비밀번호를 찾고자 한다면 \'확인\'을 눌러주세요')) {
		var confEmail = prompt('이메일을 입력해주세요');
	} 
}
</script>