package tabell_koe;

import java.util.Random;

import Iterator.Iterator;
import adt_en.EmptyCollectionException;
import adt_en.KoeADT;

/********************************************************************
	//
	// Representerer en tabell implementasjon av samling kø.
	// front til køen er alltid i posisjon 0.
	//********************************************************************/
public class TabellKoe<T> implements KoeADT<T> {
	private static Random tilf= new Random();
	private final int STDK = 100;
	private int bak;
	private T[] koe;

	/******************************************************************
Oppretter en tom kø med standard størrelse.
 ******************************************************************/
public TabellKoe() {
	bak = 0;
	koe = (T[]) new Object[STDK];
}

/******************************************************************
Oppretter en tom kø med spesifisert kapasitet..
 ******************************************************************/
public TabellKoe (int startKapasitet){
	bak = 0;
	koe = (T[])(new Object[startKapasitet]);
}

/******************************************************************
Legger til et spesifisert element bak i køen, utvider hvis nødvendig
 ******************************************************************/
@Override
public void innKoe(T element) {
	if (antall() == koe.length){
		utvid();
	}
	koe[bak] = element; // bak er posisjonen til neste ledige
	bak++;
}

/******************************************************************
Fjerner elementet foran i køen.
 ******************************************************************/
@Override
public T utKoe() {

	
	if (erTom())
		throw new EmptyCollectionException("koe");

	T resultat = null;
	resultat = koe[0];
	bak--;

		// flytter elementene en plass frem 
	for (int soek=0; soek < bak; soek++){
		koe[soek] = koe[soek+1];
	}
	koe[bak] = null; // kan sløyfes
	return resultat;
}

/******************************************************************
utvider tabellen med ekstra plass (tabell.length*1.1)+1)
legg merke til at hvis tabellen har 9 plasser,vil ikke skjer noe i tilfelle (koe.length*1.1)
******************************************************************/

public void utvid() {
	T[] hjelpeTabell = (T[])(new Object[(int) ((koe.length*1.1)+1)]);//10% +1 i tilfelle tabellen er mindre enn 10
	for (int indeks =0; indeks < koe.length; indeks++){
		hjelpeTabell[indeks] = koe[indeks];
	}
	koe = hjelpeTabell;
}


/******************************************************************
retunerer den foerste elemen i koen
******************************************************************/
@Override
public T foerste() {

	if (erTom())
		throw new EmptyCollectionException("koe");


	return koe[0];
}

/******************************************************************
sjekker om tabellen er tom
******************************************************************/
@Override
public boolean erTom() {
	return (bak==0);
}

/******************************************************************
retunerer antall elementer
******************************************************************/
@Override
public int antall() {
	return bak;
}

@Override
public T fjernTilfeldig() {
	T svar = null;
	if (bak>0){
		int indeks = tilf.nextInt(bak);
		svar = koe[indeks];
		koe[indeks] = koe[bak-1];
		koe[bak-1] = null; //kan ha med, men ikke nødvendig
		bak--;
	}
	return svar;
}

@Override
public T fjern(T element) {
	int pos = -1;
	T svar= null;
	if (!erTom()) {
		for(int i = 0; (i<bak)&&(pos==-1); i++){
			if(koe[i].equals(element))
				pos = i;
		}

		if (pos!=-1) { // funnet, skal så slette
			svar=koe[pos];
			koe[pos]=koe[bak-1];
			bak--;
		}

	}
	return(svar);
}

@Override
public boolean inneholder(T element) {
	int pos = -1;
	for(int i = 0; (i<bak)&&(pos==-1); i++){
		if(koe[i].equals(element))
			pos = i;
	}
	return(pos!=-1);
}

@Override
public KoeADT<T> union(KoeADT<T> m2) {
	TabellKoe<T> begge = new TabellKoe<T>();
	T elem=null;

	//legger inn this "koe"
	for (int i = 0; i<bak; i++){
		begge.innKoe(koe[i]);
	}

	//legger in m2 "mengde"
	Iterator<T> teller = m2.oppramser();
	while (teller.hasNext()){
		elem=teller.next();
		begge.innKoe(elem);
	}
	return begge;

	
}

@Override
public KoeADT<T> snitt(KoeADT<T> m2) {
	TabellKoe<T> snittM = new TabellKoe<T>();
	T element;    
	Iterator<T> teller = m2.oppramser();
	while (teller.hasNext()){
		element = teller.next();
		if(this.inneholder(element))
			snittM.innKoe(element);
	}
	return snittM;

}

@Override
public KoeADT<T> differens(KoeADT<T> m2) {
	TabellKoe<T> differensM = new TabellKoe<T>();
	T element;    
	Iterator<T> teller = this.oppramser();
	while (teller.hasNext()){
		element = teller.next();
		if(!m2.inneholder(element))
			differensM.innKoe(element);
	}
	return differensM;

}

@Override
public Iterator<T> oppramser() {
	
	return new TabellIterator<T>(koe, bak);
}

}