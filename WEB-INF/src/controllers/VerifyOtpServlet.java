package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

public class VerifyOtpServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		Integer otp = Integer.parseInt(request.getParameter("otp"));

		Integer otpValue = (Integer)request.getAttribute("otp");
		System.out.println(otp+"~~~"+otpValue);

		if(otpValue==otp){
			System.out.println("otp verified~~~");
			String msg = "same otp";
		}else{
			System.out.println("Otp not matched");
		}

	}
}