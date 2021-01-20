<%@ page import='java.util.ArrayList,models.*'%>
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
  <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"> -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.structure.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.theme.css'>
  <!-- <link rel='stylesheet' type='text/css' href='../css/youAreIn.css'> -->
  <link rel='stylesheet' type='text/css' href='../css/hotel_index.css'>
  <link rel='icon' href='../images/pickUPLogo.png'>
   </head>
 <body>
  <%@include file='header.jsp' %>
  
  <% Hotel hotel = (Hotel)session.getAttribute("hotelId");  %>


 </body>
 <script src='../js/jquery.js'></script>
 <script src='../jqueryui/jquery-ui.js'></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js">
 </script>  -->
 <script src='../js/youAreIn.js'></script>
 <!-- <script src='../js/becomePickup.js'></script> -->
</html>
