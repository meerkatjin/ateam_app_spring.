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
	
	$('form').attr('action', 'detail.fc');
	$('form').submit();
}