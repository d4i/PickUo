import java.io.*;
import org.json.*;
import java.util.*;
import java.sql.*;

class A{

	public static final String user = "root";
	public static final String password = "1234";
	public static final String database = "pick_up";
	public static final String cityTable = "cities";
	public static final String stateTable = "states";
	//public static final String uniTable = "universities";
	//public static final String uniColumn = "uni_name";

	//public static final String branchTable = "branches";
	//public static final String branchColumn = "branch";

	public static Connection con = null; 

	static int i = -1;

	static ArrayList<String> states = new ArrayList();
	//static ArrayList<String> branches = new ArrayList();
	//static ArrayList<String> unis = new ArrayList();
	static Map<Integer , ArrayList<String>> cities = new HashMap();

	static File file = new File("data.xy");
	//static File fileuni = new File("university.txt");
	static FileReader fl = null;
	//static FileReader fl2 = null;

	static StringBuilder json = new StringBuilder("");
	//static StringBuilder jsonuni = new StringBuilder("");
		

	static{
		try{
			fl = new FileReader(file);
			//fl2 = new FileReader(fileuni);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?user="+user+"&password="+password);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


	public static void main(String[] args)throws Exception{
		System.out.println("Namste...............");		
		
		readStateCityData();
		saveStateCityToDB();

		
		//getAndSaveBranches();

		//readUniData();
		//saveUnis();



		con.close();
		System.out.println("Bye...............");
	}

	public static void saveStateCityToDB(){
		int z = 1;
		for(String x : states){
			int id = saveState(x);
			ArrayList ar = cities.get(z++);
			saveCities(id , ar);
		}

	}

	/*public static void getAndSaveBranches(){
		branches.add("Computer Science Engineering");
		branches.add("Electronics and Communication Engineering");
		branches.add("Electrical engineering");
		branches.add("Mechanical Engineering");
		branches.add("Information Technology Engineering");
		branches.add("Civil Engineering");
		branches.add("Chemical Engineering");
		branches.add("Aeronautical Engineering");
		branches.add("Mining engineering");

		saveBranches(branches);
	}

	public static void readUniData()throws Exception{
		
		i = -1;
		while((i = fl2.read())!=-1){
			jsonuni.append((char)i);
		}
	}*/
	public static void readStateCityData() throws Exception{
		 i = -1;
		while((i = fl.read())!=-1){
			json.append((char)i);
		}

		JSONObject jo = new JSONObject(json.toString());
		JSONArray ja = jo.getJSONArray("states");

		for(int l = 0 ; l < ja.length() ; l++){

			ArrayList<String> cts = new ArrayList();
			JSONObject obj = ja.getJSONObject(l);
			String state  = obj.getString("state");
			states.add(state);
			JSONArray arrcities = obj.getJSONArray("districts");
			for(int k = 0 ; k < arrcities.length() ; k++){
				cts.add((String)arrcities.get(k));
			}

			cities.put(states.size() , cts);
		}


		
	}

	public static int saveState(String state){
					
		int id = -1;
		try{
			String query = "insert into "+ stateTable + " (state,country_id) value (?,99)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1 , state);
			if(ps.executeUpdate()==1){
				System.out.println("Saving ......" + state);
				query = "select max(state_id) from "+ stateTable  ;
				ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					id = rs.getInt(1);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return id;
	}


	public static void saveCities(Integer stateId , ArrayList<String> cities){
		try{
			String query = "insert into "+ cityTable + " (state_id , city ) value (? , ?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			for(String c : cities){
				ps = con.prepareStatement(query);
				ps.setInt(1 , stateId);
				ps.setString(2 , c);
				System.out.println("Saving ......" + c);
				ps.executeUpdate();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/*public static void saveUnis(){
			PreparedStatement ps = null;
			try{
					ps = con.prepareStatement(jsonuni.toString());
					System.out.println("Saving ......");
					ps.executeUpdate();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
	}
	public static void saveBranches(ArrayList<String> branches){
		try{
			String query = "insert into "+ branchTable + " ( " + branchColumn +") value (?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			for(String c : branches){
				ps = con.prepareStatement(query);
				ps.setString(1 , c);
				System.out.println("Saving ......" + c);
				ps.executeUpdate();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
}