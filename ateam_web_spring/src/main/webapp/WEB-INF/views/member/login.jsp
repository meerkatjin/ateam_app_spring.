<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	@import url(resources/css/login.css);
</style>

<div class="container" align="center">
	<div id='login'>
		<h3>로그인</h3>
		<form method="post" action=''>
			<input type='text' id='user_email' placeholder="이메일" value="${cookie.user_check.value }"/>
			<input type='password' id='user_pw' placeholder="비밀번호"
				onkeypress="if( event.keyCode==13 ) do_login()"	 />
			<div align="left" style="width:60%;" class="email_keep">
				<input type="checkbox" id="email_keep" name="email_keep" /><label for="email_keep">이메일 기억하기</label>
			</div>
			<a onclick='do_login()' class='btn-fill' style='display:block; margin:auto; width:60%; height:42px; line-height:42px; box-shadow:none;'>로그인</a>
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
$(document).ready(function(){
	// 쿠키를 이용한 이메일 저장 기능
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var key = getCookie("key");
    $("#user_email").val(key); 
     
    if($("#user_email").val() != ""){ // 그 전에 이메일를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 이메일이 표시된 상태라면,
        $("#email_keep").attr("checked", true); // 이메일 기억하기를 체크 상태로 두기.
    }
     
    $("#email_keep").change(function(){ // 체크박스에 변화가 있다면,
        if($("#email_keep").is(":checked")){ // 이메일 기억하기 체크했을 때,
            setCookie("key", $("#user_email").val(), 7); // 7일 동안 쿠키 보관
        }else{ // 이메일 기억하기 체크 해제 시,
            deleteCookie("key");
        }
    });
     
    // 이메일 기억하기를 체크한 상태에서 이메일을 입력하는 경우, 이럴 때도 쿠키 저장.
    $("#user_email").keyup(function(){ // 이메일 입력 칸에 이메일을 입력할 때,
        if($("#email_keep").is(":checked")){ // 이메일 기억하기를 체크한 상태라면,
            setCookie("key", $("#user_email").val(), 7); // 7일 동안 쿠키 보관
        }
    });
});

//쿠키 설정
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}

//쿠키 삭제
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}

//쿠키에서 값 가져오기
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}

//로그인 기능
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
		}, error: function(req, text){
			alert(text + ':' + req.status);
		}
	});
}

//비밀번호 찾기 기능
function do_find() {
	if (confirm('비밀번호를 찾습니다\n비밀번호를 찾고자 한다면 \'확인\'을 눌러주세요')) {
		var confEmail = prompt('이메일을 입력해주세요').trim();

		$.ajax({
			type: 'post',
			url: 'email_check',
			data: {user_email: confEmail},
			success: function( response ){
				//가입된 이메일이라면 이메일로 비밀번호 전송
				if( response ){
					if (confirm('이메일로 비밀번호를 전송합니다')) {
						alert('이메일로 비밀번호를 전송했습니다\n이메일에서 확인 후 로그인해주세요');
					}
				//없는 이메일이라면 알림으로 알려주고 찾기 종료
				} else {
					alert('가입되어있지 않은 이메일입니다!');
				}
			}, error: function(req, text){
				alert(text + ':' + req.status);
			}
		});		
	} 
}
</script>