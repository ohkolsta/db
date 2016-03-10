package dbProsjekt;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			System.out.println(" ");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void listOkter(String oktNumber) throws Exception{
		Kobling kobling = new Kobling();
		Connection conn = kobling.getConnection();
		ResultSet rs = null;
		Statement st = null;
		int t = 0;
		int oktnr = Integer.parseInt(oktNumber);
		try{
			String k = "";
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Okt INNER JOIN OktOvelser ON ((Okt.OktId = OktOvelser.OktId) AND (Okt.OktId = '"+oktNumber+"'))");
			if (rs.next()) {
				k = rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3);
				System.out.println(k);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		try{
			String k = "";
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Okt INNER JOIN OktOvelser ON ((Okt.OktId = OktOvelser.OktId) AND (Okt.OktId = '"+oktNumber+"'))");
			while (rs.next()) {
				k = rs.getString(5);
				System.out.println(k);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void listAllOkter() throws Exception{
		Kobling kobling = new Kobling();
		Connection conn = kobling.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			String k = "";
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Okt");
			while (rs.next()) {
				k = rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3);
				System.out.println(k);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {
		ReturnColumn rc = new ReturnColumn();
		rc.listOkter("2");
	}
}

