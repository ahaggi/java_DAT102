package adt_en;

import Iterator.Iterator;

public interface KoeADT<T>{ //Bruk javadoc i stedet for kommentarer som her
// Bruke @Override før metodene i implementasjonsfil
/** Legge til et element bak i køen. */
void innKoe (T element);
/** Fjerner og returnerer elementet foran i køen.*/
T utKoe();
/** Returnerer elementet foran i køen uten å fjerne det fra køen. */
T foerste();
/** Returns sann hvis denne køene ikke inneholder noen elementer.. */
boolean erTom();
/** Returnerer antall elementer i køen. */
int antall();

T fjernTilfeldig();

T fjern(T element);

boolean inneholder(T element);

KoeADT<T> union (KoeADT<T> m2);

KoeADT<T> snitt (KoeADT<T> m2);

KoeADT<T> differens (KoeADT<T> m2);

Iterator<T> oppramser();

}