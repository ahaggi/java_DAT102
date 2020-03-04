package klient;

import java.util.Scanner;

public class Klient {

	public static void main(String[] args) {
		System.out.println("Tast inn tallet på elementer");
		Scanner tast=new Scanner(System.in); 
		int antall=tast.nextInt();
		
		Integer[] liste= LagOgSkriv.lagNyliste(antall);//genererer liste med tilfeldige tall
		LagOgSkriv.skrivListe("Usortert liste",liste);

		String valg;
		String meny="Valg sortering metode:\n"
				+ "1-Utvalg \n"
				+ "2-Innsetting\n"
				+ "3-Boblesortering\n"
				+ "4-Kvikksortering\n"
				+ "5-Flettesortering\n"
				+ "6-sammenligne\n"
				+ "7-avslutt\n";

		do {
			System.out.println("\n\n"+meny);
			valg=tast.nextLine();
			
			switch (valg) {
			case "1":
				LagOgSkriv.valgSortering(antall,"Utvalg");
				break;
			case "2":
				LagOgSkriv.valgSortering(antall,"Innsetting");
				break;
			case "3":
				LagOgSkriv.valgSortering(antall,"Boblesortering");				
				break;
			case "4":
				LagOgSkriv.valgSortering(antall,"Kvikksortering");
				break;
			case "5":
				LagOgSkriv.valgSortering(antall,"Flettesortering");
				break;

			default:
				break;
			}
		}while(!valg.equals("7"));
		tast.close();

	}// main
}// class
