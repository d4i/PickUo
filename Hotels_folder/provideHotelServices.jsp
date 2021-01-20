<div id="" class="container">
	<div class='row'>
		<div class='col-lg-12 col-offset-1'>
			<div id="" class="btn-group">			
				<button type='button' class='btn-info btn-lg' id='available_room'>Available Rooms</button>
				<button type='button' class='btn-info btn-lg' id='booked_room'>Booked Rooms</button>
				<button type='button' class='btn-info btn-lg' id='add_room'>Add Room</button>
				<button type='button' class='btn-info btn-lg' id='delete_room'>Delete Room</button>				
			</div>
		</div>
	</div>
</div>
<div class='container'>
  <div class='row' id='addRoom'>
	<div class='' id='addRoom'>
		<form id="sf" action='add_room.do' method='post' enctype="multipart/form-data">
			<div class="row">
				<div class="col s12">				  
					<div class="input-field inline">
						<input id="roomNo" type="number" class="validate" name='roomNo' />
						<label for="roomNo">Room no.</label>
						<span class="helper-text" data-error="wrong" data-success="right">Room number of your hotel*</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12">				  
					<div class="input-field inline">
						<label for="roomCapacity">Room capacity</label><br/><br/>
						<p class='range-field'>
						  <input type='range' id='roomCapacity' name='roomCapacity'/>
						  <span id='capacityNo'></span>
						</p>		
						<span class="helper-text" data-error="wrong" data-success="right">Maximum number of bags can be kept </span>
					</div>
				</div>
			</div>
			<!-- <div class='input-field'>
				<img src='../images/a1.jpg' id='showImg' value='' border="1px solid red"/>
				<input type='hidden' id='a' value=''>
			</div> -->
			<div class="row" id='addMoreImg'>
				<div class="col s12">		  
					<label>Add Room Images</label>
					<div class="file-field input-field">
						<div class = "btn">
							<span>Image 1</span>
							<input type="file" name='roomImg' id='uploadImage'/>
						</div>
						<div class="file-path-wrapper">
							<input class="file-path validate" type = "text" placeholder="Add image" />
						</div>						
					</div>
				</div>
			</div>	
			
			<button class="btn waves-effect waves-light" type="submit" name="action">Add Room
				<i class="material-icons right">send</i>
			</button>
		</form>
	</div>
  </div>
	<div class='row' id='bookedRoom'>
		details date time etc.
	</div>
	
	<div id="available_room_div" class="">	
		<div class='' id='appendAll' ></div>
	</div>

	<div class='' id='deleteRoom'>
	  <div id='delete_room_div'>
		<div id='delbtn'><!-- <a href='#'>delete</a> --></div>
	  </div>
</div>
</div>


