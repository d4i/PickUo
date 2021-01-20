<div id="" class="container">
	<div class='col-md-12 col-lg-12 col-sm-12 col-xs-12 ' id='view_bar'>
		<img id='travel_img' src='../images/travel2.jpg' class='img-responsive center-block'/>
		<div class='centered'><h1>India's Largest Chain</h1></div>
	</div>	
	<!-- <form> --><!--  action="search_pickup.do"> -->
		<div class='btn-group ' id='search_bar'>	  
			<div id=""  class='btn-group form-group'>
				<input type='button' class='btn btn-default btn-lg' id='search_hotel' value='Search by city or hotel name' name='cityHotelname' required autocomplete='off'>	
			</div>	
			
			<!-- <input type='' name='deepti' value='sandeep'/> -->
			<div id="" class="btn-group form-group">
				<input type='button' class='btn btn-default btn-lg ' id='pickbtn' value='Select date' name='date_' required>
				<br />
			</div>
			<div id="" class="btn-group dropdown form-group">
				<button type='button' class='btn btn-default btn-lg dropdown-toggle' data-toggle="dropdown" id='room_btn' name='capacity' required>No. of rooms and bags <span class="caret"></span></button>
				<ul class='dropdown-menu' id='bagsandrooms'>
					<li id='list1'>
						<span id="gminusbtn" class="">
							<button type='button' class='btn btn-default btn-lg' id='gminus'>
							  <span class='glyphicon glyphicon-minus' style="font-size:20px;color:#ff0000"></span>
							</button>
						</span>
						<span id="room" class="">
							<span class='spanid' id='room_no'>Room 1 </span>
							
						</span>		
						<span id="gplusbtn" class="">
							<button type='button' class='btn btn-default btn-lg' id='gplus'>
							  <span class='glyphicon glyphicon-plus' style="font-size:25px;color:#00ff40"></span>
							</button>
						</span><br/>
						<div class='divid' id='bag_no'>2 bags</div>
					</li>
					<li class='divider'></li>
					<div id="" class="btn-group">
						<!-- <li class=''> -->
							<button type='button' class='btn btn-default' id=''><span class='glyphicon glyphicon-minus-sign'></span>Delete room</button>
							<button type='button' class='btn btn-default pull-right' id=''>Add room<span class='glyphicon glyphicon-plus-sign'></span></button>
						<!-- </li> -->
					</div>
					<li class='divider'></li>
					<li class=''>
						<button type='button' class='btn btn-danger btn-lg' id='cancel'>Cancel</button>
						<button type='button' class='btn btn-primary btn-lg pull-right' id='done'>Done</button>
					</li>
				</ul>
			</div>
			<div id="" class="btn-group">
				<input type='submit' id='searchPickup' class='btn btn-success btn-lg' value='Search PickUp'>
			</div> <!-- </button>  -->
			<br/>	
			<div class='row'>
				<div class='col-lg-4' id='a'>
					<table id="search_results" class='table table-hover' border='1' >
						<!-- <tr id='cell' class='selectable'></tr> -->
					</table>
				</div>
			</div>
			<div id='rooms'>
				
			</div>
		</div>
	<!-- </form> -->
	
	<%--<%@ include file='show_rooms.jsp'%>--%>
</div>
<br />

