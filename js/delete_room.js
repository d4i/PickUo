$(document).ready({
	$('.btn-floating').click(){
		$.ajax({
			type:'post',
			url: 'delete_room.do?room_id='+',
			success: function(){
				$('#delbtn').load("show_room.do",{"btnId":"delete_room"});
			}
		})
	}
});