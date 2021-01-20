package models;

import java.sql.Date;

public class Employee{
	private Integer employeeId;
	private String employeeName;
	private String fatherName;
	private Date dob;
	private String gender;
	private Contact contact;
	private Address address;
	private Integer workExperience;
	private String email;
	private String password;
	private Designation designation;
	private Hotel hotel;
	private RailwayStation railwayStation;

	public void setEmployeeId(Integer employeeId){
		this.employeeId = employeeId;
	}
	public Integer getEmployeeId(){
		return employeeId;
	}

	public void setEmployeeName(String employeeName){
		this.employeeName = employeeName;
	}
	public String getEmployeeName(){
		return employeeName;
	}

	public void setFatherName(String fatherName){
		this.fatherName = fatherName;
	}
	public String getFatherName(){
		return fatherName;
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

	public void setContact(Contact contact){
		this.contact = contact;
	}
	public Contact getContact(){
		return contact;
	}

	public void setAddress(Address address){
		this.address = address;
	}
	public Address getAddress(){
		return address;
	}

	public void setWorkExperience(Integer workExperience){
		this.workExperience = workExperience;
	}
	public Integer getWorkExperience(){
		return workExperience;
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

	public void setDesignationId(Designation designation){
		this.designation = designation;
	}
	public Designation getDesignation(){
		return designation;
	}

	public void setHotel(Hotel hotel){
		this.hotel = hotel;
	}
	public Hotel getHotel(){
		return hotel;
	}

	public void setStation(Station station){
		this.station = station;
	}
	public Station getStation(){
		return station;
	}
}