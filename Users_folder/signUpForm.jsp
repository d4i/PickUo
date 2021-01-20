<div class='container'>
    <div class='row'>
		<button class='btn btn-default btn-lg pull-right' data-toggle='modal' data-target='#myModal' id='menubtn'>
			<span class='glyphicon glyphicon-menu-hamburger'></span>
		</button>
		<div id="myModal" data-keyboard='false' data-backdrop='static' class="modal fade right" tabindex='-1' aria-labelledby='myModalLabel2'>
			<div class='modal-dialog modal-sm' role='document'>
				<div class='modal-content'>
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label='close'><span aria-hidden='true'>&times;</span></button>
						<h4 class='model-title'>New User?</h4>
						<button class='btn btn-success' data-toggle='modal' data-target='#signupModal'>Sign Up</button><br />
						<h5>Or already have an account?<button class='btn btn-link'id='userloginbtn' data-dismiss="modal">Login</button></h5>
					</div>
					<div class="modal-body">			
						<h4><a href='#'><span class='glyphicon glyphicon-home'></span> Home</a></h4>
						<h4><a href='HowToRigisterYourHotel.html' data-toggle="tooltip" title='Wanna register your own hotel? Click here to see the steps.'>
						<span class='glyphicon glyphicon-earphone'></span> +91 6260527632
						</a></h4>
						<h4><a href='#'><span class='glyphicon glyphicon-education'></span> 24x7 Support</a></h4>
						<h4><a href='#'><span class='glyphicon glyphicon-user'></span> About</a></h4>
					</div>					
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>			  
	</div>
</div>
<br />
<div id="" class="container">
		
	<div data-keyboard='false' data-backdrop='static' id="signupModal" class="modal fade" role="dialog">
	  <div class="modal-dialog modal-sm">

		<!-- Modal content-->
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			<h2 class="modal-title">Sign Up</h2>
		  </div>
		  <div class="modal-body">
			<form action='user_signup.do' id='signup_form' method='post'>
				<div class='form-group'>
					<label for='userName'>Name*</label>
					<input class='form-control' type='text' id='userName' placeholder='User name here' name='user_name' required>
				</div>

				<div class='form-group'>
					<label for='dob'>Date of birth</label>
					<input type='date' class='btn btn-default btn-lg form-control' id='dob' value='Select date' name='dob'>
				</div>

				<div class='form-group'>
					<label for='gender'>Gender</label>
					<label class="custom-control custom-radio">
						<input id="male" name="gender" type="radio" class="form-check-input " value='male'>
						<span class="custom-control-indicator"></span>
						<span class="custom-control-description">Male</span>
					</label>
					<label class="custom-control custom-radio">
						<input id="female" name="gender" type="radio" class="form-check-input" value='female'>
						<span class="custom-control-indicator"></span>
						<span class="custom-control-description">Female</span>
					</label>
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
					<input class='form-control' type='email' id='email' name='email' required>
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
					<button type='reset' id='resetbtn' value='Reset' class='btn btn-primary '>Reset</button>
				</div>
			</form>
		  </div>
		  <div class="modal-footer">
			<div id="" class="form-group">				
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		  </div>
		</div>

	  </div>
	</div>
</div>