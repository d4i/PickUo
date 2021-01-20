$(document).ready(function(){	
	$('.materialboxed').materialbox();	
});

var room_id,room_no,capactity,img;

$.post("collect_rooms.do",function(data){
		//alert('rooms collected ');
		//alert(data);
		var obj = JSON.parse(data);
		
		alert(obj[0].roomId);
		
		//createCard();
	});


$('#delete_btn').click(function(){
	$.ajax({
		type:'post',
		url:'delete_room.do',
		success:function(){
			//var btnid = $(this).attr('id');
			//var divid = $(btnid).sibling().attr('id');
			//alert(btnid);
		}
	});
});
