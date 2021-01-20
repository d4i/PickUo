<%@ page import='models.*'%>
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
  <title>Profile page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.structure.css'>
  <link rel='stylesheet' type='text/css' href='../jqueryui/jquery-ui.theme.css'>
  <link rel='stylesheet' type='text/css' href='../css/index.css'>
  <link rel='icon' href='../images/pickUPLogo.png'>
 </head>
 <body>
  <% 
	User user = (User)session.getAttribute("user");
	//String showName = user.getUserName(); 
  %>
  <%@ include file='logo.jsp'%>
  <%@ include file='profilePagee.jsp'%>
  <%@ include file='profileNavbar.jsp'%>

 </body>

 <script src='../js/jquery.js'></script>
 <script src='../jqueryui/jquery-ui.js'></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js">
 </script>
 <script src='../js/index.js'></script>
</html>
