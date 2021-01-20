<%@ page import='java.util.ArrayList,models.*'%>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>PickUp Asset Management-Partner with PickUp</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"> -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.structure.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.theme.css'>
  <link rel='stylesheet' type='text/css' href='../css/hotel_index.css'>
  <!-- <link rel='stylesheet' type='text/css' href='../css/index.css'>-->
  <link rel='icon' href='../images/pickUPLogo.png'>
   </head> 

 <body>
  
  <% 
	ArrayList<City> cities = (ArrayList)application.getAttribute("cities"); 
	ArrayList rooms = (ArrayList)application.getAttribute("rooms");
	//request.setAttribute("isLoginPage",true);
  %>


  <%@ include file='header.jsp' %>
  <%@ include file='becomePickup.jsp'%>
  <%@ include file='hotelLogin.jsp'%>
 </body>


 <script src='../js/jquery.js'></script>
 <script src='../jqueryui/jquery-ui.js'></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js">
 </script>  -->
 <script src='../js/becomePickup.js'></script>
 <script src='../js/index.js'></script>
 <script src='../js/roomPick.js'></script>
</html>
