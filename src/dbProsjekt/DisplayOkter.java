package dbProsjekt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DisplayOkter {
	
	public DisplayOkter(Connection conn, BufferedReader br) throws Exception {
		Main main = new Main();
		System.out.println("Oversikt over dine økter");
		listAllOkter();
		
		System.out.println("Skriv inn tall på økt du vil se eller ferdig for å tilbake");
		String valg = br.readLine();
		
		if(inputIsNumber(valg)){
			try{
				if(hasRowsListOkt(valg)){
					listOkt(valg);
				} else {
					System.out.println("Denne økten finnes ikke.");
				}
			}catch(Exception e) {
				System.out.println("Ugyldig tall");
			}
			printReturnToMenu();
			goToMenu();
		} else {
			if(valg.equalsIgnoreCase("ferdig")){
				goToMenu();
			} else {
				System.out.println("Ugyldig kommando.");
				printReturnToMenu();
				goToMenu();
			}
		}
	}
	
	public boolean hasRowsListOkt(String oktNumber) throws Exception{
		Kobling kobling = new Kobling();
		Connection conn = kobling.getConnection();
		ResultSet rs = null;
		Statement st = null;
		st = conn.createStatement();
		rs = st.executeQuery("SELECT * FROM Okt INNER JOIN OktOvelser ON ((Okt.OktId = OktOvelser.OktId) AND (Okt.OktId = '"+oktNumber+"'))");
		if(rs.next()){
			return true;
		} else {
			return false;
		}
	}
	
	public void printReturnToMenu(){
		System.out.println("Returnerer til meny.. \n");
	}
	
	public void goToMenu() throws Exception{
		Main main = new Main();
		main.printMenu();
		main.useScanner();
	}
	
	public boolean inputIsNumber(String valg){
		try{
			int number = Integer.parseInt(valg);
		}catch(NumberFormatException e){
			return false;
		}return true;
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
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1) + "| " + rsmd.getColumnName(2) + "       | " + rsmd.getColumnName(3));
			while (rs.next()) {
				k = rs.getString(1) + "    | " + rs.getString(2) + " | " + rs.getString(3);
				System.out.println(k);
			}
		} catch(Exception e) {
			System.out.println(e);
		} System.out.println("\n");
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
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1) + "| " + rsmd.getColumnName(2) + "       | " + rsmd.getColumnName(3));
			if (rs.next()) {
				k = rs.getString(1) + "    | " + rs.getString(2) + " | " + rs.getString(3);
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
		} System.out.println("\n");
	}
}
