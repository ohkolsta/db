package dbProsjekt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Statistikk {
	public void results3000() throws Exception{
		Kobling kobling = new Kobling();
		Connection conn = kobling.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			String k = "";
			st = conn.createStatement();
			rs = st.executeQuery("SELECT Tidspunkt, Resultater FROM Resultatlogg "
					+ "INNER JOIN Ovelse ON Ovelse.OvelseNavn = Resultatlogg.OvelseNavn "
					+ "WHERE OvelseNavn='3000 m' "
					+ "GROUP BY Tidspunkt "
					+ "ORDER BY Resultater");
			while (rs.next()) {
				k = rs.getString(1);
				System.out.println(k);
			}
			System.out.println(" ");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
