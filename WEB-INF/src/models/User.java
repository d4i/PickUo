package models;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User{
	private Integer userId;
	private String userName;
	private Date dob;
	private String gender;
	private Contact contact;
	private Address address;
	private String email;
	private String password;

	public User(){
	
	}

	public User(String email,String password){
		this.email = email;
		this.password = password;
	}

	public Boolean loginUser(){
		Boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");

			String query = "select user_id,user_name,dob,gender,contact_id,address_id from users where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,email);
			ps.setString(2,password);

			ResultSet rs = ps.executeQuery();			

			if(rs.next()){
				userId = rs.getInt(1);
				userName = rs.getString(2);
				dob = rs.getDate(3);
				gender = rs.getString(4);
				contact = new Contact(rs.getInt(5));
				address = new Address(rs.getInt(6));

				flag = true;
			}

			con.close();

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}

		return flag;
	}

	public Boolean signUpUser(){
		Boolean flag = false;

		Integer addressId = address.getAddress(); 
		Integer contactId = contact.getContact();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");
			
			String query = "insert into users (user_name,contact_id,email,password,dob,gender,address_id) value (?,?,?,?,?,?,?)";
 
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,userName);
			ps.setInt(2,contactId);
			ps.setString(3,email);
			ps.setString(4,password);
			ps.setDate(5,dob);
			ps.setString(6,gender);
			ps.setInt(7,addressId);

			/*
				if(dob!=null){
					ps.setDate(5,dob);
				}

				if(gender!=null){
					ps.setString(6,gender);
				}

				if(addressId!=null){
					
				}*/

			Integer i = ps.executeUpdate();

			if(i==1){
				flag = true;
			}
			con.close();

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return flag;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getUserId(){
		return userId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName(){
		return userName;
	}

	public void setDob(Date dob){
		this.dob = dob;
	}
	public Date getDob(){
		return dob;
	}

	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return gender;
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