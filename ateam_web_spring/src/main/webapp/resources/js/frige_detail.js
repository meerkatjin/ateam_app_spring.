var filter = document.getElementById("filter_type");
$(function(){
	if ($('[name=content_ty]').val() == '고기') {
		filter[1].selected = true;
	} else if ($('[name=content_ty]').val() == '수산물') {
		filter[2].selected = true;
	} else if ($('[name=content_ty]').val() == '채소') {
		filter[3].selected = true;
	} else if ($('[name=content_ty]').val() == '과일') {
		filter[4].selected = true;
	} else if ($('[name=content_ty]').val() == '유제품') {
		filter[5].selected = true;
	} else if ($('[name=content_ty]').val() == '곡류') {
		filter[6].selected = true;
	} else if ($('[name=content_ty]').val() == '조미료/주류') {
		filter[7].selected = true;
	} else if ($('[name=content_ty]').val() == '음료/기타') {
		filter[8].selected = true;
	}

	$('[name=shelf_life_end]').datepicker({
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토']
		, dateFormat : 'yy-mm-dd'
		, changeYear : true
		, changeMonth : true
		, showMonthAfterYear: true
		, monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월'
							, '7월', '8월', '9월', '10월', '11월', '12월']
		//, beforeShowDay: after
	});
});

function filterType() {
	var value = filter.options[filter.selectedIndex].value;
	
	$('[name=content_ty]').val(value);
}

function do_modify() {
	if(confirm('수정하시겠습니까?')) {
		$('form#formM').submit();
	}
}

function do_delete(id) {
	$('[name=content_list_id').val(id);
	if(confirm('정말 삭제하시겠습니까?')) {
		$('form').attr('action', 'delete.fc');
		$('form').submit();
	}
}