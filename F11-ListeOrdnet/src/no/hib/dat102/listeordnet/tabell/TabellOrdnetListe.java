package no.hib.dat102.listeordnet.tabell;

import no.hib.dat102.listeordnet.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	
	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		T resultat = null;

		if (!erTom()) {
			bak--;
			resultat = liste[bak];
			liste[bak] = null;
		}
		return resultat;
	}

	@Override
	public T fjernFørste() {
		T resultat = null;
		if (!erTom()) {
			resultat = liste[0];
			bak--;
			/** skifter elementene en plass oppover */
			for (int i = 0; i < bak; i++) {
				liste[i] = liste[i + 1];
			}

		} // if

		return resultat;
	}

     @Override
	public T første() {
		T resultat = null;
		if (!erTom()){
			resultat = liste[0];
		}
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		if (!erTom()){
			resultat = liste[bak - 1];
		}
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}
	
    @Override
	public void leggTil(T element) {
    	   	
		if (antall() == liste.length){
			utvid(); // arves
		}
		
		int i = 0;
		while (i < bak && element.compareTo(liste[i]) > 0) {
			i++;
		}
		// i peker nå på plassen der elementet skal inn

		for (int j = bak; j > i; j--) {// Må lage plass ved å skifte bakover
			liste[j] = liste[j - 1]; // de elementene på plassene f.o.m indeks i
		}
		
		liste[i] = element;
		bak++;
	}

	// Implementer de to abstrakte metodene
	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		T resultat = null;

		int indeks = finn(element);

		if (indeks != IKKE_FUNNET) {
			resultat = liste[indeks];
			bak--;
			/** skifter elementene etter det vi fjernet en plass opp */
			for (int i = indeks; i < bak; i++)// OBS BAK--
				liste[i] = liste[i + 1];
			liste[bak] = null;
		} // if

		return resultat;
	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		while (i < bak && el.compareTo(liste[i]) > 0) {
			i++;
		}
		if (el.equals(liste[i])) 
			resultat=i;
		
		
		return resultat;
	}

	@Override
	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}


	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable [liste.length * 2]);

		for (int i = 0; i < liste.length; i++){
			hjelpeTabell[i] = liste[i];
		}
		
		liste = hjelpeTabell;
	}

	@Override
	public void snu() {
		
	}

}// class