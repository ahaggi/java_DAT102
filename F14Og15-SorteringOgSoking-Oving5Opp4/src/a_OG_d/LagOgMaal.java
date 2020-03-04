package a_OG_d;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import easyIO.Out;

public class LagOgMaal {
	static Out skjerm = new Out();
	static Instant end ,start;
	static long tid;


	public static int maalTIdUtvalg (int antall){
		/* Sortering ved utvalg */
		Integer[] liste1= lagNyliste(antall);//genererer liste med tilfeldige tall

		start = Instant.now();
		SokingOgSortering.utvalgSortering(liste1);
		end = Instant.now();
		tid = Duration.between(start, end).toMillis();
		return (int)(tid);
	}

	public static int maalTIdInnsetting (int antall){
		/* Sortering ved innsetting */
		Integer[] liste2= lagNyliste(antall);//genererer liste med tilfeldige tall

		start = Instant.now();
		SokingOgSortering.sorteringVedInnsetting(liste2);
		end = Instant.now();
		tid = Duration.between(start, end).toMillis();

		return (int)tid;
	}
	
	
	public static int maalTIdBoblesortering(int antall){
		/* Boblesortering */
		Integer[] liste3= lagNyliste(antall);//genererer liste med tilfeldige tall

		start = Instant.now();
		SokingOgSortering.bobleSort(liste3);
		end = Instant.now();
		tid = Duration.between(start, end).toMillis();

		return (int)tid;
	}

	
	public static int maalTIdKvikksortering(int antall){
		/* Kvikksortering */
		Integer[] liste4= lagNyliste(antall);//genererer liste med tilfeldige tall

		start = Instant.now();
		SokingOgSortering.kvikkSort(liste4, 0, liste4.length-1);
		end = Instant.now();
		tid = Duration.between(start, end).toMillis();
		return (int)tid;
	}
	
	public static int maalTIdKvikksorteringNy(int antall){
		/* Kvikksortering */
		Integer[] liste6= lagNyliste(antall);//genererer liste med tilfeldige tall

		start = Instant.now();
		SokingOgSortering.kvikkSortNy(liste6, 0, liste6.length-1);
		end = Instant.now();
		tid = Duration.between(start, end).toMillis();
		return (int)tid;
	}

	public static int maalTIdFlettesortering(int antall){
		/* Flettesortering */
		Integer[] liste5= lagNyliste(antall);//genererer liste med tilfeldige tall

		start = Instant.now();
		SokingOgSortering.fletteSort(liste5, 0, liste5.length-1);
		end = Instant.now();
		tid = Duration.between(start, end).toMillis();
		return (int)tid;
	}

	
	public static Integer[] lagNyliste(int antall){
		Random r = new Random(1);
		Integer[] liste= new Integer[antall];
		for (int i = 0; i < liste.length; i++) {
			liste[i]=r.nextInt(1000)+100;// genererer et tall fom 100 til 1100
		}
		return liste;
	}


	public static void skrivResultat(String msg, int[][] res){
		System.out.println(msg);
		Out skjerm = new Out();
		String linje = "--------------------------------------------------------------";
		skjerm.outln(linje);

		
		skjerm.out("antall elementer", 20, 3);
		skjerm.out("|");
		skjerm.out("antall målinger", 20, 3);
		skjerm.out("|");
		skjerm.out("gj.snitt Målt tid", 20, 3);
		skjerm.outln("|");
		skjerm.outln(linje);
		for (int[] is : res) {
			for (int js : is) {
				skjerm.out(js, 20, 3);
			}
			skjerm.outln("");
		}
	}

}
