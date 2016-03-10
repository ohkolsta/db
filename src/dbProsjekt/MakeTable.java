package dbProsjekt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MakeTable {
	
	public void tableOvelse() throws Exception{
		Kobling kobling = new Kobling();
		Connection conn = kobling.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			String k = "";
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Ovelse");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			System.out.println("Number of columns: " + columnsNumber);
			while (rs.next()) {
			    for(int i = 1; i < columnsNumber; i++){
			        for(int j = 2; j <= columnsNumber; j++){
			        	k = rs.getString(i) + " " + "| " + rs.getString(j) + " ";
			        	System.out.println(k);
			        }
			    }
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
