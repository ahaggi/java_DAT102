package a_OG_d;

public class SokingOgSortering {

	/*************************************************************************************************/
	// Sorteringsalgoritmer
	/*************************************************************************************************/

	/**
	 * Utvalgsortering
	 * finn den minste verdien i listen.
	 * � bytt den med verdien i f�rste posisjon.
	 * � finn den minste verdien i resten av listen.
	 * � bytt den med verdien i andre posisjon.
	 * � gjenta inntil alle verdier er plassert i riktigeposisjoner.
	 * @param data er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgSortering(
			T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
				}
			}// indre for-l�kke

			/** Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		}// ytre for-l�kke
	}// metode

	/**
	 * Sortering ved innsetting
	 * En sortert del som ved best�r av f�rste element OG En usortert del som er resten
	 * I hvert steg:
	 * 			ta vare p� den f�rste element i de usorterte (N�KKEL) og sin indeksen.
	 * 			(sorterte elementer) compareTO (N�KKEL):
	 * 				 finn riktig plass mens vi flytter sortert del en  plass til h�yre (starter med bakerste)
	 *  		s� setter (N�KKEL) inn p� rett indeks i sortert del.
	 * 
	 * @param data  er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void sorteringVedInnsetting(T[] data) {

		for (int indeks = 1; indeks < data.length; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;

			//			De elementene som er st�rre m� forskyves en plass for �
			//			gi plass til n�kkel.
			//			I denne prosessen m� n�kkel sammenlignes med hver av
			//			de som er st�rre + en som er mindre eller lik (der vi
			//			stopper
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}

			data[p] = nokkel;
		}// ytre

	}// metode

	/**
	 * Boblesortering
	 * g� gjennom listen, bytt naboelementer hvis de ikke st�r
	 * i riktig rekkef�lge. H�YSTE verdi bobler oppover
	 * (mot h�yre) og vil utgj�re den sorterte delen av liste
	 * 
	 *  Gjenta inntil alle elementer er plassert p� riktig plass
	 * @param dataer data som skal sorteres
	 */
	public static <T extends Comparable<T>> void bobleSort(T[] data) {
		int p, sok;
		T temp;

		//		Den ytre l�kken g�r n ganger.
		//		Den indre l�kken g�r 1+2+3 + �.+ n = 
		//		Hele uttrykket n(n+1)/2 ganger dvs O(n*n)
		for (p = data.length - 1; p >= 0; p--) {  
			for (sok = 0; sok <= p - 1; sok++) {  //legg merk til at den indre l�kken m� v�re for ikke while dvs (ikke stans n�r if betingelsen er false )
				if (data[sok].compareTo(data[sok + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
				}
			}// indre l�kke
		}// ytre l�kke

	}// metode

	private static <T extends Comparable<T>> int finnPartisjon(T[] data,
			int min, int maks) {
		int venstre, hoyre;
		T temp, pivot;
		pivot = data[min];// pivot som forste element
		venstre = min;
		hoyre = maks;
		while (venstre < hoyre) {// ytre l�kke
			/** s�ker et element som er > enn pivot */
			/**
			 * OBS! M� ha testen venstre < hoyre for ellers g�r vi utover
			 * tabellomr�det n�r elementene er sortert p� forh�nd!
			 */
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0)
				venstre++;

			/** s�ker et element som er < enn pivot */
			while (data[hoyre].compareTo(pivot) > 0)
				hoyre--;
			/** bytter elementene */
			if (venstre < hoyre) {
				temp = data[venstre];
				data[venstre] = data[hoyre];
				data[hoyre] = temp;
			}
		}// while - ytre l�kke

		/** flytter pivot til riktig og sin endelige plass */
		temp = data[min];
		data[min] = data[hoyre];
		data[hoyre] = temp;
		return hoyre;
	}// metode

	public static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {

		int posPartisjon;
		if (maks - min > 0) { // minst to element
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort(data, min, posPartisjon - 1);
			/** Sorterer h�yre side */
			kvikkSort(data, posPartisjon + 1, maks);
		}
	}// metode

	private static <T extends Comparable<T>> void flette(T[] tabell, int forste, int midten, int siste) {
		int stor = siste - forste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[stor]);

		// Initierer lokale indeksar

		// start og slutt p� venstre deltabell
		int forste1 = forste;
		int siste1 = midten;

		// start og slutt p� h�yre deltabell
		int forste2 = midten + 1;
		int siste2 = siste;

		/*
		 * S� lenge begge deltabellene ikke er tomme, kopier det minste
		 * elementet til hjelpetabellen.
		 */
		int indeks = 0;

		while ((forste1 <= siste1) && (forste2 <= siste2)) {
			if (tabell[forste1].compareTo(tabell[forste2]) <= 0) {
				hjelpeTabell[indeks] = tabell[forste1];
				forste1++;
			} else {
				hjelpeTabell[indeks] = tabell[forste2];
				forste2++;
			}
			indeks++;
		}// while

		// kopiere resten av venstre del (kan vere tom)
		while (forste1 <= siste1) {
			hjelpeTabell[indeks] = tabell[forste1];
			forste1++;
			indeks++;
		}// while

		// kopiere resten av h�yre del (kan vere tom)
		while (forste2 <= siste2) {
			hjelpeTabell[indeks] = tabell[forste2];
			forste2++;
			indeks++;
		}// while

		// Kopier resultatet tilbake til den originale tabellen
		int h = 0;
		for (indeks = forste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h++];
		}
	}// flette */

	/*
	 * Sorterer en del av tabell[forste...siste]. Litt annnerlede enn i bok
	 */
	public static <T extends Comparable<T>> void fletteSort(T[] tabell, int forste, int siste) {
		if (forste < siste) { // minst to element
			int midten = (forste + siste) / 2;

			// Sorter venstre halvdel tabell[forste,midten];
			fletteSort(tabell, forste, midten);

			// Sorter h�gre halvdel tabell[midten+1,..siste]
			fletteSort(tabell, midten + 1, siste);

			// Fletter de to halvdelene
			flette(tabell, forste, midten, siste);
		}
	}// fletteSort
	
	
	
	
	/*************************************Oppgave 4 D ***************************************************/
	public static <T extends Comparable<T>>	 void sorteringVedInnsetting2(T[] data, int forste, int siste){
		for (int indeks = 1; indeks < data.length; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;
			//			De elementene som er st�rre m� forskyves en plass for �
			//			gi plass til n�kkel.
			//			I denne prosessen m� n�kkel sammenlignes med hver av
			//			de som er st�rre + en som er mindre eller lik (der vi
			//			stopper
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}

			data[p] = nokkel;
		}// ytre

	}// metode


	public static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks) {
		kvikkSort2(data, min, maks);
		sorteringVedInnsetting2(data, min, maks);
	}

	private static final int MIN = 10;
	
	public static <T extends Comparable<T>> void kvikkSort2(T[] data, int min, int maks) {
		int posPartisjon;
		if (maks - min+1 > MIN) { // minst to element
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort2(data, min, posPartisjon - 1);
			/** Sorterer h�yre side */
			kvikkSort2(data, posPartisjon + 1, maks);
		}
	}

}
