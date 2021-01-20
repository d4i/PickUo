<div id="" class="container">
  <div class='row'>
    <div class='col-xs-6 col-lg-12 col-md-6 col-sm-3' >
	  <br/>
	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Banglore
		<span class='caret'></span>
		</button>
	  </span>

	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Delhi
		<span class='caret'></span>
		</button>
	  </span>

	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Mumbai
		<span class='caret'></span>
		</button>
	  </span>

	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Kolkata
		<span class='caret'></span>
		</button>
	  </span>

	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Gurgaon
		<span class='caret'></span>
		</button>
	  </span>
	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Noida
		<span class='caret'></span>
		</button>
	  </span>

	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Chennai
		<span class='caret'></span>
		</button>
	  </span>

	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Hyderabad
		<span class='caret'></span>
		</button>
	  </span>

	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Jaipur
		<span class='caret'></span>
		</button>
	  </span>

	  <span class='dropdown'>
		&nbsp;<button class='btn btn-primary dropdown-toggle' aria-haspopup='true' aria-expanded='false' type='button' data-toggle='dropdown'>Luckhnow
		<span class='caret'></span>
		</button>
	  </span>

	  <span class='dropdown' id='allCities'>
		&nbsp;<button class="btn btn-primary dropdown-toggle" aria-haspopup="true" aria-expanded="false" type="button" data-toggle="dropdown">
		All Cities
		<span class='caret'></span>
		</button>
		<ul class="dropdown-menu scrollable-menu" role="menu" >
		  <% for(City city : cities){ %>
		  <li role='presentation'><a role='menuitem' href='<%= city.getCityId() %>'>
		  <%= city.getCity() %></a></li>
		  <% } %>
		</ul>
	  </span>
	</div>
  </div>
</div>