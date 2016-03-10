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
			while (rs.next()) {
				k = rs.getString(1) + " " + "| " + rs.getString(2) + " ";
				System.out.println(k);
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
		try{
			String k = "";
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Okt");
			final Object[][] table = new String[4][0];
			while (rs.next()) {
				table[0] = new String[] {rs.getString(1), rs.getString(2), rs.getString(3)};
				k = rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3);
				System.out.println(k);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws Exception{
		MakeTable mt = new MakeTable();
		mt.tableOkt();
	}
}
