$(document).ready(function(){

	$('#login').css('display','none');

	$('#Logout').hide();

	$('#verifyotp').click(function(){
		var oottpp = { 
			otp : $('#otp').val()
		}

		alert(oottpp.val());
		
		$.ajax({
			method:'post',
			url:'verifyotp.do',
			data:oottpp,
			success:function(){
				alert("otp verifed"+ msg);
			}
		})
	});

	$('#signup').click(function(){
		$('#scrollable').toggle("slide", { direction: "right" },500);
		$('#login').hide("slide", { direction: "right" },100);
	});

	$('#Login').click(function(){
		$('#login').toggle("slide", { direction: "right" },500);
		$('#scrollable').hide("slide", { direction: "right" },100);
		//$.ajax({cache:false});
	});

	$('#resetbtn').click(function(){
		$('#becomePickup').trigger("reset");
	});	
	
	$('#foundedOn').datepicker({
		numberOfMonths:1,
		dateFormat:'yy-mm-dd',
		changeYear:true,
		changeMonth:true,
		showOtherMonths: true,
		showWeek:true,
		yearRange:"1940:+1y",
		//minDate:new Date(1940,0,1),
		showAnim: "fold"
	});
 });

  
function sendOTP(){
	var db = {
		hotelName : $("#hotel_name").val(),
		email : $("#email").val()
	}
	//console.log(db);
	
	$.ajax({
		method: "post",
		url: "sendMail.do",
		data: db,
		success:function(data){
			console.log(data);
			alert('otp send');
			$('#sendotp').addClass("btn-success");
	}});/*.done(function(msg){
		alert("done");
	});*/
}