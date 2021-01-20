package models;

import java.sql.Date;
import java.sql.*;

public class Hotel{
	private Integer hotelId;
	private String hotelName;
	private Address address;
	private Contact contact;
	private java.sql.Date foundationDate;
	private Status status;
	private String email;
	private String password;

	public Hotel(){
	
	}

	public Hotel(String email,String password){
		this.email = email;
		this.password = password;
	}

	public Hotel(Integer hotelId,String hotelName,Address address,Contact contact,java.sql.Date foundationDate,Status status,String email){
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.address = address;
		this.contact = contact;
		this.foundationDate = foundationDate;
		this.status = status;
		this.email = email;
	}

	public Hotel(Integer hotelId,String hotelName,Address address,Contact contact,java.sql.Date foundationDate,Status status,String email,String password){
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.address = address;
		this.contact = contact;
		this.foundationDate = foundationDate;
		this.status = status;
		this.email = email;
		this.password = password;
	}

	public Hotel(String hotelName,Address address,Contact contact,java.sql.Date foundationDate,Status status){
		this.hotelName = hotelName;
		this.address = address;
		this.contact = contact;
		this.foundationDate = foundationDate;
		this.status = status;
	}

	public Boolean loginHotel(){
		Boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");

			String q1 = "select hotel_id,hotel_name,a.address_id,a.plot_no,a.street1,a.street2,a.street3,";
			String q2 = " a.area,c.city_id,c.city,a.pincode,con.contact_id,con.contact1,con.contact2,con.contact3,";
			String q3 = " foundation_date,s.status_id,s.status from hotels as h inner join addresses as a";
			String q4 = " inner join contacts as con inner join cities as c inner join status as s";
			String q5 = " where h.address_id=a.address_id and a.city_id=c.city_id and";
			String q6 = " h.contact_id=con.contact_id and h.status_id=s.status_id ";
			String q7 = "and email=? and password=?";

			PreparedStatement ps = con.prepareStatement(q1+q2+q3+q4+q5+q6+q7);

			ps.setString(1,email);
			ps.setString(2,password);

			ResultSet rs = ps.executeQuery();			

			if(rs.next()){
				hotelId = rs.getInt(1);
				hotelName = rs.getString(2);
				address = new Address(rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),new City(rs.getInt(9),rs.getString(10)),rs.getInt(11));
				contact = new Contact(rs.getInt(12),rs.getString(13),rs.getString(14),rs.getString(15));
				foundationDate = rs.getDate(16);
				status = new Status(rs.getInt(17),rs.getString(18));

				flag = true;
			}

			con.close();

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}

		return flag;
	}


	public Integer signUpHotel(){
		Integer hotelId = 0;
		//Integer statusId = 0;

		Integer addressId = address.getAddress(); 
		Integer contactId = contact.getContact();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");
			
			String query = "insert into hotels (hotel_name,address_id,contact_id,foundation_date,status_id,email,password) value (?,?,?,?,1,?,?)";
 
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,hotelName);
			ps.setInt(2,addressId);
			ps.setInt(3,contactId);
			ps.setDate(4,foundationDate);
			ps.setString(5,email);
			ps.setString(6,password);
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();

			if(rs.next()){
				hotelId = rs.getInt(1);
			}
			con.close();

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return hotelId;
	}


	public void setHotelId(Integer hotelId){
		this.hotelId = hotelId;
	}
	public Integer getHotelId(){
		return hotelId;
	}

	public void setHotelName(String hotelName){
		this.hotelName = hotelName;
	}
	public String getHotelName(){
		return hotelName;
	}

	public void setAddress(Address address){
		this.address = address;
	}
	public Address getAddress(){
		return address;
	}

	public void setContact(Contact contact){
		this.contact = contact;
	}
	public Contact getContact(){
		return contact;
	}

	public void setFoundationDate(Date foundationDate){
		this.foundationDate = foundationDate;
	}
	public Date getFoundationDate(){
		return foundationDate;
	}

	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}

	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
}