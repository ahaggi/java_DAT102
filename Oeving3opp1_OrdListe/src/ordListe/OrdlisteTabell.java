package ordListe;

import mengde.tabell.TabellMengde;
import easyIO.*;
import java.util.Scanner;
import Iterator.Iterator;

public class OrdlisteTabell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Out skjerm= new Out();
		String linje ="****************************************************";
		String linje2 ="-----------------------------------------";
		TabellMengde<String> ordListe1 = new TabellMengde<String>();

		String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		Scanner tastatur = new Scanner(System.in);
		// Legger til ordene i mengden ordListe1

		for (int i = 0; i < ord.length; i++) {
			ordListe1.leggTil(ord[i]);
		}

		TabellMengde<String> ordListe2 = new TabellMengde<String>();

		System.out.print("Oppgi en streng, avslutt med zzz :");
		String streng = tastatur.nextLine();
		// Leser inn ord
		while (!streng.equals("zzz")) {

			if (ordListe1.inneholder(streng)) {
				System.out.println("Ordliste1 innholder inngitte ordet: "+streng+"\n"+linje);
			}else{
				System.out.println("Ordliste1 innholder ikke inngitte ordet: "+streng+"\n"+linje);
			}
			ordListe2.leggTil(streng);

			System.out.print("Oppgi en streng, avslutt med zzz :");
			streng = tastatur.nextLine();
		} // while

		System.out.println(linje);

		// Lager unionen av de to ordlistene
		TabellMengde<String> ordListeBegge = new TabellMengde<String>();
		ordListeBegge = (TabellMengde<String>) ordListe1.union(ordListe2);
		System.out.println("Utskrift av unionen av begge ordlistene"+"\n"+linje2);
		//skriver ut og fjerner alle elementer i Ordlistebegge
		int antall=ordListeBegge.antall();
		for (int i = 1; i <= antall; i++) {
			skjerm.out(ordListeBegge.fjernTilfeldig(),10,3);
			System.out.print(", ");
			if (i%10==0) {
				System.out.println();
			}
		}

		// Lager snittet av de to ordlistene
		TabellMengde<String> ordListeFelles = new TabellMengde<String>();
		ordListeFelles = (TabellMengde<String>) ordListe1.snitt(ordListe2);
		System.out.println("\n"+"Utskrift av snittet av begge ordlistene"+"\n"+linje2);
		//skriver ut alle elementer i OrdlisteFelles
		Iterator<String> iterFelles=ordListeFelles.oppramser();
		for (int i = 0; i < ordListeFelles.antall(); i++) {
			skjerm.out(iterFelles.next(),10,3);
			System.out.print(", ");
			if ((i+1)%10==0) {
				System.out.println();
			}
		}


		// Lager differansen av de to ordlistene
		TabellMengde<String> ordListeDiff = new TabellMengde<String>();
		ordListeDiff = (TabellMengde<String>) ordListe1.differens(ordListe2);
		System.out.println("\n"+"Utskrift av differansen av begge ordlistene");
		//skriver ut alle elementer i OrdlisteDiff
		Iterator<String> iterDiff=ordListeDiff.oppramser();
		for (int i = 0; i < ordListeDiff.antall(); i++) {
			skjerm.out(iterDiff.next(),10,3);
			System.out.print(", ");
			if ((i+1)%10==0) {
				System.out.println();
			}
		}


		tastatur.close();
	}
}