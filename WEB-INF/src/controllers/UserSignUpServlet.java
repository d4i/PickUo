package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Date;

import models.User;
import models.Address;
import models.Contact;
import models.City;

public class UserSignUpServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();	

		String nextPage = "index.jsp";

		//System.out.println(dob);
		
		String name = request.getParameter("user_name");
		String dob = request.getParameter("dob");
		//Date dob = Date.valueOf(request.getParameter("dob"));
		String gender = request.getParameter("gender");
		String contact1 = request.getParameter("contact1");
		String contact2 = request.getParameter("contact2");
		String contact3 = request.getParameter("contact3");
		Integer plotNo = Integer.parseInt(request.getParameter("plot_no"));
		String street1 = request.getParameter("street1");
		String street2 = request.getParameter("street2");
		String street3 = request.getParameter("street3");
		String area = request.getParameter("area");
		Integer cityId = Integer.parseInt(request.getParameter("city"));
		Integer pincode = Integer.parseInt(request.getParameter("pincode"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println(dob+"!!!~~~~~~~~~");

		User user = new User();
		Address address = new Address(plotNo,street1,street2,street3,area,new City(cityId),pincode);
		Contact contact = new Contact(contact1,contact2,contact3);

		user.setUserName(name);
		user.setDob(java.sql.Date.valueOf(dob.toString()));
		user.setGender(gender);
		user.setContact(contact);
		user.setAddress(address);		
		user.setEmail(email);
		user.setPassword(password);

		

		//User user1 = new User(email,password);

		if(user.signUpUser()){
			nextPage = "afterSignUp.jsp";
			session.setAttribute("user",user);
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}