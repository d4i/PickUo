package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.*;
import java.io.*;

public class SaveImageToDatabaseServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Hotel hotel = (Hotel)session.getAttribute("hotel");
		Room room = (Room)request.getAttribute("room");
		String result = "timeout";
			
		//String path = getServletContext().getRealPath("uploads");
		
		File file = new File((File)request.getAttribute("file"),"");
		//FileInputStream fis=new FileInputStream(file);
		//System.out.println("ShowImageFromDatabaseServlet: "+file);
		
		if(hotel!=null){
			if(room.addRoom(hotel.getHotelId(),file)){
				result = "success";
				//session.setAttribute("room",room);
				//request.setAttribute("roomImg",roomImg);
			}
		}else{
			result = "fail";
		}
		request.getRequestDispatcher("hotel_services.jsp").forward(request,response);
	}
}