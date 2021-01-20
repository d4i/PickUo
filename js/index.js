$(document).ready(function(){
	$('#nav_open').click(function(){
		$('.navbar').toggle();
	});

	//location.reload(true);
	
	var bagCount = $('#bag_no') ;
	var bag = parseInt(bagCount.text());

	//increaseBagNo();
	
	d=new Date();
	
	$('#pickbtn').datepicker({
		numberOfMonths:2,
		dateFormat:'dd-mm-yy',
		changeYear:true,
		showOtherMonths: true,
		minDate:"0y 0m 0d",
		maxDate:'6m',
		showAnim: "fold"
	});
	
	$('#dob').datepicker({
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

	$('#gminus').click(function(){
		$(this).css('background-color','white');
		$(this).css('border','none');
		
		if(bag>=2||bag<=8){
			//while($('#gplus').click()){
			bag--;
			//alert(bag+"~~~~");
			//}
		}
		
		$('#bag_no').text(bag+' bags');
	
	});

	$('#gplus').click(function(){
		$(this).css('background-color','white');
		
		//alert(bag);

		if(bag>=1||bag<=8){
			//while($('#gplus').click()){
			bag++;
			//alert(bag+"~~~~");
			//}
		}
		
		$('#bag_no').text(bag+' bags');

	});
	
	$('#room_btn').click(function(event){
		event.stopPropagation();
		$('#bagsandrooms').show();
	});
	
	$("#cancel").click(function(){
		$('#bagsandrooms').hide();
		$('#room_btn').text('No. of rooms and bags ');
		$('#room_btn').append('<span class="caret"></span>');
		if($("#bagsandrooms").data("undo")){
			var theClone = $('#bagsandrooms').data('undo');
			$('#bagsandrooms').replaceWith(theClone);
		}
	});

	//alert($('.spanid').text());
	//alert($('#room_btn').text());

	$('#done').click(function(){
		$('#room_btn').text($('.spanid').text()+" , ");
		$('#room_btn').append($('.divid').text()+" ");
		$('#room_btn').append('<span class="caret"></span>');
		$('#bagsandrooms').hide();
	});

	$('#resetbtn').click(function(){
		$('#signup_form').trigger("reset");
	});

	$('#userloginbtn').click(function(){
		//$('#myModal').data-dismiss('modal');
		$('#login').effect("highlight", {color:"1px solid #c0c0c0"},3000);
	});

	/*$('#search_hotel').click(function(){
		
	});*/

	$(document).ready(function(){
		$('[data-toggle="tooltip"]').tooltip();   
	});
	

});