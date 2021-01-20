package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Date;

import models.Contact;
import models.Address;
import models.Hotel;
import models.City;


public class HotelSignUpServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextPage = "index.jsp";

		//System.out.println(foundationDate);
		
		String name = request.getParameter("hotel_name");
		String contact1 = request.getParameter("contact1");
		String contact2 = request.getParameter("contact2");
		String contact3 = request.getParameter("contact3");
		String propertyType = request.getParameter("property");
		String foundationDate = request.getParameter("foundedOn");
		Integer plotNo = Integer.parseInt(request.getParameter("plot_no"));
		String street1 = request.getParameter("street1");
		String street2 = request.getParameter("street2");
		String street3 = request.getParameter("street3");
		String area = request.getParameter("area");
		Integer cityId = Integer.parseInt(request.getParameter("city"));
		Integer pincode = Integer.parseInt(request.getParameter("pincode"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

		Hotel hotel = new Hotel();
		Address address = new Address(plotNo,street1,street2,street3,area,new City(cityId),pincode);
		Contact contact = new Contact(contact1,contact2,contact3);

		System.out.println(foundationDate);

		hotel.setHotelName(name);
		hotel.setFoundationDate(java.sql.Date.valueOf(foundationDate.toString()));
		hotel.setContact(contact);
		hotel.setAddress(address);
		hotel.setEmail(email);
		hotel.setPassword(password);

		Integer hotelId = hotel.signUpHotel();
		//Integer otpValue = (Integer)session.getAttribute("otp");
		
		if(hotelId!=0){
			nextPage = "hotel_services.jsp";
			//session.setAttribute("hotel",hotel);
			/*request.setAttribute("isAdmin",isAdmin);
			request.setAttribute("isLoginPage",isLoginPage);
			request.setAttribute("isRegisterPage",isRegisterPage);
			request.setAttribute("isLogoutPage",isLogoutPage);*/
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}