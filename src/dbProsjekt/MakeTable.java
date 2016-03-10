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
		ResultSet countRows = null;
		int number = 0;
		try{
			st = conn.createStatement();
			countRows = st.executeQuery("SELECT COUNT(*) FROM Ovelse");
			if(countRows.next()){
				number = countRows.getInt(1);
			}
			rs = st.executeQuery("SELECT * FROM Ovelse");
			final Object[][] table = new String[number][];
			int i = 0;
			while (rs.next()) {
				table[i] = new String[] {rs.getString(1), rs.getString(2)};
				i = i + 1;
			}
			for (final Object[] row : table){
				System.out.format("%-15s%-15s\n", row);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
			
	}
	
	public void tableOkt() throws Exception{
		Kobling kobling = new Kobling();
		Connection conn = kobling.getConnection();
		ResultSet rs = null;
		Statement st = null;
		ResultSet countRows = null;
		int number = 0;
		try{
			st = conn.createStatement();
			countRows = st.executeQuery("SELECT COUNT(*) FROM Okt");
			if(countRows.next()){
				number = countRows.getInt(1);
			}
			rs = st.executeQuery("SELECT * FROM Okt");
			final Object[][] table = new String[number][];
			int i = 0;
			while (rs.next()) {
				table[i] = new String[] {rs.getString(1), rs.getString(2), rs.getString(3)};
				i = i + 1;
			}
			for (final Object[] row : table){
				System.out.format("%-15s%-15s%-15s\n", row);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws Exception{
		MakeTable mt = new MakeTable();
		mt.tableOvelse();
		mt.tableOkt();
	}
}
