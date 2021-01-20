package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.Hotel;
import models.Room;
import com.google.gson.Gson;

public class CollectRoomsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		Hotel hotel = (Hotel)session.getAttribute("hotel");
		ArrayList<Room> rooms = null;

		String resp = "fail";

		if(hotel!=null){
			rooms = Room.collectHotelRooms(hotel.getHotelId());
			resp = new Gson().toJson(rooms);
		}
		response.getWriter().write(resp);	
	}
}

