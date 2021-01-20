package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.*;
import models.*;

public class RetrieveImageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		//System.out.println("deepti");
		
		ArrayList<Room> list = (ArrayList)request.getAttribute("roomlist");
		Room room = (Room)request.getAttribute("room");
		byte[] bytes = null;
		
		//System.out.println(list+"Deepti~");	//models obj
		
		for(Room r : list){
			System.out.println(r.getRoomId()+" :: Room Id@@@@###############");
			bytes = room.retrieveImage(r.getRoomId());
		

			if (bytes != null && bytes.length > 0) {
				response.setContentType("image/jpg");
				response.getOutputStream().write(bytes);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		}
		//System.out.println(img+"  ~~~Yeeaaa this is image!!!");
		//System.out.println(bytes+"&&&&&&&&&&&&&&&&&&&&&");
		//System.out.println("deepti request bhej di hai betaa");
		//request.setAttribute("img",img);
		request.getRequestDispatcher("show_rooms.jsp").forward(request,response);
	}
}