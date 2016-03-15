package dbProsjekt;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayOkter {
	
	public DisplayOkter(Connection conn, BufferedReader br) throws Exception {
		Main main = new Main();
		System.out.println("Oversikt over dine økter");
		listAllOkter();
		
		System.out.println("Skriv inn tall på økt du vil se eller ferdig for å tilbake");
		String valg = br.readLine();
		
		try{
			int number = Integer.parseInt(br.readLine());
			listOkt(valg);
			
		} catch(NumberFormatException e) {
			if(valg.equalsIgnoreCase("ferdig")){
				main.useScanner();
				printMenu();
			} else {
				System.out.println("Feil input. Returnerer til meny");
				main.useScanner();
				printMenu();
			}
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
	
	public void listOkt(String oktNumber) throws Exception{
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
	
	public void insertOkt(Connection conn, BufferedReader br) throws Exception{
		PreparedStatement myStmt1 = conn.prepareStatement("Insert into Okt (Dato, Varighet) values (?,?)");
		
		System.out.print("Skriv inn dato for økten: ");
		String dato = br.readLine();
		
		System.out.print("Skriv inn varigheten av økten: ");
		int varighet = Integer.parseInt(br.readLine());
		
		
		myStmt1.setString(1, dato);
		myStmt1.setInt(2, varighet);
		
		myStmt1.executeUpdate();
		
		System.out.println("\nInsert complete");
	}
	
	public void printMenu(){
		
		
		System.out.println("To valg");
		System.out.println("1. Skrive inn navnet på øvelsen fra listen over. Øvelsen må være med i listen.");
		System.out.println("3. Skriv 'ferdig' dersom du er ferdig med å legge til øvelser.\n");
		
		
	}

}
