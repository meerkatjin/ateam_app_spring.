$(function() {
	var sdate = new Date();
	sdate.setDate(sdate.getDate() - 3);
	$('.content_list').each(function() {
		var content_date = $('.content_list p:nth-child(2)').val();
		if (content_date >= sdate) {
			$(this).css('background-color', 'pink');
		}
	});
});

function detail(id) {
	$('[name=content_list_id]').val(id);
	$('#irdnt_list').css('display', 'none');
	$('#irdnt_detail').css('display', 'block');
	
	//$('form').attr('action', 'detail.fc');
	//$('form').submit();
}

$(function(){
	$('#filter_type li').removeClass();
	if ($('[name=content_ty_detail]').val() == '고기'){
		$('#filter_type li:eq(0)').addClass('active');
	} else if ($('[name=content_ty_detail]').val() == '수산물'){
		$('#filter_type li:eq(1)').addClass('active');
	} else if ($('[name=content_ty_detail]').val() == '채소'){
		$('#filter_type li:eq(2)').addClass('active');
	} else if ($('[name=content_ty_detail]').val() == '과일'){
		$('#filter_type li:eq(3)').addClass('active');
	} else if ($('[name=content_ty_detail]').val() == '유제품'){
		$('#filter_type li:eq(4)').addClass('active');
	} else if ($('[name=content_ty_detail]').val() == '곡류'){
		$('#filter_type li:eq(5)').addClass('active');
	} else if ($('[name=content_ty_detail]').val() == '조미료/주류'){
		$('#filter_type li:eq(6)').addClass('active');
	} else if ($('[name=content_ty_detail]').val() == '음료/기타'){
		$('#filter_type li:eq(7)').addClass('active');
	}
	
	$('[name=shelf_life_end_detail]').datepicker({
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
		, dateFormat : 'yy년 mm월 dd일'
		, changeYear : true
		, changeMonth : true
		, showMonthAfterYear: true
		, monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월'
							, '7월', '8월', '9월', '10월', '11월', '12월']
		//, beforeShowDay: after
	});
});

$(document).on('click', '#filter_type li', function(){
	$('#filter_type li').removeClass();
	$(this).addClass('active');

	var idx = $('#filter_type li.active').index();
	if (idx == 0) {	//고기
		$('[name=content_ty_detail]').val('고기');
	} else if (idx == 1) {	//수산물
		$('[name=content_ty_detail]').val('수산물');
	} else if (idx == 2) {	//채소
		$('[name=content_ty_detail]').val('채소');
	} else if (idx == 3) {	//과일
		$('[name=content_ty_detail]').val('과일');
	} else if (idx == 4) {	//유제품
		$('[name=content_ty_detail]').val('유제품');
	} else if (idx == 5) {	//곡류
		$('[name=content_ty_detail]').val('곡류');
	} else if (idx == 6) {	//조미료/주류
		$('[name=content_ty_detail]').val('조미료/주류');
	} else if (idx == 7) {	//음료/기타
		$('[name=content_ty_detail]').val('음료/기타');
	}
});

function do_modify() {
	var content_list_id = $('[name=content_list_id_detail]').val();
	$('form').attr('action', 'modify.fc');
		$('form').submit();
}

function do_delete() {
	var content_list_id = $('[name=content_list_id_detail]').val();
	if(confirm('정말 삭제하시겠습니까?')) {
		$('form').attr('action', 'delete.fc');
		$('form').submit();
	}
}