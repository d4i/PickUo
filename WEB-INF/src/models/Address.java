package models;

import java.sql.*;

public class Address{
	private Integer addressId;
	private Integer plotNo;
	private String street1;
	private String street2;
	private String street3;
	private String area;
	private City city;
	private Integer pincode;

	public Address(Integer addressId,Integer plotNo,String street1,String street2,String street3,String area,City city,Integer pincode){
		this.addressId = addressId;
		this.plotNo = plotNo;
		this.street1 = street1;
		this.street2 = street2;
		this.street3 = street3;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}

	public Address(Integer plotNo,String street1,String street2,String street3,String area,City city,Integer pincode){
		this.plotNo = plotNo;
		this.street1 = street1;
		this.street2 = street2;
		this.street3 = street3;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}

	public Address(Integer addressId){
		this.addressId = addressId;
	}

	public Address(){
	
	}

	public Integer getAddress(){
		Integer addressId = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");
			
			String query = "insert into addresses (plot_no,street1,street2,area,city_id,pincode,street3) value (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1,plotNo);
			ps.setString(2,street1);
			ps.setString(3,street2);
			ps.setString(4,area);
			ps.setInt(5,city.getCityId());
			ps.setInt(6,pincode);
			ps.setString(7,street3);

			/*if(street3!=null){
				ps.setInt(7,street3);
			}*/

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			if(rs.next()){
				addressId = rs.getInt(1);
			}

			con.close();

		}catch (ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return addressId;
	}

	public void setAddressId(Integer addressId){
		this.addressId = addressId;
	}
	public Integer getAddressId(){
		return addressId;
	}

	public void setPlotNo(Integer plotNo){
		this.plotNo = plotNo;
	}
	public Integer getPlotNo(){
		return plotNo;
	}

	public void setStreet1(String street1){
		this.street1 = street1;
	}
	public String getStreet1(){
		return street1;
	}

	public void setStreet2(String street2){
		this.street2 = street2;
	}
	public String getStreet2(){
		return street2;
	}

	public void setStreet3(String street3){
		this.street3 = street3;
	}
	public String getStreet3(){
		return street3;
	}

	public void setArea(String area){
		this.area = area;
	}
	public String getArea(){
		return area;
	}

	public void setCity(City city){
		this.city = city;
	}
	public City getCity(){
		return city;
	}

	public void setPincode(Integer pincode){
		this.pincode = pincode;
	}
	public Integer getPincode(){
		return pincode;
	}
}