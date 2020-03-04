package no.hib.dat102;

import easyIO.*;

public class Main {

	public static void main(String[] args) {
		//  oppretter en butikk med plass til 100 varer
		//		- la brukeren få valget mellom å lese varer fra fil eller legge inn minst 3 varer
		//		- utfører grossInnkjøp av minst 3 varetyper.
		//		- skriv ut totalverdien av alle varene i butikken
		//		- sletter en vare
		//		- utfører detaljsalg av minst to av de andre varene
		//		- prøver minst en metode som gir feilmelding til brukeren
		//		- skriv ut totalverdien av alle varene på nytt
		//		- lagre lageret på fil
		//		- avslutter programmet

		//		slett      skriv til fil      try catch

		In tastValg = new In();
		Out skjerm = new Out();

		System.out.println("butikk navn og maks antall");		//TODO

		String butikkNavn=tastValg.inWord();
		int maks=tastValg.inInt();
		Butikk bt=new Butikk(butikkNavn,maks);
		skjerm.outln();


		String meny = "\n" + "1 - legge inn nye varer \"les fra tastatur\". \n"
				+ "2 - legge inn nye varer \"les fra fil\". \n"
				+ "3 - utfører grossInnkjøp av minst 3 varetyper.\n"
				+ "4 - utfører detaljsalg av minst to av de andre varene.\n"
				+ "5 - skriv ut en vares info.\n"
				+ "6 - skriv ut alle varer info.\n"
				+ "7 - slett vare.\n"
				+ "8 - avslutter programmet.\n";

		String valg = "";

		do {
			skjerm.out(meny);
			valg = tastValg.inWord();

			switch (valg) {

			case "1":
				bt.leggInnNyVare();
				break;

			case "2":
				bt.lesInn();
				break;

			case "3":
				for (int i = 0; i < 3; i++) {
					System.out.println("Tast inn nummeret til den "+(i+1)+". varen som du vil øke mengde ");
					int vrnr=tastValg.inInt();
					System.out.println("Tast inn tallet på vare");
					int vMengde=tastValg.inInt();
					bt.grossInnkjøp(vrnr, vMengde);	
				}
				break;

			case "4": 
				for (int i = 0; i < 3; i++) {
					System.out.println("Tast inn nummeret til den "+(i+1)+". varen ");
					int vrnr=tastValg.inInt();
					bt.detaljSalg(vrnr);
				}
				break;

			case "5": 
				System.out.println("Tast inn vare nr som du vil søke etter");
				int vrnr=tastValg.inInt();
				bt.skrivheader();
				bt.skrivInfo(vrnr);
				break;

			case "6": 
				bt.skrivheader();
				bt.skrivInfoAlle();
				break;

			case "7": 
				System.out.println("Tast inn vare nr som du vil slette");
				int vrnret=tastValg.inInt();
				bt.slettVare(vrnret);
				break;

			default:
				skjerm.outln("Ukjent menyvalg, valg nr 7 avslutter programmet.");
			}
		} while (valg != "8"); // lّkke

	}

}
