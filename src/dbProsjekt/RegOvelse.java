package dbProsjekt;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RegOvelse {
	
	public void insertOvelse(Connection conn, BufferedReader br) throws Exception{
		PreparedStatement myStmt = conn.prepareStatement("Insert into Ovelse (OvelseNavn, Beskrivelse) values (?,?)");
		
		System.out.print("Skriv navn �velse: ");
		String navn = br.readLine();
		
		System.out.print("Skriv en beskrivelse av �velsen: ");
		String beskrivelse = br.readLine();
		
		
		myStmt.setString(1,navn);
		myStmt.setString(2, beskrivelse);
		
		myStmt.executeUpdate();
		
		System.out.println("\nInsert complete");
		
	}
	
	public void showOvelse() throws Exception{
		System.out.println("Allerede registrerte �velser:");
		ReturnColumn rC = new ReturnColumn();
		rC.listOvelser();
		
	}
	
	public static void main(String[] args) throws SQLException, Exception {
		RegOvelse regOvelse = new RegOvelse();
		Kobling kobling = new Kobling();
		regOvelse.showOvelse();
		//regOvelse.insertOvelse(kobling.getConnection());
	}

}