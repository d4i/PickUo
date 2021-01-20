package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import models.Hotel;

import java.util.ArrayList;

import models.Hotel;
import models.Room;
import com.google.gson.Gson;


public class HotelLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "index.jsp";

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Hotel hotel = new Hotel(email,password);

		Room room = new Room();
		ArrayList<Room> rooms = null;

		String resp = "fail";

		if(hotel.loginHotel()){
			
			session.setAttribute("hotel",hotel);
			
			rooms = Room.collectHotelRooms(hotel.getHotelId());
			resp = new Gson().toJson(rooms);
			session.setAttribute("room",room);
			session.setAttribute("aroom",rooms);

			nextPage = "hotel_services.jsp";
		}
		//response.getWriter().write(resp);
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}