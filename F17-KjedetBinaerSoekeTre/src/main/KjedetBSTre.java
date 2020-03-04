package main;

import java.util.*;
//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

	private int antall;
	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt binært søketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et binært søketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		antall = 1;
		rot = new BinaerTreNode<T>(element);
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære trett er tomt og usann ellers.
	 *****************************************************************/
	@Override
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære treet er tom og usann ellers.
	 *****************************************************************/
	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	/*****************************************************************
	 * Returnerer den minimale teoretiske høyden ved bruk av math.
	 *****************************************************************/
	public int minimaleTeoretiskeHoyden() {
		int hoydeLog2Antall=(int) ((Math.log10(antall))  / (Math.log10(2))  );
		return hoydeLog2Antall;
	}

	/*****************************************************************
	 * Returnerer den minimale teoretiske høyden ved å telle hvor mange ganger vi kan devidere på 2 flere ganger.
	 *****************************************************************/		
	public int minimaleTeoretiskeHoyden2() {
		int n=antall;
		int hoyde=0;
		while(n!=1){
			n=n/2;
			hoyde++;
		}
		return hoyde;
	}

	
	/*****************************************************************
	 * Returnerer den maksimale teoretiske høyden.
	 *****************************************************************/		
	public int maksemaleTeoretiskeHoyden() {
		int maksemaleHoyde=antall-1;
		return maksemaleHoyde;
	}
	
	
	/*****************************************************************
	 * Returnerer høye som er lengden på den lengste stien fra roten til et blad.
	 *****************************************************************/
	public int hoyde() {
		int lengde=-1;
		lengde=(erTom())?-1:hoydeRek(rot);  
		return lengde;
	}
	
	private int hoydeRek(BinaerTreNode<T> p) {
		int count;
		if(p==null){
			count = -1;
		}else{
			count = 1;
			int countHoegre =  hoydeRek(p.getHoyre());
			int countVenstra =  hoydeRek(p.getVenstre());
			count += (countHoegre > countVenstra) ? countHoegre : countVenstra; //hvis -1 vil ==> count +(v/h) = 1+(-1)=0
		}
		
		return count ;
	}
	/**********************************************************************
	 * Legger det spesifiserte elementet på passende plass i BS-treet. Like
	 * elementer blir lagt til høyre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	@Override
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		// Den rekursive hjelpemetoden
		
		if (p == null) { // Tomt (under-)tre, lag node
			//Hvis p== null, vil lage ny node og retunere pekeren til node, som kommer til å bli satt til venster/høyre av hengig av forrige kall
			BinaerTreNode<T> ny = new BinaerTreNode<T>(element);
			return ny;
		} else if (element.compareTo(p.getElement()) < 0) {
			p.setVenstre(leggTilRek(p.getVenstre(), element)); //Hvis p.getVenstre()!= null, vil sette  "p.setVenstre(p.getVenstre())" uendret 
			return p;
		} else {
			p.setHoyre(leggTilRek(p.getHoyre(), element)); //Hvis p.getHoyre()!= null, vil sette  "p.setHoyre(p.getHoyre())" uendret
			return p;
		}
	}

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære
	 * søketreet. Like elementer blir lagt til høyre.
	 ******************************************************************/

	public void leggTil2(T element) {
		BinaerTreNode<T> temp = new BinaerTreNode<T>(element);
		if (erTom())
			rot = temp;
		else {
			BinaerTreNode<T> aktuell = rot;
			boolean lagtTil = false;

			while (!lagtTil) {
				if (element.compareTo(aktuell.getElement()) < 0) {
					if (aktuell.getVenstre() == null) {
						aktuell.setVenstre(temp);
						lagtTil = true;
					} else
						aktuell = aktuell.getVenstre();
				} // if
				else { // >=
					if (aktuell.getHoyre() == null) {
						aktuell.setHoyre(temp);
						lagtTil = true;
					} else
						aktuell = aktuell.getHoyre();
				} // else

			} // while
		}

		antall++;
	}

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette binære søketreet.
	 *********************************************************************/

	public void fjernMin2() {
		rot=fjernMinRek(rot);
	}

	public BinaerTreNode<T> fjernMinRek(BinaerTreNode<T> p) {
		if (p.getVenstre() == null) {
			antall--;
			return p.getHoyre();
		} else {
			p.setVenstre(fjernMinRek(p.getVenstre()));
			return p;
		}
	}
	

	/******************************************************************
	 * Fjerner noden med minste verdi fra dette binære søketreet.
	 *********************************************************************/
	public T fjernMin() {
		T resultat = null;

		if (!erTom()) {
			if (rot.getVenstre() == null) {
				resultat = rot.getElement();
				rot = rot.getHoyre();
			} else {
				BinaerTreNode<T> foreldre = rot;
				BinaerTreNode<T> aktuell = rot.getVenstre();
				while (aktuell.getVenstre() != null) {
					foreldre = aktuell;
					aktuell = aktuell.getVenstre();
				}
				resultat = aktuell.getElement();
				foreldre.setVenstre(aktuell.getHoyre());
			}

			antall--;
		}

		return resultat;
	}//

	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	
	public void fjernMaks2() {
		rot=fjernMaksRek(rot);		
	}

	public BinaerTreNode<T> fjernMaksRek(BinaerTreNode<T> p) {
		if (p.getHoyre() == null) {
			antall--;
			return p.getVenstre();
		} else {
			p.setHoyre(fjernMaksRek(p.getHoyre()));
			return p;
		}
	}
	
	
	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	public T fjernMaks() {
		T resultat = null;

		if (!erTom()) {
			if (rot.getHoyre() == null) {
				resultat = rot.getElement();
				rot = rot.getVenstre();
			} else {
				BinaerTreNode<T> foreldre = rot;
				BinaerTreNode<T> aktuell = rot.getHoyre();
				while (aktuell.getHoyre() != null) {
					foreldre = aktuell;
					aktuell = aktuell.getHoyre();
				}
				resultat = aktuell.getElement();
				foreldre.setHoyre(aktuell.getVenstre());
			}
			antall--;
		}
		return resultat;
	}//

	/******************************************************************
	 * Returnerer det minste elementet i dette binære søketreet.
	 ******************************************************************/
	public T finnMin() {

		T resultat = null;

		if (!erTom()) {
			BinaerTreNode<T> aktuell = rot;

			while (aktuell.getVenstre() != null)
				aktuell = aktuell.getVenstre();

			resultat = aktuell.getElement();
		}

		return resultat;
	}//

	/******************************************************************
	 * Returnerer det største elementet i dette binære søketreet.
	 ******************************************************************/
	public T finnMaks() {
		T resultat = null;

		if (!erTom()) {

			BinaerTreNode<T> aktuell = rot;

			while (aktuell.getHoyre() != null)
				aktuell = aktuell.getHoyre();

			resultat = aktuell.getElement();
		}

		return resultat;
	}//

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i
	 * dette BS-treet, null elles. Bruk av rekursjon /
	 ******************************************************************************/
	@Override
	public T finn(T element) {
		// Søk med rekursiv hjelpemetode
		return finnRek(rot,element);
	}

	// Den rekursive hjelpemetoden for søking
	private T finnRek(BinaerTreNode<T> p, T element) {
		T svar = null;
		if (p != null) {
			int sammenlign=element.compareTo(p.getElement());
			if ( sammenlign == 0) { // I rot
				svar = p.getElement();
			} else if ( sammenlign < 0) {
				svar = finnRek(p.getVenstre(), element); // I venstre u.t.
			} else {
				svar = finnRek(p.getHoyre(), element); // I høgre u.t.
			}
		}
		return svar;
	}

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i
	 * dette BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		// Søk med while-setning

		BinaerTreNode<T> p = rot;
		T svar = null;
		while (p != null && svar == null) {
			if (element.compareTo(p.getElement()) < 0)
				p = p.getVenstre();
			else if (element.compareTo(p.getElement()) > 0)
				p = p.getHoyre();
			else
				svar = p.getElement();
		}
		return svar;
	}

	/******************************************************************
	 * Returnerer en inordeniterator for elementene i bs-treet.
	 ******************************************************************/
	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);
	}

	// *****************************************************************
	// Gjennomgår treet i preorden
	// *****************************************************************

	public void visPreorden() {
		visRekPreorden(rot);
		System.out.println();
	}

	private void visRekPreorden(BinaerTreNode<T> p) {
		if (p != null) {
			System.out.print(p.getElement() + " ");
			visRekPreorden(p.getVenstre());
			visRekPreorden(p.getHoyre());
		}
	}

	// *****************************************************************
	// Gjennomgår treet i inorden
	// *****************************************************************

	public void visInorden() {
		visRekInorden(rot);
		System.out.println();
	}

	private void visRekInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visRekInorden(p.getVenstre());
			System.out.print(p.getElement() + " ");
			visRekInorden(p.getHoyre());
		}//else basis tilfellet
	}
	
	// *****************************************************************
	// Gjennomgår treet i postorden
	// *****************************************************************

	public void visPostorden() {
		visRekPostorden(rot);
		System.out.println();
	}

	private void visRekPostorden(BinaerTreNode<T> p) {
		if (p != null) {
			visRekPostorden(p.getVenstre());
			visRekPostorden(p.getHoyre());
			System.out.print(p.getElement() + " ");

		}
	}
	public BinaerTreNode<T> getRot() {
		return rot;
	}

}// class

// ************************************************************************
