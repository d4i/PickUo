package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileUploadException;

import java.io.*;
import java.util.*;
import java.text.*;

/*import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Calendar;
import java.util.Random;*/

import java.nio.charset.Charset;

import models.Room;
import models.Hotel;

public class AddRoomServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		//ArrayList a = new ArrayList();

		Hotel hotel = (Hotel)session.getAttribute("hotel");
		Integer sroomNo=null;
		Integer sroomCapacity=null;
		String fileNameWithExt=null;
		InputStream roomImg=null;
		String result = "timeout";
		File file = null;
		
		if(ServletFileUpload.isMultipartContent(request)){
			
			DiskFileItemFactory dfif = new DiskFileItemFactory();

			ServletFileUpload sfu = new ServletFileUpload(dfif);

			try{
				List<FileItem> fileItems = sfu.parseRequest(request);

				Iterator<FileItem> itr = fileItems.iterator();
				
				String uploadRealPath = getServletContext().getRealPath("uploads");
				//System.out.println(uploadRealPath+" ###~~~~~~~~");
				while(itr.hasNext()){
					
					FileItem fileItem = itr.next();

					if(fileItem.isFormField()){
						if("roomNo".equals(fileItem.getFieldName())){
							sroomNo = Integer.parseInt(fileItem.getString());
						}
						if("roomCapacity".equals(fileItem.getFieldName())){
							sroomCapacity = Integer.parseInt(fileItem.getString());
						}
						//System.out.println(fileItem.getFieldName()+" : "+fileItem.getString());
					}else{
						fileNameWithExt = fileItem.getName();
						////////////////////////////////////////////
						Calendar calendar = Calendar.getInstance();
						Date date = calendar.getTime();

						String day = new SimpleDateFormat("dd").format(date);    // always 2 digits
						String month = new SimpleDateFormat("MM").format(date);  // always 2 digits
						String year = new SimpleDateFormat("yyyy").format(date); //always 4 digits
						
						String id = hotel.getHotelId()+"pickUp"+ day+month+year+System.currentTimeMillis();
						String[] fileNameSplits = fileNameWithExt.split("\\.");
						int extensionIndex = fileNameSplits.length - 1;

						String newFileName = id +"."+fileNameSplits[extensionIndex];
						////////////////////////////////////////////
						

						//System.out.println(newFileName+" ~~~~~~~~");

						file = new File(uploadRealPath,newFileName);
						roomImg = new ByteArrayInputStream(newFileName.getBytes(Charset.forName("UTF-8")));
						//roomImg = new FileInputStream(file);
						//System.out.println("AddRoomservlet: ~~File:"+file+"~~~~InputStream: "+roomImg);
						///////////////////////;
						//FileInputStream fis = new FileInputStream(file);
						
						fileItem.write(file);
					}				
				}
				
			}catch(FileUploadException e){
				e.printStackTrace();	
			}catch(Exception e){
				e.printStackTrace();	
			}  

		Room room = new Room();

		room.setRoomNo(sroomNo);
		room.setCapacity(sroomCapacity);
		room.setRoomImage(roomImg);

		request.setAttribute("file",file);
		request.setAttribute("room",room);
		//room.setRoomImage(file);

		//System.out.println(sroomNo);
		//System.out.println(sroomCapacity);
		
		/*if(hotel!=null){
			if(room.addRoom(hotel.getHotelId())){
				result = "success";
				//session.setAttribute("room",room);
				//request.setAttribute("roomImg",roomImg);
			}
		}else{
			result = "fail";
		}*/	
		//response.getWriter().write(result);
		request.getRequestDispatcher("save_.do").forward(request,response);
		}
	}
}