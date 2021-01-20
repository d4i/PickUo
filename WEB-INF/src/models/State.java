package models;

import java.sql.*;
import java.util.ArrayList;

public class State{
	private Integer stateId;
	private String state;
	private Country country;

	public State(){
	
	}
	public State(Integer stateId,String state){
		this.stateId = stateId;
		this.state = state;
	}

	public State(Integer stateId,String state,Country country){
		this.stateId = stateId;
		this.state = state;
		this.country = country;
	}

	public static ArrayList<State> collectStates(){
		ArrayList<State> states = new ArrayList<State>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");

			String q1 = "select state_id,state from states where country_id=99";
			//String q2 = "inner join countries as c where s.country_id=c.country_id";

			PreparedStatement ps = con.prepareStatement(q1);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				states.add(new State(rs.getInt(1),rs.getString(2)));
			}
			con.close();
		}
		catch (SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return states;
	}

	public void setStateId(Integer stateId){
		this.stateId = stateId;
	}
	public Integer getStateId(){
		return stateId;
	}

	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return state;
	}

	public void setCountry(Country country){
		this.country = country;
	}
	public Country getCountry(){
		return country;
	}
}