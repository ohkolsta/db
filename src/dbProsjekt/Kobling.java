package dbProsjekt;

import java.sql.Connection;
import java.sql.DriverManager;

public class Kobling {
	
	public static void main(String[] args) throws Exception {
		Kobling cc = new Kobling();
		cc.getConnection();
	}
	
	public Connection getConnection() throws Exception{
		
		Connection conn = null;
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://mysql.stud.ntnu.no:3306/martiaks_database";
			String username = "martiaks_bruker";
			String passord = "Passord";
			
			Class.forName(driver); 
			conn = DriverManager.getConnection(url,username,passord);
			System.out.println("Connection");
		}catch(Exception e){System.out.println(e);}
		return conn;
	}
		
	

}
