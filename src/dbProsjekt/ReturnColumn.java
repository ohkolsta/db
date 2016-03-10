package dbProsjekt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReturnColumn {
	
	public void listOvelser() throws Exception{
		Kobling kobling = new Kobling();
		Connection conn = kobling.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			String k = "";
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Ovelse");
			while (rs.next()) {
				k = rs.getString(1);
				System.out.println(k);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		ReturnColumn rc = new ReturnColumn();
		rc.listOvelser();
	}
}

