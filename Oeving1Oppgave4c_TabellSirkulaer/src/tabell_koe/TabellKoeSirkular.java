package tabell_koe;

import adt_en.EmptyCollectionException;
import adt_en.KoeADT;

/********************************************************************
	//
	// Representerer en tabell implementasjon av samling kّ.
	// front til kّen er alltid i posisjon 0.
	//********************************************************************/
public class TabellKoeSirkular<T> implements KoeADT<T> {
	private final int STDK = 9;
	private int front, bak, antall;
	private T[] koe;

	/******************************************************************
Oppretter en tom kّ med standard stّrrelse.
 ******************************************************************/
public TabellKoeSirkular() {
	front= bak= antall = 0;
	koe = (T[]) new Object[STDK];
}

/******************************************************************
Oppretter en tom kّ med spesifisert kapasitet..
 ******************************************************************/
public TabellKoeSirkular (int startKapasitet){
	front=bak= antall = 0;
	koe = (T[])(new Object[startKapasitet]);
}

/******************************************************************
Legger til et spesifisert element bak i kّen, utvider hvis nّdvendig
 ******************************************************************/
@Override
public void innKoe(T element) {
	if (antall() == koe.length){
		utvid();
	}
	koe[bak] = element; // bak er posisjonen til neste ledige
	bak=(bak+1) % koe.length;
	antall++;
}

/******************************************************************
Fjerner elementet foran i kّen.
 ******************************************************************/
@Override
public T utKoe() {
	if (erTom())
		throw new EmptyCollectionException("koe");

	T resultat = null;
	resultat = koe[front];
		koe[front]=null;
		front=(front+1)% koe.length;
		antall--;
	
	// trnger ikke å flytte elementene en plass frem 

	return resultat;
}

/******************************************************************
utvider tabellen med ekstra plass (tabell.length*1.1)+1)
legg merke til at hvis tabellen har 9 plasser,vil ikke skjer noe i tilfelle (koe.length*1.1)
******************************************************************/

private void utvid() {
	T[] hjelpeTabell = (T[])(new Object[(int) ((koe.length*1.1)+1)]);//10% +1 i tilfelle tabellen er mindre enn 10
	for (int indeks =0; indeks < antall; indeks++){
		hjelpeTabell[indeks] = koe[front];
		front=(front+1)%koe.length;
	}
	front = 0;
	bak = antall;
	koe = hjelpeTabell;
	
	}


/******************************************************************
retunerer den foerste elemen i koen
******************************************************************/
@Override
public T foerste() {
	if (erTom())
		throw new EmptyCollectionException("koe");

	
	return koe[front];
}

/******************************************************************
sjekker om tabellen er tom
******************************************************************/
@Override
public boolean erTom() {
	return (antall==0);
}

/******************************************************************
retunerer antall elementer
******************************************************************/
@Override
public int antall() {
	return antall;
}

}