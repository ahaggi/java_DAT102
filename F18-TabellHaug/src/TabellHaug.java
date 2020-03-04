//package no.hib.dat102.haug.tabell;

public class TabellHaug<T extends Comparable<T>> {
	// Lager en minimumshaug

	private T[] data;
	private int antall;

	private static final int STDK = 100;

	public TabellHaug() {
		data = (T[]) new Comparable[STDK];
		antall = 0;
	}

	public void leggTilElement(T el) {
		if (antall == data.length)
			utvidTabell();
		data[antall] = el; // Plasser den nye helt sist
		antall++;
		if (antall > 1)
			reparerOpp(); // Bytt om oppover hvis n�dvendig
	}

	private void utvidTabell() {
		// Dobler tabellen ved behov for utviding
		int lengde = data.length;
		T[] ny = (T[]) new Comparable[2 * lengde];
		for (int i = 0; i < antall; i++)
			ny[i] = data[i];
		data = ny;
	}


	// Etter at ny node er lagt inn som nytt blad
	// � Treet har rett form, men
	// � Vanligvis vil ordningen ikke v�re korrekt
	// � M� �reparere� treet slik at det blir en haug.
	// � Dette gj�res ved � sammenligne den nye noden
	// med foreldren og bytte disse hvis n�dvendig.
	// � Vi fortsetter denne prosesen �oppover� treet
	// inntil
	// � den nye verdien er st�rre enn eller lik forelderen
	// � eller den nye verdien blir rot til haugen.

	private void reparerOpp() {
		T hjelp;
		boolean ferdig = false;
		int aktuell = antall-1;
		int forelder ;
		while ((aktuell > 0) && !ferdig) { // Har flere noder lenger oppe og aktuell m� v�re st�rre enn 0
			forelder= (aktuell % 2 == 0) ? ((aktuell - 2) / 2) : ((aktuell - 1) / 2);

			if ((data[forelder]).compareTo(data[aktuell]) <= 0)
				ferdig = true;
			else { // Bytt om og g� videre oppover hvis forelder er for liten
				hjelp = data[aktuell];
				data[aktuell] = data[forelder];
				data[forelder] = hjelp;
				aktuell = forelder;
			}
		}
	}

	public T fjernMinste() {
		T svar = null;
		if (antall > 0) {
			svar = data[0];
			data[0] = data[antall - 1];
			reparerNed(); // Bytter om nedover hvis n�dvendig
			antall--;
		}
		return svar;
	}

	public T finnMinste(){
		T svar = null;
		if (antall > 0) {
			svar = data[0];
		}
		return svar;  
	}


	private void reparerNed() {
		T hjelp;
		boolean ferdig = false;
		int forelder = 0; // Start i roten og sml med neste niv�
		int minbarn;
		int vbarn = forelder * 2 + 1;
		int hbarn = vbarn + 1;
		while ((vbarn < antall) && !ferdig) { // Har flere noder lenger nede
			minbarn = vbarn;

			if ((hbarn < antall) && ((data[hbarn]).compareTo(data[vbarn]) < 0))
				minbarn = hbarn;
			// Har funnet det "minste" av barna. Sml med forelder

			if ((data[forelder]).compareTo(data[minbarn]) <= 0)
				ferdig = true;
			else { // Bytt om og g� videre nedover hvis forelder er for stor
				hjelp = data[minbarn];
				data[minbarn] = data[forelder];
				data[forelder] = hjelp;
				forelder = minbarn; //forelder indeks blir den verdien som vi har byttet ut
				vbarn = forelder * 2 + 1;
				hbarn = vbarn + 1;
			}
		}
	}

	public boolean erTom() {
		return antall == 0;
	}

	public void skrivTab() {
		// Hjelpemetode til test
		for (int i = 0; i < antall; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}
}