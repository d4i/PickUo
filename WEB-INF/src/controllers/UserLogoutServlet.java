package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

public class UserLogoutServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "index.jsp";

		User user = (User)session.getAttribute("user");

		if(user!=null){
			session.invalidate();
			request.getRequestDispatcher(nextPage).forward(request,response);
		}
	}
}