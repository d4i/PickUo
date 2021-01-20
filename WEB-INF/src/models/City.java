package models;

import java.sql.*;
import java.util.ArrayList;

public class City{
	private Integer cityId;
	private String city;
	private State state;

	public City(){
	
	}

	public City(Integer cityId){
		this.cityId = cityId;
	}

	public City(Integer cityId,String city){
		this.cityId = cityId;
		this.city = city;
	}

	public City(Integer cityId,String city,State state){
		this.cityId = cityId;
		this.city = city;
		this.state = state;
	}

	/*public static ArrayList<City>(){
		ArrayList<City> cities = new ArrayList<City>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");

			String q1 = "select city from cities where city ";

			PreparedStatement ps = con.prepareStatement(q1+q2);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				cities.add(new City(rs.getInt(1),rs.getString(2),new State(rs.getInt(3),rs.getString(4))));
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return cities;
	}*/

	public static ArrayList<City> collectCities(){
		ArrayList<City> cities = new ArrayList<City>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");

			String q1 = "select city_id,city,c.state_id,state from cities as c ";
			String q2 = "inner join states as s where c.state_id=s.state_id order by city";

			PreparedStatement ps = con.prepareStatement(q1+q2);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				cities.add(new City(rs.getInt(1),rs.getString(2),new State(rs.getInt(3),rs.getString(4))));
			}

			con.close();
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return cities;
	}

	public void setcityId(Integer cityId){
		this.cityId = cityId;
	}
	public Integer getCityId(){
		return cityId;
	}

	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}

	public void setState(State state){
		this.state = state;
	}
	public State getState(){
		return state;
	}
}