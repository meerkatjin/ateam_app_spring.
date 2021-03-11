<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Modify</title>
<style type="text/css">
.container {
	width: 60%; 
	margin: 50px auto;
}
#join { width:100%; border:1px solid #ccc; padding:30px 0; }
.join-box { width:70%; height:100px; padding: 10px 0; position: relative; }
input[type="text"], input[type="password"] {
	width:100%; height:50px;
	padding:5px 3%;
	border: 0px;
	border-style: none;
	background: none;
	outline: none;
	border-bottom: 1px solid #bbb;
	display: block;
	position: relative;
}
#btn-email {margin-top: 8px; margin-left: 7%; height: 30px;}
.btnSet a {
	display: inline-block;
	width: 23%;
}
.valid, .invalid { font-size:13px; font-weight:bold; float: left; margin-left: 5%; display: none; }
.valid { color:green; }
.invalid { color:red; }
span{ position: absolute; top:15px; left: 3%; transition: transform 0.35s; color: #bbb;}

input:focus { border-bottom: 2px solid #000; }
input:focus + span { 
	color: #000;
	-webkit-transform: translate(0px, -20px);
	-ms-transform: translate(0px, -20px);
	transform: translate(0px, -20px);
	transition: transform 0.35s; }

.infrom { 
	color: #bbb;
	-webkit-transform: translate(0px, -20px);
	-ms-transform: translate(0px, -20px);
	transform: translate(0px, -20px);
	transition: transform 0.35s; }

</style>

<div class="container">
	<div id="join" align="center">
		<h3>회원정보수정</h3>
		
		<p class='w-pct30 right' style='margin:0 auto; padding-bottom:10px; 
			float: right; margin-right: 15%;'>* 는 필수입력항목입니다</p>
		<form method="post" action="modifyRequest">
		<input type="hidden" name="user_id" value="${loginInfo.user_id }" />
			<div class="join-box flexSet-wrap">
				<input type='text' name="user_email" class="chk" 
					style="width: 70%"
					value="${loginInfo.user_email }" readonly />
				<span>* 이메일 변경</span>
				<a class="btn-fill" id="btn-email" onclick="email_modify()">이메일 변경</a>
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
			<a class="btn-empty" id="btn-withdrawal" onclick="go_withdrawal()">회원탈퇴</a>
			<a class="btn-empty" id="btn-join-cancel" href='<c:url value="/" />'>취소</a>
		</div>
	</div>
</div>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="js/join_check.js"></script>
<script type="text/javascript">
function go_modify(){
// 	//중복확인 한 경우 : chked 클래스가 있음
// 	if( $('[name=user_email]').hasClass('chked') ){
// 		if( $('[name=user_email]').siblings('div').hasClass('invalid') ){
// 			alert('회원가입 불가!\n' + join.email.unusable.desc );
// 			$('[name=user_email]').focus();
// 			return;
// 		}
	
// 	}else{
// 	//중복확인 하지 않은 경우
// 		if( ! item_check( $('[name=user_email]') ) ) return;
// 		else{
// 			alert( join.email.valid.desc );
// 			$('[name=user_email]').focus();
// 			return;
// 		}
// 	}
	if (confirm('입력하신 내용으로 회원정보를 수정합니다.\n수정하시겠습니까?')) {
		if( ! item_check( $('[name=user_pw]') ) ) return;
		if( ! item_check( $('[name=user_pwck]') ) ) return;
		if( ! item_check( $('[name=user_nm]') ) ) return;
		
		$('form').submit();

	}
}

function go_withdrawal() {
	var inputEmail = prompt('회원탈퇴를 진행합니다.\n이메일을 입력해주세요.');
	if ($('[name=user_email]').val() == inputEmail) {
		if (confirm('정말로 탈퇴하시겠습니까?')) {
			
			$('form').attr('action', 'withdrawal');
			$('form').submit();
		}
	} else {
		alert('이메일이 일치하지 않습니다.');
	}
}

function item_check( tag ){
	var result = join.tag_status( tag );
	if( result.code =='invalid' ){
		alert( '오류가 발생했습니다!\n' + result.desc );
		tag.focus();
		return false;
	}else return true;
}

function email_modify() {
	if(confirm('이메일을 변경합니다.\n지금 사용중인 이메일로 변경하실 수 없습니다.')) {
		$('[name=user_email]').attr('readonly', false);
	}
}

$('[name=user_email]').on('blur', function(){
	email_check();
});

function email_check(){
	var $user_email = $('[name=user_email]');
	var data = join.tag_status( $user_email );
	if( data.code == 'invalid'){
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

$(function(){
	$('.chk').each(function(){
		if( $(this).val()!='' ){
			$(this).focus();
		}
	});
});

$('.chk').on('keyup', function(e){
	if( $(this).attr('name')=='user_email' ){
		if( e.keyCode==13 ){
			email_check();
			return;
		}else
			$(this).removeClass('chked');
	}

	validate( $(this) );
}).on('blur', function(e){
	if( $(this).val()==''){
		$(this).siblings('span').removeClass('infrom');
	}else{
		$(this).siblings('span').addClass('infrom');
	}
});

function validate( tag ){
	var data = join.tag_status( tag );
	
	tag.siblings('div').text( data.desc );	
	tag.siblings('div').removeClass();
	tag.siblings('div').addClass( data.code );
	tag.siblings('div').css('display', 'block')
}
</script>