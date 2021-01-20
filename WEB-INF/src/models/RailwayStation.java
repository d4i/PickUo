package models;

public class RailwayStation{
	private Integer stationId;
	private String stationName;
	private Address address;

	public void setStationId(Integer stationId){
		this.stationId = stationId;
	}
	public Integer getStationId(){
		return stationId;
	}

	public void setStationName(String stationName){
		this.stationName = stationName;
	}
	public String getStationName(){
		return stationName;
	}

	public void setAddress(Address address){
		this.address = address;
	}
	public Address getAddress(){
		return address;
	}
}