$(document).ready(function(){

	//location.reload(true);

	$('#userlogoutbtn').click(function(){
		$.ajax({
			type:'POST',
			url:'user_logout.do',
			cache:false,
			success:function(data){
				window.location.href='index.jsp';
			}	
		});
	});

	$("#blank_profile").click(function(){
		window.location.href="userProfile.jsp";
	});

	$('.a1').click(function(){
		$(this).addClass("active");
	});
});