package no.hib.dat102;

public class SokingOgSortering {

	/*************************************************************************************************/
	// Søkealgoritmer
	/*************************************************************************************************/

	/**
	 * Metoden gjør et lineært søk i en tabell av usorterte data
	 * 
	 * @param data er data som skal søkes i
	 * @param min er startindeks
	 * @param maks er sluttindeks
	 * @param el er verdien vi søker etter
	 * @return sann om elementet ble funnet ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSok(T[] data,	int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks <= maks && !funnet) {
			if (data[indeks].compareTo(el) == 0)
				funnet = true;
			indeks++;
		}// while
		return funnet;
	}// metode

	/**
	 * Metoden gjør et lineært søk i en sortert tabell av data
	 * 
	 * @param data er data som skal søkes i
	 * @param min er startindeks
	 * @param maks er sluttindeks
	 * @param el verdien vi søker etter
	 * @return sann hvis funnet ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSokSortert(T[] data,int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks < maks && data[indeks].compareTo(el) < 0) {
			indeks++;
		}// while

		if (data[indeks].compareTo(el) == 0) {
			funnet = true;
		}

		return funnet;

	}// metode

	/**
	 * Metoden gjør et binært søk i en *sortert* tabell av data
	 * 
	 * @param data er data som skal søkes i
	 * @param min er startindeks
	 * @param maks er sluttindeks
	 * @param el er elementet vi søker etter
	 * @return sann om elementet ble funnet ellers usann.
	 */

	public static <T extends Comparable<T>> boolean  binaerSok(T[] data, int min, int maks, T el){
		if (min > maks){ // basistilfelle, ingen element 
			return false;
		}

		int midtpunkt = (min + maks) / 2; 
		int resultat = el.compareTo(data[midtpunkt]);

		if (resultat == 0){ // basistilfelle, finner elementet 
			return true;
		}
		if(resultat < 0){//  (her vil også fungere med    else if)
			return binaerSok(data, min, midtpunkt-1, el);
		} else {  // resultat > 0
			return binaerSok(data, midtpunkt+1, maks, el);
		}
	}//


	/* Rekursiv binærsøk som returnerer indeks */

	public static <T extends Comparable<T>> int binaerSok2(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		if (min > maks) { // basistilfelle, ingen element
			return -1;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) { // basistilfelle, finner elementet
			return midtpunkt;
		}
		if (resultat < 0) {// ( vil her også fungere med else if)
			return binaerSok2(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSok2(data, midtpunkt + 1, maks, el);
		}
	}// metode

	/* Ikke rekursiv binærsøk som returnerer indeks */

	public static <T extends Comparable<T>> int binaerSok3(T[] data, int min,int maks, T el) {
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		int forste = min;
		int siste = maks;
		int indeks = -1;
		boolean funnet = false;
		while ((forste <= siste) && !(funnet)) {
			int midtpunkt = (forste + siste) / 2; 
			int resultat = el.compareTo(data[midtpunkt]);
			if (resultat == 0) {
				funnet = true;
				indeks = midtpunkt;
			} 
			else if (resultat < 0) {// Søk i nedre halvdel
				siste = midtpunkt - 1;
			} 
			else {// Søk i øvre halvdel
				forste = midtpunkt + 1;
			}
		}// while

		return indeks;
	}//

	/*************************************************************************************************/
	// Sorteringsalgoritmer
	/*************************************************************************************************/

	/**
	 * Utvalgsortering
	 * finn den minste verdien i listen.
	 * • bytt den med verdien i første posisjon.
	 * • finn den minste verdien i resten av listen.
	 * • bytt den med verdien i andre posisjon.
	 * • gjenta inntil alle verdier er plassert i riktigeposisjoner.
	 * @param data er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgSortering(T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
				}
			}// indre for-løkke

			/** Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		}// ytre for-løkke
	}// metode

	/**
	 * Sortering ved innsetting
	 * En sortert del som ved består av første element OG En usortert del som er resten
	 * I hvert steg:
	 * 			ta vare på den første element i de usorterte (NØKKEL) og sin indeksen.
	 * 			(sorterte elementer) compareTO (NØKKEL):
	 * 				 finn riktig plass mens vi flytter sortert del en  plass til høyre (starter med bakerste)
	 *  		så setter (NØKKEL) inn på rett indeks i sortert del.
	 * 
	 * @param data  er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void sorteringVedInnsetting(T[] data) {

		for (int indeks = 1; indeks < data.length; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;

			//			De elementene som er større må forskyves en plass for å
			//			gi plass til nøkkel.
			//			I denne prosessen må nøkkel sammenlignes med hver av
			//			de som er større + en som er mindre eller lik (der vi
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
	 * gå gjennom listen, bytt naboelementer hvis de ikke står
	 * i riktig rekkefølge. HØYSTE verdi bobler oppover
	 * (mot høyre) og vil utgjøre den sorterte delen av liste
	 * 
	 *  Gjenta inntil alle elementer er plassert på riktig plass
	 * @param dataer data som skal sorteres
	 */
	public static <T extends Comparable<T>> void bobleSort(T[] data) {
		int p, sok;
		T temp;

		//		Den ytre løkken går n ganger.
		//		Den indre løkken går 1+2+3 + ….+ n = 
		//		Hele uttrykket n(n+1)/2 ganger dvs O(n*n)
		for (p = data.length - 1; p > 0; p--) {  
			for (sok = 0; sok < p; sok++) {  //legg merk til at den indre løkken må være for ikke while dvs (ikke stans når if betingelsen er false )
				if (data[sok].compareTo(data[sok + 1]) > 0) {
					/* Bytt verdiene */
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
				}
			}// indre løkke
		}// ytre løkke

	}// metode

	private static <T extends Comparable<T>> int finnPartisjon(T[] data,int min, int maks) {
		int venstre, hoyre;
		T temp, pivot;
		pivot = data[min];// pivot som forste element
		venstre = min;
		hoyre = maks;
		while (venstre < hoyre) {// ytre løkke
			/** søker et element som er > enn pivot */
			/**
			 * OBS! Må ha testen venstre < hoyre for ellers går vi utover
			 * tabellområdet når elementene er sortert på forhånd!
			 */
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0)
				venstre++;

			/** søker et element som er < enn pivot */
			while (data[hoyre].compareTo(pivot) > 0)
				hoyre--;
			
			/** bytter elementene */
			if (venstre < hoyre) {
				temp = data[venstre];
				data[venstre] = data[hoyre];
				data[hoyre] = temp;
			}
		}// while - ytre løkke

		/** flytter pivot til riktig og sin endelige plass */
		data[min] = data[hoyre];
		data[hoyre] = pivot;
		return hoyre;
	}// metode

	public static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {
		
		if (maks > min) { // minst 2 element
			/** Lager partisjon */
			int posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort(data, min, posPartisjon - 1);
			/** Sorterer høyre side */
			kvikkSort(data, posPartisjon + 1, maks);
		}
	}// metode

	private static <T extends Comparable<T>> void flette(T[] tabell, int forste, int midten, int siste) {
		int stor = siste - forste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[stor]);

		// Initierer lokale indeksar

		// start og slutt på venstre deltabell
		int forste1 = forste;
		int siste1 = midten;

		// start og slutt på høyre deltabell
		int forste2 = midten + 1;
		int siste2 = siste;

		/*
		 * Så lenge begge deltabellene ikke er tomme, kopier det minste
		 * elementet til hjelpetabellen.
		 */
		int indeks = 0;

		while ((forste1 <= siste1) && (forste2 <= siste2)) {
			if (tabell[forste1].compareTo(tabell[forste2]) < 0) {
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

		// kopiere resten av høyre del (kan vere tom)
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

			// Sorter høgre halvdel tabell[midten+1,..siste]
			fletteSort(tabell, midten + 1, siste);

			// Fletter de to halvdelene
			flette(tabell, forste, midten, siste);
		}
	}// fletteSort

}
