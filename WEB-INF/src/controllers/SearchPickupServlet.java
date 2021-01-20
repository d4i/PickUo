package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Date;

import models.*;

public class SearchPickupServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		java.sql.Date sqlDate = null;

		String cityHotelname = request.getParameter("cityHotelname");
		String date = request.getParameter("date_");
		//String c = request.getParameter("capacity");
		Integer capacity = Integer.parseInt(request.getParameter("capacity"));

		System.out.println("Name:- "+cityHotelname);
		System.out.println("Date:- "+date);
		System.out.println("Capacity:- "+capacity+"@@~");

		///validation~~

		//System.out.println(c+"*****");

		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			java.util.Date udate = sdf.parse(date);
			
			sqlDate = new Date(udate.getTime());
			//System.out.println("New Date Sql: "+sqlDate);
		}catch(ParseException e){
			e.printStackTrace();
		}

		//System.out.println("java.sql.Date: "+sqlDate);

		Room room = new Room();
		//System.out.println(cityHotelname+"~~~~~"+sqlDate+"~~~~~"+capacity);
		ArrayList<Room> roomlist = room.showRoom(cityHotelname,sqlDate,capacity);
		//room.getImage();
		
		//System.out.println(roomlist+"yo roomList");
		request.setAttribute("roomlist",roomlist);
		request.setAttribute("room",room);
		
		//response.getWriter().write("sandeep");
		//System.out.println("sandeep");
		request.getRequestDispatcher("retrieve_img.do").forward(request,response);
	}
}