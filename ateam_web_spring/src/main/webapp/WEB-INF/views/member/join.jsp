<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	left: -14%;
	border: 2px solid #CCC;
}
#btn-img-upload {
	position: relative;
	left: -10%;
	margin: 0px;
}
#btn-join, #btn-join-cancel {
	padding-left: 90px;
	padding-right: 90px;
}
#btn-join {
	position: relative;
	left: 0%;
}
#btn-join-cancel {
	position: relative;
	right: 0%;
}
.valid, .invalid { font-size:13px; font-weight:bold; float: left; margin-left: 15%; }
.valid { color:green; }
.invalid { color:red; }
</style>
<div class="container">
	<div id="join" align="center">
		<h3>회원가입</h3>
		
		<p class='w-pct30 right' style='margin:0 auto; padding-bottom:10px; 
			float: right; margin-right: 15%;'>* 는 필수입력항목입니다</p>
		<form method="post" action="joinRequest">
			<div>
				<input type='text' name="user_email" class="chk" placeholder="이메일 *" />
				<a class="btn-fill-s" id="btn-email">중복확인</a>
				<div class='valid'>유효한 이메일을 입력하세요</div>
			</div>
			
			<div>
				<input type='password' name="user_pw" class="chk" placeholder="비밀번호 *" />
				<div class='valid'>영문자, 숫자, 특수문자(! @ # $ % &amp; + -)를 모두 포함해 8~32자를 입력해주세요</div>
			</div>
			
			<div>
				<input type='password' name="user_pwck" class="chk" placeholder="비밀번호 확인 *" />
				<div class='valid'>비밀번호를 다시 입력해주세요</div>
			</div>
			
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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="js/join_check.js"></script>
<script type="text/javascript">
function go_join(){
	//중복확인 한 경우 : chked 클래스가 있음
	if( $('[name=user_email]').hasClass('chked') ){
		if( $('[name=user_email]').siblings('div').hasClass('invalid') ){
			alert('회원가입 불가!\n' + join.id.unusable.desc );
			$('[name=user_email]').focus();
			return;
		}
	
	}else{
	//중복확인 하지 않은 경우
		if( ! item_check( $('[name=user_email]') ) ) return;
		else{
			alert( join.email.valid.desc );
			$('[name=user_email]').focus();
			return;
		}
	}
	
	if( ! item_check( $('[name=user_pw]') ) ) return;
	if( ! item_check( $('[name="user_pwck"]') ) ) return;
	if( ! item_check( $('[name=user_email]') ) ) return;
	
	$('form').submit();
}

function item_check( tag ){
	var result = join.tag_status( tag );
	if( result.code =='invalid' ){
		alert( '회원가입 불가!\n' + result.desc );
		tag.focus();
		return false;
	}else return true;
}

$('#btn-email').on('click', function(){
	email_check();
});

function email_check(){
	var $user_email = $('[name=user_email]');
	var data = join.tag_status( $user_email );
	if( data.code == 'invalid'){
		alert( '중복확인 불필요\n' + data.desc );
		$user_email.focus();
		return;
	}
	$.ajax({
		type: 'post',
		url: 'email_check',
		data: { user_email: $user_email.val() },
		success: function( response ){
			response = join.email_usable( response );
			$user_email.siblings('div').text( response.desc );	
			$user_email.siblings('div').removeClass();
			$user_email.siblings('div').addClass( response.code );
			$user_email.addClass('chked');
		
		},error: function(req, text){
			alert(text+':'+req.status );
		}
	});
}

$('.chk').on('keyup', function(e){
	if( $(this).attr('name')=='user_email' ){
		if( e.keyCode==13 ){
			email_check();
			return;
		}else
			$(this).removeClass('chked');
	} 
	validate( $(this) );
});

function validate( tag ){
	var data = join.tag_status( tag );
	
	tag.siblings('div').text( data.desc );	
	tag.siblings('div').removeClass();
	tag.siblings('div').addClass( data.code );
}
</script>