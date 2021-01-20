<%@ page import='java.util.*,models.*,java.io.*'%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width initial-scale=1.0">
  <title>Pick Up any of your favourite place to keep your luggage safe.</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"> -->
  <!-- <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> -->
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.structure.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.theme.css'>
  <link rel='stylesheet' type='text/css' href='../css/index.css'>
  <link rel='stylesheet' type='text/css' href='../css/datatable.css'>
  <link rel='icon' href='../images/pickUPLogo.png'>
 </head>
 <body>
  <%
	ArrayList<City> cities = (ArrayList)application.getAttribute("cities");
	ArrayList<Room> rooms = (ArrayList)application.getAttribute("rooms");
	//System.out.println(rooms);
	/*for (Room room : rooms){
		System.out.println(room.getRoomId());
	}*/
  %>
  
	<%@ include file='logo.jsp'%>
	<%@ include file='loginForm.jsp'%>
	<%@ include file='signUpForm.jsp'%>
	<hr>
	<%@ include file='citiesList.jsp' %>
	<%@ include file='roomPick.jsp'%>
	<%--<%@ include file='roomImgGallery.jsp'%>--%>
 </body>

 
 <!-- <script src='../js/notify.js'></script> -->
 <script src='../js/jquery.js'></script>
 <script src='../jqueryui/jquery-ui.js'></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js">
 </script>
 <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js">
 </script> -->
 <script src='../js/index.js'></script>
 <script src='../js/roomPick.js'></script>
 <script src='../js/datatable.js'></script>
</html>
