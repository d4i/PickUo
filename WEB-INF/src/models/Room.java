package models;

import java.sql.*;
//import java.io.File;
//import java.io.InputStream;
import java.util.*;
import java.io.*; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

//import java.nio.file.*;

public class Room{
	private Integer roomId;
	private Integer roomNo;
	private Integer capacity;
	private Hotel hotel;
	private InputStream roomImg;
	private Status status;

	public Room(){
	
	}

	public Room(Integer roomId,Integer roomNo,Integer capacity,InputStream roomImg){
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.capacity = capacity;
		this.roomImg = roomImg;
	}

	public Room(Integer roomId,Integer roomNo,Integer capacity,Hotel hotel,InputStream roomImg){
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.capacity = capacity;
		this.hotel = hotel;
		this.roomImg = roomImg;
	}

	public Room(Integer roomId,Integer roomNo,Integer capacity,InputStream roomImg,Hotel hotel){
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.capacity = capacity;
		this.roomImg = roomImg;
		this.hotel = hotel;
	}

	public Room(Integer roomId,Integer roomNo,Integer capacity,Hotel hotel,InputStream roomImg,Status status){
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.capacity = capacity;
		this.hotel = hotel;
		this.roomImg = roomImg;
		this.status = status;
	}

	public byte[] retrieveImage(Integer roomId) {		
		
		byte[] buf = new byte[1024*1024];
		byte[] bytes = null;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");
			
			Blob blob;
			PreparedStatement ps=con.prepareStatement("select room_img from rooms where room_id="+roomId); 
			ResultSet rs=ps.executeQuery();
			System.out.println(roomId);
			while(rs.next()){
				//room = new Room();
				blob=rs.getBlob("room_img");
				bytes=blob.getBytes(1,(int)blob.length());
			}

			ps.close();
			//fos.close();

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return bytes;
	}

	public ArrayList<Room> showRoom(String cityHotelName,java.sql.Date date,Integer capacity){
		ArrayList<Room> listRoom = new ArrayList<Room>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");
			
			Integer i = capacity+10;

			String q1 = "select room_id,room_no,capacity,r.hotel_id,hotel_name";
			String q2 = ",h.address_id,plot_no,street1,street2,street3,area,a.city_id,city,";
			String q3 = "c.state_id,s.state,s.country_id,country,pincode,";
			String q4 = "h.contact_id,contact1,contact2,contact3,";
			String q5 = "foundation_date,h.status_id,status,h.email,r.room_img,r.status_id,status from ";
			String q6 = "rooms as r inner join hotels as h inner join addresses as a ";
			String q7 = "inner join cities as c inner join states as s inner join countries as ctrs ";
			String q8 = "inner join contacts as con inner join status as st ";
			String q9 = " where r.hotel_id=h.hotel_id and h.address_id=a.address_id";
			String q10 = " and a.city_id=c.city_id and c.state_id=s.state_id and r.status_id=st.status_id ";
			String q11 = "and s.country_id=ctrs.country_id and h.contact_id=con.contact_id and";
			String q12 = " (c.city='"+cityHotelName+"' or h.hotel_name='"+cityHotelName+"')";
			String q13 = " and capacity between 0 and "+i;

			PreparedStatement ps = con.prepareStatement(q1+q2+q3+q4+q5+q6+q7+q8+q9+q10+q11+q12+q13);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				listRoom.add(new Room(rs.getInt(1),rs.getInt(2),rs.getInt(3),new Hotel(rs.getInt(4),rs.getString(5),new Address(rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),new City(rs.getInt(12),rs.getString(13),new State(rs.getInt(14),rs.getString(15),new Country(rs.getInt(16),rs.getString(17)))),rs.getInt(18)),new Contact(rs.getInt(19),rs.getString(20),rs.getString(21),rs.getString(22)),rs.getDate(23),new Status(rs.getInt(24),rs.getString(25)),rs.getString(26)),rs.getBinaryStream(27),new Status(rs.getInt(28),rs.getString(29))));
			}
			System.out.println(listRoom+"Modelsss ka listRoom");
			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return listRoom;
	}

	public static ArrayList<Room> collectAllRooms(){
		ArrayList<Room> rooms = new ArrayList<Room>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234"); 

			String q1 = "select room_id,room_no,capacity,r.hotel_id,hotel_name";
			String q2 = ",h.address_id,plot_no,street1,street2,street3,area,a.city_id,city,";
			String q3 = "c.state_id,s.state,s.country_id,country,pincode,";
			String q4 = "h.contact_id,contact1,contact2,contact3,";
			String q5 = "foundation_date,h.status_id,status,h.email,r.room_img from ";
			String q6 = "rooms as r inner join hotels as h inner join addresses as a ";
			String q7 = "inner join cities as c inner join states as s inner join countries as ctrs ";
			String q8 = "inner join contacts as con inner join status as st ";
			String q9 = "where r.hotel_id=h.hotel_id and h.address_id=a.address_id ";
			String q10 = "and a.city_id=c.city_id and c.state_id=s.state_id ";
			String q11 = "and s.country_id=ctrs.country_id and h.contact_id=con.contact_id and";
			String q12 = " h.status_id=st.status_id";

			PreparedStatement ps = con.prepareStatement(q1+q2+q3+q4+q5+q6+q7+q8+q9+q10+q11+q12);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				rooms.add(new Room(rs.getInt(1),rs.getInt(2),rs.getInt(3),new Hotel(rs.getInt(4),rs.getString(5),new Address(rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),new City(rs.getInt(12),rs.getString(13),new State(rs.getInt(14),rs.getString(15),new Country(rs.getInt(16),rs.getString(17)))),rs.getInt(18)),new Contact(rs.getInt(19),rs.getString(20),rs.getString(21),rs.getString(22)),rs.getDate(23),new Status(rs.getInt(24),rs.getString(25)),rs.getString(26)),rs.getBinaryStream(27)));
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return rooms;
	}

	public ArrayList showRoomImg(Integer hotelId) {
		ArrayList imageUrlList = new ArrayList();
		File imageDir = new File("C://Tomcat 9.0/webapps/pickUp/uploads");
		
		//File currentDir = new File(System.getProperty("user.dir"));
		//Path p = Paths.get(currentDir.getAbsolutePath()).getParent().getParent().getParent().getParent();

		//File imageDir = new File(p.toFile(),"uploads");
		
		for(File imageFile : imageDir.listFiles()){				
			String imageFileName = imageFile.getName(); 
			//imageUrlList.add(imageFileName);
			if(imageFileName.startsWith(hotelId.toString())){
				imageUrlList.add(imageFileName);				
			}
		}
		
		return imageUrlList;
	}

	public static ArrayList collectHotelRooms(Integer hotelId){
		ArrayList<Room> rooms = new ArrayList<Room>();
		try{		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");

			String q1 = "select room_id,room_no,capacity,r.hotel_id,hotel_name";
			String q2 = ",h.address_id,plot_no,street1,street2,street3,area,a.city_id,city,";
			String q3 = "c.state_id,s.state,s.country_id,country,pincode,";
			String q4 = "h.contact_id,contact1,contact2,contact3,";
			String q5 = "foundation_date,h.status_id,status,h.email,r.room_img from ";
			String q6 = "rooms as r inner join hotels as h inner join addresses as a ";
			String q7 = "inner join cities as c inner join states as s inner join countries as ctrs ";
			String q8 = "inner join contacts as con inner join status as st ";
			String q9 = "where r.hotel_id=? and h.address_id=a.address_id ";
			String q10 = "and a.city_id=c.city_id and c.state_id=s.state_id ";
			String q11 = "and s.country_id=ctrs.country_id and h.contact_id=con.contact_id and";
			String q12 = " h.status_id=st.status_id";
			
			PreparedStatement ps = con.prepareStatement(q1+q2+q3+q4+q5+q6+q7+q8+q9+q10+q11+q12);

			ps.setInt(1,hotelId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				rooms.add(new Room(rs.getInt(1),rs.getInt(2),rs.getInt(3),new Hotel(rs.getInt(4),rs.getString(5),new Address(rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),new City(rs.getInt(12),rs.getString(13),new State(rs.getInt(14),rs.getString(15),new Country(rs.getInt(16),rs.getString(17)))),rs.getInt(18)),new Contact(rs.getInt(19),rs.getString(20),rs.getString(21),rs.getString(22)),rs.getDate(23),new Status(rs.getInt(24),rs.getString(25)),rs.getString(26)),rs.getBinaryStream(27)));
			}
			con.close();

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}

		return rooms;
	}

	public boolean addRoom(Integer hotelId,File file){
		boolean flag = false;
			
		try{
			//File file = new File(roomImg);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");

			String query = "insert into rooms (room_no,capacity,room_img,hotel_id) value (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			InputStream fis=new FileInputStream(file);
			//inputStream.file.length()
			//byte[] b = IOUtils.toByteArray(fis);

			ps.setInt(1,roomNo);
			ps.setInt(2,capacity);
			ps.setBinaryStream(3,fis,(int)file.length());
			ps.setInt(4,hotelId);

			Integer i = ps.executeUpdate();
			if(i!=0){
				flag = true;
			}

			con.close();
		}catch(SQLException|ClassNotFoundException|IOException e){
			e.printStackTrace();
		}

		return flag;
	}

	public void setRoomId(Integer roomId){
		this.roomId = roomId;
	}
	public Integer getRoomId(){
		return roomId;
	}

	public void setRoomNo(Integer roomNo){
		this.roomNo = roomNo;
	}
	public Integer getRoomNo(){
		return roomNo; 
	}

	public void setCapacity(Integer capacity){
		this.capacity = capacity;
	}
	public Integer getCapacity(){
		return capacity;
	}

	public void setHotel(Hotel hotel){
		this.hotel = hotel;
	}
	public Hotel getHotel(){
		return hotel;
	}

	public void setRoomImage(InputStream roomImg){
		this.roomImg = roomImg;
	}
	public InputStream getRoomImage(){
		return roomImg;
	}

	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}
}