package adt_en;


public interface StabelADT<T> {
/*
* Definerer interface til en stabel.
*/
/**
* Legger til et element på toppen av stabelen, utvider hvis behov
* @param element generisk element som stables på
*/
public void push (T element);
/**
* Fjerner et element på toppen av stabelen og returnerer referansen
* Kaster unntak EmptyCollectionException hvis stabelen allerede er tom.
* @return T element fjernes fra toppen av stabelen
* @throws EmptyCollectionException når stabelen er tom
*/
public T pop() throws EmptyCollectionException;

/**
* Returenerer referansen til elementet på toppen av stabelen.
* Elementet blir ikke fjernet.
* Kaster unntaket EmptyCollectionException hvis stabelen allerede er tom.
* @return element på toppen av stabelen.
* @throws EmptyCollectionException når stabelen er tom
*/
public T peek() throws EmptyCollectionException;
/**
* Returnerer sann hvis stabelen ikke har elementer ellers returneres usann
* @return sann hvis stabelen er tom ellers usann
*/
public boolean erTom();
/**
* Returnerer antall elementer på stabelen.
* @return antall elementer på stabelen
*/
public int antall();


}


