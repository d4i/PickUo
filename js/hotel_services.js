$(document).ready(function(){

	/*$("#sf").on("submit",function(event){
		//event.preventDefault();
		for (let a of new FormData($("#sf")[0]) )
		{
			console.log(a);
		}
	});*/	
	//####################################################################
	
	$('#signup').hide();
	$('#Login').hide();
	$('#addRoom').hide();
	$('#available_room_div').hide();
	$('#delete_room_div').hide();
	$('#bookedRoom').hide();


	$('#available_room').click(function(){
		$('#available_room_div').toggle(300);
		$('#addRoom').hide();
		$('#delete_room_div').hide();
		$('#bookedRoom').hide();
		$('#appendAll').load("show_room.do",{"btnId":"available_room"});

		/*$.post("show_room.do",function(data){		
		}).done(function (data){
			alert(data);

			//$("#insert").html("<h1>yadav</h1>");
			//$("#insert").text("<h1>sandeep</h1>");
		});*/
		
	});


	$("#add_room").click(function(){
		///code for validation if session expires then send to index page
		//checkSession();
		$('#bookedRoom').hide();
		$("#addRoom").toggle(300);
		$('#available_room_div').hide();
		$('#delete_room_div').hide();
	});

	$("#delete_room").click(function(){
		$('#available_room_div').hide();
		$('#bookedRoom').hide();
		$('#delete_room_div').toggle(300);
		$('#delbtn').load("show_room.do",{"btnId":"delete_room"});
		$('#addRoom').hide();
		
	});
	
	$('#booked_room').click(function(){
		$('#available_room_div').hide();
		$('#addRoom').hide();
		$('#delete_room_div').hide();
		$('#bookedRoom').toggle(300);
	});
	
	$('#roomCapacity').keyup(function(){
		$('#capacityNo').html($('#roomCapacity').val());
		//console.log('on key press');
	});

	$('.materialboxed').materialbox();

	

	$('#Logout').click(function(){
		$.ajax({
			type:'post',
			url:'hotel_logout.do',
			success:function(){
				alert("logged out");
			}
		});
	});
	
	$('#showImg').change(function(){
		readURL('#uploadImage');
	});

	
	function readURL(input) {

	  if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
		  $('#a').attr('src', e.target.result);
		}

		reader.readAsDataURL(input.files[0]);
	  }
	}
});

//////////////////////////////////////

/*
function checkSession() {
    var request = false;
    if(window.XMLHttpRequest) { // Mozilla/Safari
        request = new XMLHttpRequest();
    } else if(window.ActiveXObject) { // IE
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    request.open('POST', 'SessionCheck.aspx', true);
    request.onreadystatechange = function() {
        if(request.readyState == 4) {
            var session = eval('(' + request.responseText + ')');
            if(session.valid) {
                // DO SOMETHING IF SESSION IS VALID
            } else {
                alert("Your Session has expired");
                window.location = "index.jsp";
            }
        }
    }
    request.send(null);
}

*/