package klient;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import a_OG_d.SokingOgSortering;
import easyIO.Out;

public class LagOgSkriv {
	static Out skjerm = new Out();
	static Instant end ,start;
	static long tid;



	public static void valgSortering(int antall, String valg){

		switch (valg) {
		case "Utvalg":
			/* Sortering ved utvalg */
			Integer[] liste1= lagNyliste(antall);//genererer liste med tilfeldige tall

			start = Instant.now();
			SokingOgSortering.utvalgSortering(liste1);
			end = Instant.now();
			tid = Duration.between(start, end).toMillis();

			skrivListe("Sortert ved Utvalg i "+tid+" ms",liste1);
			break;	
			
		case "Innsetting":
			/* Sortering ved innsetting */
			Integer[] liste2= lagNyliste(antall);//genererer liste med tilfeldige tall

			start = Instant.now();
			SokingOgSortering.sorteringVedInnsetting(liste2);
			end = Instant.now();
			tid = Duration.between(start, end).toMillis();

			skrivListe("Sortert ved Innsetting i "+tid+" ms",liste2);
			break;	
			
		case "Boblesortering":
			/* Boblesortering */
			Integer[] liste3= lagNyliste(antall);//genererer liste med tilfeldige tall

			start = Instant.now();
			SokingOgSortering.bobleSort(liste3);
			end = Instant.now();
			tid = Duration.between(start, end).toMillis();

			skrivListe("Sortert ved Boblesortering i "+tid+" ms",liste3);
			break;	
			
		case "Kvikksortering":
			/* Kvikksortering */
			Integer[] liste4= lagNyliste(antall);//genererer liste med tilfeldige tall

			start = Instant.now();
			SokingOgSortering.kvikkSort(liste4, 0, liste4.length-1);
			end = Instant.now();
			tid = Duration.between(start, end).toMillis();

			skrivListe("Sortert ved Kvikksortering i "+tid+" ms",liste4);
			break;	
			
		case "Flettesortering":
			/* Flettesortering */
			Integer[] liste5= lagNyliste(antall);//genererer liste med tilfeldige tall

			start = Instant.now();
			SokingOgSortering.fletteSort(liste5, 0, liste5.length-1);
			end = Instant.now();
			tid = Duration.between(start, end).toMillis();

			skrivListe("Sortert ved Flettesortering i "+tid+" ms",liste5);
			break;

		default:
			break;
		}
	}
	
	public static Integer[] lagNyliste(int antall){
		Random r = new Random(1);
		Integer[] liste= new Integer[antall];
		for (int i = 0; i < liste.length; i++) {
			liste[i]=r.nextInt(1000)+100;// genererer et tall fom 100 til 1100
		}
		return liste;
	}


	public static <T extends Comparable<T>>void skrivListe(String msg, T [] liste){
		System.out.println(msg);
		for (int indeks = 0; indeks < liste.length; indeks++) {
			skjerm.out(liste[indeks].toString(), 6,3);skjerm.out("|");
			if ((indeks+1)%20==0) {
				skjerm.outln();
			}
		}
		System.out.println("\n");
	}

}