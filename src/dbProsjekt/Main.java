package dbProsjekt;

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
	
	public static void main(String args[]){
		Main main = new Main();
		main.printIntro();
		main.useScanner();
		
		
	}

}
