<div class='container'>
	<div class='row'>
		<div class='col-lg-4 col-lg-offset-9' id='scrollable' style='display:none'>
		<caption>Double your business ,<br/>simply by getting in touch</caption><br /><br/>
			<form action='signup.do' id='becomePickup' method='post'>
				<div class='form-group'>
					<label for='hotel_name'>Hotel Name*</label>
					<input class='form-control' type='text' id='hotel_name' placeholder='Enter hotel name' name='hotel_name' required>
				</div>

				<div class='form-group'>
					<label for='foundedOn'>Foundation Date</label>
					<input type='date' class='btn btn-default btn-lg form-control' id='foundedOn' value='Select date' name='foundedOn'>
				</div>
				
				<div class='form-group'>
					<label for='contact'>Contact*</label>
					<input type='tel' id='contact1' name='contact1' class='form-control' required>
				</div>

				<div class='form-group'>
					<label for='contact'>Recovery Contact 1</label>
					<input class='form-control' type='tel' id='contact2' name='contact2'>
				</div>

				<div class='form-group'>
					<label for='contact'>Recovery Contact 2</label>
					<input class='form-control' type='tel' id='contact3' name='contact3'>
				</div>

				<div class='form-group'>
					<label>Address</label><br />
					Plot no.-<input class='form-control' type='number' name='plot_no' placeholder='Plot number'>
					Street 1-<input class='form-control' type='text' name='street1' placeholder='Street 1'>
					Street 2-<input class='form-control' type='text' name='street2' placeholder='Street 2'>
					Street 3-<input class='form-control' type='text' name='street3' placeholder='Street 3'>
					Area-<input type='text' class='form-control' name='area' placeholder='area name'>
					<div class=''>
						<!-- <label for='city'>City</label> -->
						City-<select class='form-control' id='city' name='city'>
							<option value='0'>Select</option>
							<% for (City city:cities){%>
								<option value='<%= city.getCityId()%>'>
									<%= city.getCity() %>
								</option>
							<%}%>
						</select>
					</div>

					<div class='form-group'>
						<!-- <label for='pincode'>Pincode</label> -->
						Pincode-<input type='text' class='form-control' id='pincode' name='pincode'>
					</div>
				</div>
				<div class='form-group'>										
					<label for='email'>Email*</label>
					<input class='form-control' type='email' id='email' name='email' required><br/>			
					<button type='button' id='sendotp' class='btn btn-warning pull-left' onclick='sendOTP()'/>Send OTP</button>&nbsp;<br/><br/>
				</div>
				<div id="" class="form-group">
					<!-- <form action='otpprocess.do' method='post'> -->
						<label for="otp">Enter Otp:</label>
						<input class='form-control' type='number' id='otp' name='otp'/><br/>
						<a id='verifyotp' class='btn btn-info'>Verify OTP</a>
					<!-- </form> --><br/>
				</div>

				<div class='form-group'>
					<label for='password'>Set Password*</label>
					<input class='form-control' type='password' id='password' name='password' required>
				</div>
				
				<div class='form-group'>
					<label for='password'>Retype Password*</label>
					<input class='form-control' type='password' id='password1' name='password1' required>
				</div>
				<div class="form-group">
					<button type='submit' class='btn btn-primary pull-left'>SignUp</button>&nbsp;
					<button type='reset' id='resetbtn' value='Reset' class='btn btn-primary'>Reset</button>
				</div>
			</form>

			<!--<form class='form' id='becomePickup' action='youAreIn.do' method='POST'>
				<caption>Double your business ,<br/>simply by getting in touch</caption><br />
				 <div class='input-field inline'>
					<input id='name' type='text' class='validate' name='hotel_name'>
					<label for='name'>Hotel Name</label>
					<span class='helper-text' data-error='wrong' data-success='right'></span>
				</div>
				<div class='input-field inline'>
					<input type='tel' class='validate' id='contact1' name='contact1'>
					<label for='number'>Contact</label>
					<span class='helper-text' data-error='wrong' data-success='right'></span>
				</div>
				<div class='input-field inline'>
					<input type="text" class="datepicker" id='foundedOn' name='foundedOn'>
					<label>Foundation Date</label>
				</div>
				<div class='input-field'>
					Property type:<br /><br/>
					<p>
					  <label>
						<input class="with-gap" name="property" type="radio" value='commercialSpace' />
						<span>
							 <i class="medium material-icons" id=''>business</i>
							 Commercial space
						</span>
					  </label>
					</p>
				
					<p>
					  <label>
						<input class="with-gap" name="property" type="radio" value='home' />
						<span>
							 <i class="medium material-icons" id=''>home</i>
							 Home
						</span>
					  </label>
					</p>
				
					<p>
					  <label>
						<input class="with-gap" name="property" type="radio" value='hotel' />
						<span>
							 <i class="medium material-icons" id=''>hotel</i>
							 Hotel
						</span>
					  </label>
					</p>
				</div>
				<label>Address:-</label><br/>
				<div class='input-field inline'>
				<input type='number' id='plot' name='plot_no' class='validate'>
				<label for='plot'>Plot</label>
							</div>
							<div class='input-field inline'>
				<input type='text' id='street1' name='street1' class='validate'>
				<label for='street1'>Street 1</label>
							</div>
							<div class='input-field inline'>
				<input type='text' id='street2' name='street2' class='validate'>
				<label for='street2'>Street 2</label>
							</div>
							<div class='input-field inline'>
				<input type='text' id='street3' name='street3' class='validate'>
				<label for='street3'>Street 3</label>
							</div>
							<div class='input-field inline'>
				<input type='text' id='area' name='area' class='validate'>
				<label for='area'>Area</label>
							</div>
							<div class="input-field">
					<select name='city' class='' id='city'>
						<option value="0" disabled selected>Choose your city</option>
						<% for (City city:cities){%>
							<option value='<%= city.getCityId()%>'>
								<%= city.getCity() %>
							</option>
						<%}%>
					</select>
				<label>City</label>
				</div>
							<div class='input-field inline'>
				<input type='text' id='pincode' name='pincode' class='validate'>
				<label for='pincode'>Pincode</label>
							</div><br />
							<button class='btn-success btn-lg' type='submit'><i class="material-icons" id='firstForm'>arrow_forward</i></button>			 
			</form>-->
		</div>
	</div>
</div>