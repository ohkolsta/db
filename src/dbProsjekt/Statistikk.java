package dbProsjekt;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Statistikk {
	

	public static void results3000() throws Exception{
		Kobling kobling = new Kobling();
		Connection conn = kobling.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			String k = "";
			st = conn.createStatement();
			rs = st.executeQuery("SELECT Tidspunkt, Resultater FROM Resultatlogg "
					+ "INNER JOIN Ovelse ON Ovelse.OvelseNavn = Resultatlogg.OvelseNavn "
					+ "WHERE Resultatlogg.OvelseNavn='3000 m' "
					+ "GROUP BY Tidspunkt "
					+ "ORDER BY Resultater");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1) + "  | " + rsmd.getColumnName(2) +"\n");
			while (rs.next()) {
				k = rs.getString(1) + " | " + rs.getString(2);
				System.out.println(k);
			}
			System.out.println(" ");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
