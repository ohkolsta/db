package dbProsjekt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	
	
	String intro = "Hei og velkommen til Treningsdagbok!\n";
	
	public void printIntro(){
		System.out.println(intro);
		
	}
	
	public void useScanner() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String valg = br.readLine();
        
        if(valg.equals("1")) System.out.println("Valgte 1");
        else if (valg.equals("2")){
        	RegOvelse regOvelse = new RegOvelse();
        	Kobling kobling = new Kobling();
    		regOvelse.showOvelse();
        	regOvelse.insertOvelse(kobling.getConnection(), br);
        }
        else System.out.println("Valgte 3");
        
        br.close();
		
	}
	
	public void printMenu(){
		System.out.println("Tast inn hva du ønsker å gjøre");
		System.out.println("1. Registrer en økt");
		System.out.println("2. Legg til en øvelse i databasen");
		System.out.println("3. Hent/se på tidligere økt\n");
		System.out.print("Ditt valg: ");
	}
	
	public static void main(String args[]) throws Exception{
		Main main = new Main();
		main.printIntro();
		main.printMenu();
		main.useScanner();
		//MakeTable mt = new MakeTable();
		//mt.tableOvelse();

	}

}
