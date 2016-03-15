package dbProsjekt;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.control.Label;

public class RegOkt {
	
    Connection conn;
    Statement st;
    ResultSet rs;
    Main main = new Main ();
	
	public RegOkt(Connection conn, BufferedReader br) throws Exception {
		sjekkOvelser(br);
		insertOkt(conn,br);
		showOvelse();
		printMenu();
		addOvelse(conn, br);
	}
	
	public void sjekkOvelser(BufferedReader br) throws Exception{
		System.out.println("Før du begynner må du sjekke om alle øvelsene du skal legge til er tilgjengelig");
		System.out.println("\n");
		showOvelse();
		System.out.print("Hvis ja, skriv ja og fortsett registreringen. Hvis nei, skriv nei og gå tilbake menyen: ");
		
		if(br.readLine().toLowerCase().equals("nei")){
			System.out.println("\n\n\n\n");
			main.printMenu();
			main.useScanner();
			br.close();
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
	
	public void addOvelse(Connection conn, BufferedReader br) throws Exception{
    	st = conn.createStatement();
		rs = st.executeQuery("SELECT max(OktId) from Okt");
		String Id=null;
		if(rs.next()){
			Id = (rs.getString(1));
		}	
		
		System.out.println("Skriv inn navnet på øvelsen fra listen over:");
		
		String sjekk = br.readLine();
		
		while(!(checkValid(sjekk))){
			System.out.println("Øvelsen finnes ikke i listen. Skriv nytt:");
			sjekk = br.readLine();
		}
		
		while (!(sjekk.toLowerCase().equals("ferdig"))){
			System.out.println("Skriv inn navnet på øvelsen fra listen over eller 'ferdig':");
			PreparedStatement myStmt2 = conn.prepareStatement("Insert into OktOvelser (OktId, OvelseNavn) values (?,?)");
			
			int OktId = Integer.parseInt(Id);
			String OvelseNavn = sjekk;
			
			
			myStmt2.setInt(1, OktId);
			myStmt2.setString(2, OvelseNavn);
			
			myStmt2.executeUpdate();
			
			System.out.println("Insert complete");
			
			
			
			sjekk = br.readLine();
			while(!(checkValid(sjekk))){
				if(sjekk.toLowerCase().equals("ferdig")){
					break;
				}
				System.out.println("Øvelsen finnes ikke i listen. Skriv nytt:");
				sjekk = br.readLine();
			}
		
		}
		
		System.out.println("\n\n\n\n");
		main.printMenu();
		main.useScanner();
		br.close();
		
	}
	
	public void showOvelse() throws Exception{
		System.out.println("Liste over øvelser:");
		ReturnColumn rC = new ReturnColumn();
		rC.listOvelser();
	}
	
	public void printMenu(){
		
		
		System.out.println("To valg");
		System.out.println("1. Skrive inn navnet på øvelsen fra listen over. Øvelsen må være med i listen.");
		System.out.println("3. Skriv 'ferdig' dersom du er ferdig med å legge til øvelser.\n");
		
		
	}
	
	public boolean checkValid(String test) throws Exception{
		
		ArrayList<String> list = new ArrayList<String>();
		
		Kobling kobling = new Kobling();
		Connection conn = kobling.getConnection();
		ResultSet rs = null;
		Statement st = null;
		st = conn.createStatement();
		rs = st.executeQuery("SELECT * FROM Ovelse");
		while (rs.next()) {
			if(rs.getString(1).equals(test)){
				return true;
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) throws Exception {
		//RegOkt r = new RegOkt();
	}
}
