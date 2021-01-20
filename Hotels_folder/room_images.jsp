<%@ page import="javax.servlet.http.HttpSession,java.util.ArrayList" %>

<% 
	ArrayList listimages = (ArrayList) request.getAttribute("roomImgName");
	//System.out.println(listimages+"((((((((()))))))))");
%>
<!-- <div class='container'> -->
	<% for(int i=0;i<listimages.size();i++) { %>	
		<div class='row' id='row1'>
		  <div class="card col s12 m4 l7" id='cardCol'>
			<div class="card-image waves-effect waves-block waves-light" id='cardImg'>
			   <img class="activator" src='<%= "../uploads/"+listimages.get(i) %>'>
			</div>
			<div class="card-content">
			  <span id='roomIdNo' class="card-title activator grey-text text-darken-4">
			    <i class="material-icons right">more_vert</i>
			  </span>
			  <p><a href="room_desc.do">more</a></p>
			</div>
			<div class="card-reveal">
			  <span class="card-title grey-text text-darken-4">Room description<i class="material-icons right">close</i></span>
			  <p id='roomDesc'></p>
			</div>			
		  </div>
		</div>
	<% } %>
<!-- </div> -->

<!-- this jsp page is directed by ShowHotelRoomsServlet -->