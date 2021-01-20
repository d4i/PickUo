package models;

import java.sql.*;

public class Contact{
	private Integer contactId;
	private String contact1;
	private String contact2;
	private String contact3;

	public Contact(Integer contactId,String contact1,String contact2,String contact3){
		this.contactId = contactId;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.contact3 = contact3;
	}

	public Contact(String contact1,String contact2,String contact3){
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.contact3 = contact3;
	}

	public Contact(Integer contactId){
		this.contactId = contactId;	
	}
	
	public Contact(){
		
	}

	public Integer getContact(){
		Integer contactId = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");

			String query = "insert into contacts (contact1,contact2,contact3) value (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			ps.setString(1,contact1);
			ps.setString(2,contact2);
			ps.setString(3,contact3);

			/*if(contact3!=null){
				ps.setString(3,contact3);
			}*/

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			if(rs.next()){
				contactId = rs.getInt(1);
			}

			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return contactId;
	}

	public void setContactId(Integer contactId){
		this.contactId = contactId;
	}
	public Integer getContactId(){
		return contactId;
	}

	public void setContact1(String contact1){
		this.contact1 = contact1;
	}
	public String getContact1(){
		return contact1;
	}

	public void setContact2(String contact1){
		this.contact2 = contact2;
	}
	public String getContact2(){
		return contact2;
	}

	public void setContact3(String contact1){
		this.contact3 = contact3;
	}
	public String getContact3(){
		return contact3;
	}
}