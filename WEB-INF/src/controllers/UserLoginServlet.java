package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import models.User;

public class UserLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "index.jsp";

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(email,password);

		if(user.loginUser()){
			nextPage = "afterSignUp.jsp";
			session.setAttribute("user",user);
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}