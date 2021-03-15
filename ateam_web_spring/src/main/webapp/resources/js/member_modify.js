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