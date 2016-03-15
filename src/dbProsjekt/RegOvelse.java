package dbProsjekt;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RegOvelse {
	
	
	public RegOvelse(Connection conn, BufferedReader br) throws Exception{
		showOvelse();
		insertOvelse(conn,br);
	}
	
	public void insertOvelse(Connection conn, BufferedReader br) throws Exception{
		PreparedStatement myStmt = conn.prepareStatement("Insert into Ovelse (OvelseNavn, Beskrivelse) values (?,?)");
		
		System.out.print("Skriv navn øvelse: ");
		String navn = br.readLine();
		
		System.out.print("Skriv en beskrivelse av øvelsen: ");
		String beskrivelse = br.readLine();
		
		
		myStmt.setString(1,navn);
		myStmt.setString(2, beskrivelse);
		
		myStmt.executeUpdate();
		
		System.out.println("\nInsert complete");
		System.out.println("\n\n\n\n");
		
		Main main = new Main ();
		main.printMenu();
		main.useScanner();
		br.close();
		
	}
	
	public void showOvelse() throws Exception{
		System.out.println("Allerede registrerte øvelser:");
		ReturnColumn rC = new ReturnColumn();
		rC.listOvelser();
	}
	
	

	
	public static void main(String[] args) throws SQLException, Exception {
		
	}

}
