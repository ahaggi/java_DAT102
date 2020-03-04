package no.hib.dat102.listeordnet.kjedet;

import no.hib.dat102.listeordnet.adt.OrdnetListeADT;

/**
 * 
 * @param <T>
 *            elementtypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> første, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		første = null;
		siste = null;
	}

	@Override
	public T fjernFørste() {
		T svar = null;
		if (!erTom()) {
			svar = første.getElement();
			første = første.getNeste();
			antall--;
		}
		if (erTom()) {
			siste = null;
		}
		return svar;
	}

	@Override
	public T fjernSiste() {
		T svar = null;
		if (!erTom()) {
			svar = siste.getElement();
			antall--;
			if (antall == 0) {
				første = null;
				siste = null;
			} else {
				siste = første;
				for (int i = 1; i < antall; i++) {
					siste = siste.getNeste();
				}
				siste.setNeste(null);
			}
		}
		return svar;
	}

	@Override
	public T første() {
		T svar = null;
		if (!erTom()) {
			svar = første.getElement();
		}
		return svar;
	}

	@Override
	public T siste() {
		T svar = null;
		if (!erTom()) {
			svar = siste.getElement();
		}
		return svar;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {

		LinearNode<T> ny = new LinearNode<T>(element);

		LinearNode<T> denne = første;
		if (!erTom()) {

			if (element.compareTo(første.getElement()) < 0) {// foran
				ny.setNeste(første);
				første = ny;
			} else if (element.compareTo(siste.getElement()) > 0) {// bak
				siste.setNeste(ny);
				siste = ny;
			} else {// inni lilsten
				while (denne.getNeste() != null && element.compareTo(denne.getNeste().getElement()) > 0) {
					denne = denne.getNeste();
				}
				ny.setNeste(denne.getNeste());
				denne.setNeste(ny);
			}
		} else {
			første = siste = ny;
		}
		antall++;
	}


	@Override
	public void snu() {

		if (antall >= 2) {

			while (første.getElement().compareTo(første.getNeste().getElement()) < 0) {

				LinearNode<T> aktualle = første;
				første = første.getNeste();

				LinearNode<T> forrige = aktualle;
				LinearNode<T> denne = første;

				if (aktualle.getElement().compareTo(siste.getElement()) < 0) {// bak
					aktualle.setNeste(siste.getNeste());
					siste.setNeste(aktualle);
					siste = aktualle;
				} else {// inni lilsten
					while (denne != null && aktualle.getElement().compareTo(denne.getElement()) < 0) {
						forrige = denne;
						denne = denne.getNeste();
					}
					forrige.setNeste(aktualle);
					aktualle.setNeste(denne);
				} // else
			} // while

		}
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = første;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				første = første.getNeste();
				if (første == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funnet
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne= første;
		boolean res=false;
		while (denne!=null && element.compareTo(denne.getElement())>0) 
			denne=denne.getNeste();
		
		if(denne!=null)
			res=(element.compareTo(denne.getElement())==0)?true:false;

		return res;
//		LinearNode<T> denne = første;
//		boolean resultat = false;
//		while (denne != null && element.compareTo(denne.getElement()) > 0) {
//			denne = denne.getNeste();
//		}
//		if (denne != null) {
//			if (element.equals(denne.getElement())) {
//				resultat = true;
//			}
//		} // ikke-funnet
//		return resultat;
	}

}// class