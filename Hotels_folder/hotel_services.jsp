<%@ page import='java.util.ArrayList,models.*,java.io.*'%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Validate your Property</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.structure.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.theme.css'>
  <!-- <link rel='stylesheet' type='text/css' href='../css/youAreIn.css'> -->
  <link rel='stylesheet' type='text/css' href='../css/hotel_index.css'>
  <link rel='stylesheet' type='text/css' href='../css/hotel_services.css'>
  <link rel='icon' href='../images/pickUPLogo.png'>
   </head>
 <body>
  <%@include file='header.jsp' %>
   
  <%
	Hotel hotel = (Hotel)session.getAttribute("hotel");
	Room room = (Room)session.getAttribute("room");
	ArrayList<Room> collectRoom = (ArrayList<Room>)session.getAttribute("aroom");
  %>

  <%@include file ="provideHotelServices.jsp" %>
  <%--<%@include file ="available_rooms.jsp" %>--%><!--this jsp will initiate collect_rooms.do -->
  <%--<%@include file = "delete_room.jsp" %>--%>
  
 <!-- <div class='row'> -->
 <%--<%
  System.out.println(collectRoom);
  System.out.println(collectRoom.get(0));
  System.out.println(collectRoom.get(0).getRoomNo());
  System.out.println(collectRoom.get(0).getRoomImage());
  //room.showRoomImg();
 %>--%>
 <%-- <%= room.showRoomImg() %> --%>
 
 <!-- </div> -->

 </body>
 <script src='../js/jquery.js'></script>
 <script src='../jqueryui/jquery-ui.js'></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js">
 </script>
 <script src='../js/hotel_services.js'></script>
 <script src='../js/available_room.js'></script>
 <script src='../js/delete_room.js'></script>
</html>
