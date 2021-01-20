package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.*;
import java.util.*;
import models.*;

public class ShowHotelRoomServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String btnId = request.getParameter("btnId");
		
		//System.out.println(btnId);
		
		Hotel hotel = (Hotel)session.getAttribute("hotel");
		Room room = new Room();
		//System.out.println(hotel.getHotelId());
		if(hotel!=null){
			ArrayList roomImgName = room.showRoomImg(hotel.getHotelId());
			//System.out.println(roomImgName);
			request.setAttribute("roomImgName",roomImgName);		
		}
		if(btnId.equals("available_room")){
			//System.out.println(btnId);
			request.getRequestDispatcher("room_images.jsp").forward(request,response);
		}else if(btnId.equals("delete_room")){
			//System.out.println(btnId);
			request.getRequestDispatcher("delete_room.jsp").forward(request,response);
		}
	}
}