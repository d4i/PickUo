var obj;

//$('#gallery').hide();

$(document).ready(function(){
	$.ajax({
		url : 'get_room.do',
		method : 'post',
		success : function (data){			
			obj = JSON.parse(data);	
		   //console.log(obj);
			//console.log(obj[2][0].hotel.address.city.city);
			//console.log(typeof(obj[2]))
			//$.each(obj[2],function(i,value){
			//	console.log(value.hotel.address.city);
		   //});

			$('#search_results').hide();
			var citn=[];
			//var ct;
			
			var func = $.each(obj[2],function(i,value){
				ct = document.createElement('tr');
				ht = document.createElement("tr");
				ct.innerHTML = value.hotel.address.city.city ;
				ht.innerHTML = value.hotel.hotelName;
				document.getElementById('search_results').appendChild(ct);
				document.getElementById('search_results').appendChild(ht);
				
				//console.log(value.hotel.address.city.city);				
				//console.log(typeof(citn));	//great~~~
			
			});

			$('#search_hotel').keyup(obj,function(){
				var input = $(this).val().toLowerCase();
				//console.log(obj);		//working - good work	
				//console.log(citn);
				//$('#search_results').show();

				var seen = {};
				$('#search_results tr').each(function(){
					var txt = $(this).text();
					if(seen[txt])
						$(this).remove();
					else
						seen[txt] = true;

					$('tr').css({
						"cursor":'pointer',
						"font-size":'20px',
						'font-style':'italic',
						'color':'#6f6f6f'
					});
					//$('#search_results tr').attr({"class":"selectable"});
					
				});
				$('tr').click(function(){
					$('#search_hotel').val(($(this).text()));
					$('#search_results').hide();
				});
			//});
				
				
				$('#search_results tr').filter(function(){
					$(this).toggle($(this).text().toLowerCase().indexOf(input) > -1);
					//console.log(this);		//~~~'this' is '<tr>' ~ object
					//console.log($(this).length);	//~~~~string
					
					$('#search_results').show();
					
					//$('.selectable').selectable();
				});
				if(input==0){
					$('#search_results').hide();
				}
			});

			$('#search_hotel').click(function(){
				$(this).removeAttr("type");
				$(this).attr({
					"type":"text",
					"value":"",
					"placeholder":"search by city or hotel name"
					//"class":"dropdown-toggle",
					//"data-toggle":"dropdown"
				});
			});
		}
	});
	
	//alert(capacity);
	$('#searchPickup').click(function() {
		console.log('hello');
		var cap = $('#room_btn').text().substr(10,2);
		
		if(cap.match(/(\d+)/)) {
			//cap.replace(/[^0-9]/g,'');
			console.log(`${cap}`);
			
			var url = `search_pickup.do?cityHotelname=${$('#search_hotel').val()}&date_=${$('#pickbtn').val()}&capacity=${cap}`;
			//console.log(url);
			$.ajax({
				method:'get',
				url : url,
				success : function(data) {
					//alert("deepti");
					//console.log(data);
				}
			})
			$('#rooms').html($('<img>').attr('src',url));
			//$('#gallery').show();
			
			
		}
	}); 
		
	//};
});

