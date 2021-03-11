var join = {
	
	common: {
		space: { code:'invalid', desc: '공백없이 입력하세요' }
		, empty: { code:'invalid', desc:'입력하세요' }	
		, max: { code:'invalid', desc:'최대 10자이하 입력하세요' }
		, min: { code:'invalid', desc:'최소 5자이상 입력하세요' }
	},
	
	
	email_usable: function( data ){
		if( data )  return this.email.unusable;
		else        return this.email.usable;
	},
	
	tag_status: function( tag ){
		var data = tag.val();
		tag = tag.attr('name');
		if( tag=='user_pw' ){
			return this.pw_status( data );
		}else if( tag=='user_pwck' ){
			return this.pw_ck_status( data );
		}else if( tag=='user_email' ){
			return this.email_status( data );
		}else {
			return null;
		}
	},
	
	email: {
		valid: { code:'valid', desc:''}
		, invalid: { code:'invalid', desc:'사용 불가능한 이메일입니다'}
		, usable : { code:'valid', desc:'사용가능한 아이디입니다' }
		, unusable : { code:'invalid', desc:'이미 사용중인 이메일입니다' }
	},
	
	email_status: function(email){
		var reg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if( email=='' ) return this.common.empty;
		else if( reg.test(email) ) return this.email.valid;
		else return this.email.invalid;
	},
	
	pw_ck_status: function( pw_ck ){
		if( pw_ck=='' ) return this.common.empty;
		else if( pw_ck == $('[name=user_pw]').val() ) return this.pw.equal;
		else return this.pw.notEqual;
	},
	
	pw : {
		valid: { code:'valid', desc:'사용가능한 비밀번호입니다' }
		, invalid : { code:'invalid', desc:'비밀번호는 영문 대/소문자, 숫자만 입력 가능합니다' }	
		, lack : { code:'invalid', desc:'비밀번호는 영문 대/소문자, 숫자를 모두 포함해야 합니다' }
		, equal: { code:'valid', desc:'비밀번호가 일치합니다' }
		, notEqual: { code:'invalid', desc:'비밀번호가 일치하지 않습니다'}	
	},
	
	pw_status: function( pw ){
		var reg = /[^a-zA-Z0-9]/g;
		var upper = /[A-Z]/g, lower = /[a-z]/g, digit = /[0-9]/g;
		if( pw=='' ) return this.common.empty;
		else if( pw.match(space) ) return this.common.space;
		else if( reg.test(pw) ) return this.pw.invalid;
		else if( pw.length < 5 ) return this.common.min;
		else if( pw.length > 10 ) return this.common.max;
		else if( !upper.test(pw) || !lower.test(pw) || !digit.test(pw) )  
						return this.pw.lack;
		else                      return this.pw.valid;
	}
}
var space = /\s/g;