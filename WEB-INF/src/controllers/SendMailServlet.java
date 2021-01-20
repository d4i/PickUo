package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import utils.EmailSender;
import java.util.Random;

import models.Hotel;

public class SendMailServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		Hotel h = new Hotel();
		
		String toEmail = request.getParameter("email");
		//String hotelName = request.getParameter("hotel_name");
		//System.out.println(toEmail);
		int length = 6;

		String x="";

		String nums = "0123456789";

		char[] otp = new char[length];
		
		for(int i=0;i<length;i++){
			otp[i] = nums.charAt(new Random().nextInt(nums.length()));
			x=x+otp[i];
		}

		String msg = "<div style='font-size:25px,font-weight:bold,font-family:verdana'>Hello "+	
			
					request.getParameter("email")+",</div>"+
			
					"Thanks for registering for an account on<strong> PickUp!</strong>Before we get started, we just need to confirm that this is you.<br/>Your OTP is: "+x;

		EmailSender.sendEmail(toEmail,msg);

		request.setAttribute("otp",x);

		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}