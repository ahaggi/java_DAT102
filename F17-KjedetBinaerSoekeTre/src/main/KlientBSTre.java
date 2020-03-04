package main;

import java.util.*;

class KlientBSTre {
	public static void main(String[] a) {
		// Lager BS-tre med 8 noder
		// Skriv ut i in-orden, dvs sortert
		// Sjekker om verdien 10 er i treet
		//

		final int ANTALL_NODER = 16;
		Random tilfeldig = new Random(1);

		KjedetBSTre<Integer> bs = new KjedetBSTre<Integer>();
		Integer resultat = null;

		for (int i = 0; i < ANTALL_NODER; i++) {
			Integer element = new Integer(tilfeldig.nextInt(30));
			bs.leggTil(element);
		}

		System.out.println("Treet med  " + bs.antall() + " noder.");

		System.out.println("\nHar hoeyde med: " + bs.hoyde());

		bs.visInorden();

		Integer el = new Integer(10);

		// ************************************************************************

		resultat = bs.finn(el);
		if (resultat != null)
			System.out.println("\nSoekte etter " + el + " og fant " + resultat);
		else
			System.out.println("\nSoekte etter " + el + " som ikke var i treet ");

		// ****************************************************************************
		for (int i = 0; i < 3; i++) {
			if (!bs.erTom()) {//etter fjerning av maks
				resultat = bs.finnMaks();
				bs.fjernMaks2();
				System.out.println("\nFjernet stoerste " + resultat);
				System.out.println("Treet er nå: ");
				bs.visInorden();
			} else
				System.out.println("Treet er tomt");
		}
		System.out.println("Antall noder i treet er  " + bs.antall() + " noder.");

		// ****************************************************************************
		for (int i = 0; i < 3; i++) {
		if (!bs.erTom()) {//etter fjerning av min
			resultat = bs.finnMin();
			bs.fjernMin2();
			System.out.println("\nFjernet minste " + resultat);
			System.out.println("Treet er nå: ");
			bs.visInorden();
		}else
			System.out.println("Tree er tomt ");
		}
		System.out.println("Antall noder i treet er  " + bs.antall() + " noder.");
		// ****************************************************************************

		resultat = bs.finnMin();
		if (resultat != null)
			System.out.println("\nMinste element " + resultat);
		else
			System.out.println("Treet er tomt");

		// ******************************************************************************

		resultat = bs.finnMaks();
		if (resultat != null)
			System.out.println("\nStoerste element " + resultat);
		else
			System.out.println("Treet er tomt");

		// ****************************************************************************

	}
}// class