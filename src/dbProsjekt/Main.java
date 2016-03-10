package dbProsjekt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	
	
	String intro = "Hei og velkommen til Treningsdagbok!";
	
	public void Main(){
	}
	
	public void printIntro(){
		System.out.println(intro);
	}
	
	public void useScanner(){
		Scanner sc = new Scanner(System.in);
		
	}
	
	public static void main(String args[]) throws Exception{
		Main main = new Main();
		main.printIntro();
		main.useScanner();
		MakeTable mt = new MakeTable();
		mt.tableOvelse();
	}

}
