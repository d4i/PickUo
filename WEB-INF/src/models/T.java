import java.sql.*;
import java.io.*;
 
public class T {
	public static void main(String args[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");
			
			File file=new File("E:\\img.jpg");
			FileInputStream fis=new FileInputStream(file);
			
			PreparedStatement ps=con.prepareStatement("insert into rooms (room_no,capacity,hotel_id,room_img) values(22,30,4,?)"); 
			//ps.setString(1,"image 1");
			ps.setBinaryStream(1,fis,(int)file.length());
			ps.executeUpdate();
 
			ps.close();
			fis.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}