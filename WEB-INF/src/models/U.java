import java.sql.*;
import java.io.*;

public class U{
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pick_up?user=root&password=1234");
			
			File file=new File("E:\\sample_image.png");
			FileOutputStream fos=new FileOutputStream(file);
			byte b[];
			Blob blob;
			PreparedStatement ps=con.prepareStatement("select room_img from rooms where room_id=24"); 
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				//room = new Room();
				blob=rs.getBlob("room_img");
				b=blob.getBytes(1,(int)blob.length());
				fos.write(b);
			}			
			ps.close();
			fos.close();

			con.close();
		}catch(SQLException|ClassNotFoundException|IOException e){
			e.printStackTrace();
		}
	}
}
