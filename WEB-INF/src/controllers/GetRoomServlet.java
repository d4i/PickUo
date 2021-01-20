package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import models.*;

public class GetRoomServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String resp = "fail";
		
		ArrayList cities = (ArrayList)session.getServletContext().getAttribute("cities");
		ArrayList states = (ArrayList)session.getServletContext().getAttribute("states");
		ArrayList rooms = (ArrayList)session.getServletContext().getAttribute("rooms");
		
		ArrayList arr = new ArrayList();
		arr.add(cities);
		arr.add(states);
		arr.add(rooms);

		//System.out.println(cities+"\n~~~~~~~~~~~~~~~~"+states+"\n@@@@@@@@@@@@@@@@@@@@@@@@@@~~"+rooms);
		//System.out.println(arr);
		response.getWriter().write(new Gson().toJson(arr));
	}
}